package mk.ukim.finki.wp.chekalna.repository;

import mk.ukim.finki.wp.chekalna.model.Number;
import mk.ukim.finki.wp.chekalna.model.enums.NumberStatus;

import java.util.List;
import java.util.Optional;

public interface NumberRepository extends JpaSpecificationRepository<Number, Long> {
    Optional<Number>findById(Long id);
    List<Number> findByStatus(NumberStatus status);

}