package mk.ukim.finki.wp.chekalna.service.implementations;

import mk.ukim.finki.wp.chekalna.model.Number;
import mk.ukim.finki.wp.chekalna.model.enums.NumberStatus;
import mk.ukim.finki.wp.chekalna.repository.NumberRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.NumberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NumberServiceImpl implements NumberService {
    private final NumberRepository numberRepository;

    public NumberServiceImpl(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
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
}
