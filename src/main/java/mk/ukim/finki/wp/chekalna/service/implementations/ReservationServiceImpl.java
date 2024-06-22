package mk.ukim.finki.wp.chekalna.service.implementations;

import mk.ukim.finki.wp.chekalna.model.Number;
import mk.ukim.finki.wp.chekalna.model.Reservation;
import mk.ukim.finki.wp.chekalna.model.Student;
import mk.ukim.finki.wp.chekalna.model.enums.NumberStatus;
import mk.ukim.finki.wp.chekalna.repository.ReservationRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }


    @Override
    public void deleteById(List<String> ids) {
        this.reservationRepository.deleteAllById(ids);
    }

    @Override
    public Reservation findbyNumberId(Long numberId) {
        return this.reservationRepository.findAll().stream().filter(reservation -> Objects.equals(reservation.getNumber().getId(), numberId)).findFirst().orElse(null);
    }

    @Override
    public List<Reservation> findAllByStudent(Student student) {
        return reservationRepository.findAllByStudent(student).
                stream().filter(reservation -> reservation.getNumber().getStatus() == NumberStatus.APPROVED).toList();
    }
}
