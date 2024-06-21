package mk.ukim.finki.wp.chekalna.service.implementations;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.chekalna.model.Consultation;
import mk.ukim.finki.wp.chekalna.model.Number;
import mk.ukim.finki.wp.chekalna.model.Professor;
import mk.ukim.finki.wp.chekalna.model.Student;
import mk.ukim.finki.wp.chekalna.model.enums.ConsultationType;
import mk.ukim.finki.wp.chekalna.model.enums.NumberStatus;
import mk.ukim.finki.wp.chekalna.model.exceptions.ConsultationNotFound;
import mk.ukim.finki.wp.chekalna.repository.ConsultationRepository;
import mk.ukim.finki.wp.chekalna.repository.ProfessorRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.ConsultationService;
import mk.ukim.finki.wp.chekalna.service.interfaces.ProfessorService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {


    private final ConsultationRepository consultationRepository;
    private final ProfessorRepository professorRepository;
    private final ProfessorService professorService;

    public Consultation saveConsultation(Consultation consultation, Integer numberOfStudents) {
        for (int i = 1; i <= numberOfStudents; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(consultation.getType().name().charAt(0)).append(i);
            Number number = new Number();
            number.setNumber(stringBuilder.toString().toUpperCase());
            number.setStatus(NumberStatus.PENDING);
            consultation.addNumber(number);
        }
        return consultationRepository.save(consultation);
    }

    public Optional<Consultation> findById(Long id) {
        return consultationRepository.findById(id);
    }

    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }

    public Consultation updateConsultation(Long id, String location, ConsultationType type, LocalDate oneTimeDate, DayOfWeek weeklyDayOfWeek, LocalTime startTime, LocalTime endTime, Integer maxStudents) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new ConsultationNotFound("Consultation not found with id: " + id));

        consultation.setLocation(location);
        consultation.setType(type);
        consultation.setOneTimeDate(oneTimeDate);
        consultation.setWeeklyDayOfWeek(weeklyDayOfWeek);
        consultation.setStartTime(startTime);
        consultation.setEndTime(endTime);
        consultation.setMaxStudents(maxStudents);

        consultationRepository.save(consultation);
        return consultation;
    }

    @Override
    public void calcualteAverageWaitingTime(Long id) {
        Consultation currentConsultation = findById(id).orElseThrow(() -> new ConsultationNotFound("Consultation not found with id: " + id));
        LongSummaryStatistics summaryStatistics = currentConsultation.getWaitingTime().stream().mapToLong(i -> i.calculateTime()).summaryStatistics();
        currentConsultation.setTimeTaken((int) Math.floor(summaryStatistics.getAverage()));
        consultationRepository.save(currentConsultation);
    }

    public List<Consultation> getConsultationsByProfessor(String professorId) {
        var professor = professorRepository.findById(professorId).orElseThrow();
        return consultationRepository.getConsultationsByProfessor(professor);
    }

    public Consultation getConsultationById(int id) {
        return consultationRepository.findById((long) id).orElseThrow();
    }

    public boolean nextInQueue(int id) {
        var consultation = this.getConsultationById(id);
        if (consultation.getReservations().size() > 0)
            consultation.getReservations().remove(0);
        consultationRepository.save(consultation);
        return true;
    }

    @Override
    public void copyConsultation(String professorId, Integer maxStudents, String location, ConsultationType type, LocalDate oneTimeDate, DayOfWeek weeklyDayOfWeek, LocalTime startTime, LocalTime endTime) {
        Consultation consultation = new Consultation();
        Professor professor = professorService.getProfessorById(professorId);
        consultation.setProfessor(professor);
        consultation.setLocation(location);
        consultation.setType(type);
        consultation.setOneTimeDate(oneTimeDate);
        consultation.setWeeklyDayOfWeek(weeklyDayOfWeek);
        consultation.setStartTime(startTime);
        consultation.setEndTime(endTime);
        consultation.setMaxStudents(maxStudents);
        saveConsultation(consultation, maxStudents);
    }

    @Override
    public boolean hasBooked(Consultation consultation, Student student) {
        return consultation.getReservations().
                stream().anyMatch(i -> i.getStudent().getIndex().
                        equals(student.getIndex()));

    }


}


