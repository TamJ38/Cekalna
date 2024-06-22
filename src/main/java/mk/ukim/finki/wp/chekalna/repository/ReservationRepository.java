package mk.ukim.finki.wp.chekalna.repository;

import mk.ukim.finki.wp.chekalna.model.Reservation;
import mk.ukim.finki.wp.chekalna.model.Student;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaSpecificationRepository<Reservation, String>{
    Optional<Reservation> findByNumber(Number number);
    List<Reservation> findAllByStudent(Student student);
}
