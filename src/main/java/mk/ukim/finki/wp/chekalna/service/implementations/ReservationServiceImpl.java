package mk.ukim.finki.wp.chekalna.service.implementations;

import mk.ukim.finki.wp.chekalna.model.Reservation;
import mk.ukim.finki.wp.chekalna.repository.ReservationRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.ReservationService;
import org.springframework.stereotype.Service;

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
}
