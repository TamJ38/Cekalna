package mk.ukim.finki.wp.chekalna.service.implementations;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.chekalna.model.Consultation;
import mk.ukim.finki.wp.chekalna.model.Number;
import mk.ukim.finki.wp.chekalna.model.enums.ConsultationType;
import mk.ukim.finki.wp.chekalna.model.enums.NumberStatus;
import mk.ukim.finki.wp.chekalna.model.exceptions.ConsultationNotFound;
import mk.ukim.finki.wp.chekalna.repository.ConsultationRepository;
import mk.ukim.finki.wp.chekalna.repository.ProfessorRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.ConsultationService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {


    private final ConsultationRepository consultationRepository;
    private final ProfessorRepository professorRepository;

    public Consultation saveConsultation(Consultation consultation,  Integer numberOfStudents) {
        for (int i = 1; i <= numberOfStudents; i++) {
            Number number = new Number();
            number.setNumber(i);
            number.setStatus(NumberStatus.PENDING);
            consultation.addNumber(number);
        }
        return consultationRepository.save(consultation);    }

    public Optional<Consultation> findById(Long id) {
        return consultationRepository.findById(id);
    }

    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }

    public Consultation updateConsultation(Long id, String location, ConsultationType type, LocalDate oneTimeDate, DayOfWeek weeklyDayOfWeek, LocalTime startTime, LocalTime endTime) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new ConsultationNotFound("Consultation not found with id: " + id));

        consultation.setLocation(location);
        consultation.setType(type);
        consultation.setOneTimeDate(oneTimeDate);
        consultation.setWeeklyDayOfWeek(weeklyDayOfWeek);
        consultation.setStartTime(startTime);
        consultation.setEndTime(endTime);

        consultationRepository.save(consultation);
        return consultation;
    }

    public List<Consultation> getConsultationsByProfessor(String professorId) {
        var professor = professorRepository.findById(professorId).orElseThrow();
        return consultationRepository.getConsultationsByProfessor(professor);
    }
}


