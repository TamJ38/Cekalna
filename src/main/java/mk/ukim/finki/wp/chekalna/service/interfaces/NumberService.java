package mk.ukim.finki.wp.chekalna.service.interfaces;


import mk.ukim.finki.wp.chekalna.model.Number;

import java.util.List;
import java.util.Optional;

public interface NumberService {
    List<Number> getAllNumbers();
    Optional<Number>  findById(Long id);
    List<Number> getAvailableNumbers();
    Number saveNumber(Number number);


}
