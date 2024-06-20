package mk.ukim.finki.wp.chekalna.service.interfaces;

import mk.ukim.finki.wp.chekalna.model.Number;
import mk.ukim.finki.wp.chekalna.model.Reservation;
import mk.ukim.finki.wp.chekalna.model.Student;

import java.util.List;

public interface ReservationService {
    Reservation save(Reservation reservation);
    void deleteById(List<String> ids);
    Reservation findbyNumberId(Long numberId);

    List<Reservation> findAllByStudent(Student student);
}
