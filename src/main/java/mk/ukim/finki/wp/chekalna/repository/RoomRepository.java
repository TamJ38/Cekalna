package mk.ukim.finki.wp.chekalna.repository;

import mk.ukim.finki.wp.chekalna.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaSpecificationRepository<Room, String> {
}
