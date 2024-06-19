package mk.ukim.finki.wp.chekalna.web.controller;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.chekalna.model.*;
import mk.ukim.finki.wp.chekalna.model.Number;
import mk.ukim.finki.wp.chekalna.model.enums.ConsultationType;
import mk.ukim.finki.wp.chekalna.model.enums.NumberStatus;
import mk.ukim.finki.wp.chekalna.repository.ConsultationRepository;
import mk.ukim.finki.wp.chekalna.repository.NumberRepository;
import mk.ukim.finki.wp.chekalna.repository.ReservationRepository;
import mk.ukim.finki.wp.chekalna.repository.TimeTakenRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
public class ConsultationController {

    private final ProfessorService professorService;
    private final ConsultationService consultationService;
    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;
    private final NumberService numberService;
    private final RoomService roomService;
    private final NumberRepository numberRepository;
    private final TimeTakenRepository timeTakenRepository;
    private final ConsultationRepository consultationRepository;


    @GetMapping("/consultations/form")
    public String showConsultationForm(@RequestParam("professorId") String professorId,
                                       @RequestParam(value = "consultationId", required = false) Long consultationId,
                                       Model model) {
        Map<DayOfWeek, String> dayOfWeekMap = Map.of(
                DayOfWeek.MONDAY, "Понеделник",
                DayOfWeek.TUESDAY, "Вторник",
                DayOfWeek.WEDNESDAY, "Среда",
                DayOfWeek.THURSDAY, "Четврток",
                DayOfWeek.FRIDAY, "Петок",
                DayOfWeek.SATURDAY, "Сабота",
                DayOfWeek.SUNDAY, "Недела"
        );

        Professor professor = professorService.getProfessorById(professorId);
        model.addAttribute("professor", professor);


        Consultation consultation = null;
        String formattedOneTimeDate = "";
        if (consultationId != null) {
            consultation = consultationService.findById(consultationId).orElse(null);
            if (consultation != null && consultation.getOneTimeDate() != null) {
                formattedOneTimeDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(consultation.getOneTimeDate());
            }
        }
        model.addAttribute("consultation", consultation);
        model.addAttribute("formattedOneTimeDate", formattedOneTimeDate);


        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        model.addAttribute("consultationTypes", ConsultationType.values());
        model.addAttribute("daysOfWeek", dayOfWeekMap);
        return "manage-consultation-form";
    }


    @PostMapping("/consultations/add")
    public String addConsultation(@ModelAttribute Consultation consultation,
                                  @RequestParam("professorId") String professorId,
                                  @RequestParam("maxStudents") Integer maxStudents) {
        Professor professor = professorService.getProfessorById(professorId);
        consultation.setProfessor(professor);
        consultationService.saveConsultation(consultation, maxStudents);
        return "redirect:/professors";
    }


    @PostMapping("/consultations/update/{id}")
    public String updateConsultation(@PathVariable Long id,
                                     @RequestParam String location,
                                     @RequestParam ConsultationType type,
                                     @RequestParam(required = false) LocalDate oneTimeDate,
                                     @RequestParam DayOfWeek weeklyDayOfWeek,
                                     @RequestParam LocalTime startTime,
                                     @RequestParam LocalTime endTime,
                                     Model model) {
        // TO DO - it aint working if there's reservations
        consultationService.updateConsultation(id, location, type, oneTimeDate, weeklyDayOfWeek, startTime, endTime);
        return "redirect:/professors";
    }


    @PostMapping("/consultations/delete/{id}")
    public String deleteConsultation(@PathVariable("id") Long id) {
        consultationService.findById(id).ifPresent(consultation -> {
            // TO DO - it aint working if there's reservations
            consultationService.deleteConsultation(id);
        });

        return "redirect:/professors";
    }

    @GetMapping("/consultations/{username}")
    public String myConsultationsView(@PathVariable String username, Model model) {
        var consultations = consultationService.getConsultationsByProfessor(username);

        Map<DayOfWeek, String> dayOfWeekMap = Map.of(
                DayOfWeek.MONDAY, "Понеделник",
                DayOfWeek.TUESDAY, "Вторник",
                DayOfWeek.WEDNESDAY, "Среда",
                DayOfWeek.THURSDAY, "Четврток",
                DayOfWeek.FRIDAY, "Петок",
                DayOfWeek.SATURDAY, "Сабота",
                DayOfWeek.SUNDAY, "Недела"
        );

        model.addAttribute("username", username);
        model.addAttribute("consultations", consultations);
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("timeNow", LocalTime.now());
        model.addAttribute("daysOfWeek", dayOfWeekMap);

        return "my-consultations";
    }

    @GetMapping("/consultations/update/{id}/{numberId}/{username}")
    public String updateQueue(@PathVariable int id, @PathVariable int numberId, @PathVariable String username, Model model) {
        Number currentNumber = numberService.findById((long) numberId)
                    .orElseThrow(() -> new RuntimeException("Number not found!"));
        Reservation currentReservation = reservationService.findbyNumberId((long) numberId);
        if (currentReservation != null) {
                currentNumber.setStatus(NumberStatus.FINISHED);
                numberRepository.save(currentNumber);

                currentReservation.setEndDate(LocalTime.now());
                currentReservation.setNumber(currentNumber);
                reservationService.save(currentReservation);

                ///
                Consultation currentConsultion=this.consultationService.findById((long)id).orElseThrow(()->new RuntimeException(""));

                List<TimeTaken>timeTakenList=currentConsultion.getWaitingTime();
                timeTakenList.add(timeTakenRepository.save(new TimeTaken(currentReservation.getStartDate(),currentReservation.getEndDate())));
                currentConsultion.setWaitingTime(timeTakenList);
                this.consultationRepository.save(currentConsultion);
                this.consultationService.calcualteAverageWaitingTime(currentConsultion.getId());

                this.consultationService.nextInQueue(id);
                var consultations = consultationService.getConsultationsByProfessor(username);
                Consultation consultation = this.consultationService.getConsultationById(id);
                if (!consultation.getReservations().isEmpty()) {
                    Reservation nextReservation = consultation.getReservations().get(0);
                    nextReservation.setStartDate(LocalTime.now());
                    this.reservationRepository.save(nextReservation);
                } else {
                    model.addAttribute("message", "No more reservations in queue.");
                }

          Map<DayOfWeek, String> dayOfWeekMap = Map.of(
                DayOfWeek.MONDAY, "Понеделник",
                DayOfWeek.TUESDAY, "Вторник",
                DayOfWeek.WEDNESDAY, "Среда",
                DayOfWeek.THURSDAY, "Четврток",
                DayOfWeek.FRIDAY, "Петок",
                DayOfWeek.SATURDAY, "Сабота",
                DayOfWeek.SUNDAY, "Недела"
          );

          model.addAttribute("username", username);
          model.addAttribute("consultations", consultations);
          model.addAttribute("today", LocalDate.now());
          model.addAttribute("timeNow", LocalTime.now());
          model.addAttribute("daysOfWeek", dayOfWeekMap);
          } else {
                model.addAttribute("error", "Reservation not found for the given number ID.");
            }

        return "my-consultations";
    }
}


