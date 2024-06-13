package mk.ukim.finki.wp.chekalna.service.implementations;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.chekalna.model.Room;
import mk.ukim.finki.wp.chekalna.repository.RoomRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
