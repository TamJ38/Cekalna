package mk.ukim.finki.wp.chekalna.repository;

import mk.ukim.finki.wp.chekalna.model.TimeTaken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTakenRepository extends JpaRepository<TimeTaken, Long> {
}
