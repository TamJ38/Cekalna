package mk.ukim.finki.wp.chekalna.web.controller;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.chekalna.model.*;
import mk.ukim.finki.wp.chekalna.model.Number;
import mk.ukim.finki.wp.chekalna.model.enums.NumberStatus;
import mk.ukim.finki.wp.chekalna.service.interfaces.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final ConsultationService consultationService;
    private final StudentService studentService;
    private final NumberService numberService;
    private final UserService userService;

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
        Student student = studentService.getStudentById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id: " + user.getId()));

        Consultation consultation = consultationService.findById(consultationId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid consultation Id: " + consultationId));
        number.setStatus(NumberStatus.APPROVED);
        numberService.saveNumber(number);
        Reservation reservation = new Reservation();
        reservation.setNumber(number);
        reservation.setStudent(student);
        reservation.setConsultation(consultation);
        reservation.setProfessor(consultation.getProfessor());
        reservation.setStartDate(consultation.getStartTime());
        reservation.setEndDate(consultation.getEndTime());
        reservationService.save(reservation);

        return "redirect:/";
    }
}
