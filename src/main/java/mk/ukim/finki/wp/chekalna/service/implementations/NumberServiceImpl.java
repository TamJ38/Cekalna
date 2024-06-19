package mk.ukim.finki.wp.chekalna.service.implementations;

import mk.ukim.finki.wp.chekalna.model.Consultation;
import mk.ukim.finki.wp.chekalna.model.Number;
import mk.ukim.finki.wp.chekalna.model.enums.NumberStatus;
import mk.ukim.finki.wp.chekalna.repository.ConsultationRepository;
import mk.ukim.finki.wp.chekalna.repository.NumberRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.NumberService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class NumberServiceImpl implements NumberService {
    private final NumberRepository numberRepository;
    private final ConsultationRepository consultationRepository;

    public NumberServiceImpl(NumberRepository numberRepository, ConsultationRepository consultationRepository) {
        this.numberRepository = numberRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public List<Number> getAllNumbers() {
        return numberRepository.findAll();
    }

    @Override
    public Optional<Number> findById(Long id) {
        return numberRepository.findById(id);
    }

    @Override
    public List<Number> getAvailableNumbers() {
        return numberRepository.findByStatus(NumberStatus.PENDING);
    }

    @Override
    public Number saveNumber(Number number) {
        return numberRepository.save(number);
    }

    @Override
    public void deleteByid(List<Long> ids) {
        this.numberRepository.deleteAllById(ids);
    }

    public List<Number> findByConsultationId(Long consultationId) {
        return numberRepository.findByConsultationIdOrderByNumberAsc(consultationId);
    }

    @Override
    public List<Number> createNumberForConsultation(Long consultationId) {
        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid consultation Id: " + consultationId));
        List<Number> numberList = new ArrayList<>();
        for (int i = 1; i <= consultation.getMaxStudents(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(consultation.getType().name().charAt(0)).append(i);
            Number newNumber = new Number();
            newNumber.setNumber(stringBuilder.toString().toUpperCase());
            newNumber.setConsultation(consultation);
            newNumber.setStatus(NumberStatus.PENDING);
            numberList.add(newNumber);
        }
        return numberRepository.saveAll(numberList);
    }
}

