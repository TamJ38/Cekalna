package mk.ukim.finki.wp.chekalna.web.controller;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.chekalna.model.*;
import mk.ukim.finki.wp.chekalna.model.Number;
import mk.ukim.finki.wp.chekalna.model.enums.NumberStatus;
import mk.ukim.finki.wp.chekalna.model.utils.Constants;
import mk.ukim.finki.wp.chekalna.repository.ConsultationRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final ConsultationService consultationService;
    private final StudentService studentService;
    private final NumberService numberService;
    private final UserService userService;
    private final ConsultationRepository consultationRepository;

    @GetMapping("/consultation/{consultationId}")
    public String showReservationForm(@PathVariable Long consultationId, Model model, Principal principal) {
        Consultation consultation = consultationService.findById(consultationId)
                .orElse(null);
        if (consultation == null) {
            return "redirect:/professors";
        }
        String studentEmail = principal.getName();

        User user = userService.findById(studentEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        List<Number> consultationNumbers = numberService.findByConsultationId(consultationId);
        if (consultationNumbers.isEmpty()) {
            consultationNumbers = numberService.createNumberForConsultation(consultationId);
        }
        Collections.sort(consultationNumbers, Comparator.comparing(Number::getId));
        model.addAttribute("consultation", consultation);
        model.addAttribute("student", user);
        model.addAttribute("numbers", consultationNumbers);
        model.addAttribute("NumberStatus", NumberStatus.values());

        return "reservation-termin";
    }

    @PostMapping("/reserve")
    public String reserveNumber(@RequestParam("numberId") Long numberId,
                                @RequestParam("consultationId") Long consultationId,
                                Principal principal) {
        Number number = numberService.findById(numberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid number Id: " + numberId));

        String studentEmail = principal.getName();
        User user = userService.findById(studentEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Student student = studentService.findByEmail(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id: " + user.getId()));

        Consultation consultation = consultationService.findById(consultationId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid consultation Id: " + consultationId));
        number.setStatus(NumberStatus.APPROVED);
        numberService.saveNumber(number);
        reservationService.save(new Reservation(student, consultation.getProfessor(), consultation.getStartTime(), consultation.getEndTime(), number, consultation));

        return "redirect:/";
    }

    @GetMapping("/{username}")
    public String showReservations(@PathVariable String username, Model model) {

        Student student = studentService.findByEmail(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
        List<Reservation> reservationList = reservationService.findAllByStudent(student);

        reservationList.forEach(reservation -> {
            reservation.getConsultation().setReservations(
                    reservation.getConsultation().getReservations().stream().sorted(Comparator.comparing(Reservation::getId)).toList()
            );
        });

        model.addAttribute("today", LocalDate.now());
        model.addAttribute("timeNow", LocalTime.now());
        model.addAttribute("daysOfWeek", Constants.dayOfWeekMap);
        model.addAttribute("reservations", reservationList.stream().sorted(Comparator.comparing(Reservation::getId)).toList());
        return "my-reservations";
    }
}
