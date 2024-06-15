package mk.ukim.finki.wp.chekalna.service.interfaces;

import mk.ukim.finki.wp.chekalna.model.Consultation;
import mk.ukim.finki.wp.chekalna.model.enums.ConsultationType;



import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ConsultationService {
    Consultation saveConsultation(Consultation consultation,Integer numberOfStudents);

    Optional<Consultation> findById(Long id);

    List<Consultation> findAll();

    void deleteConsultation(Long id);

    public Consultation updateConsultation(Long id, String location, ConsultationType type, LocalDate oneTimeDate, DayOfWeek weeklyDayOfWeek, LocalTime startTime, LocalTime endTime);
}