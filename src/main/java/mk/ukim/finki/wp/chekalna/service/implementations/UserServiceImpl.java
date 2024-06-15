package mk.ukim.finki.wp.chekalna.service.implementations;

import mk.ukim.finki.wp.chekalna.model.User;
import mk.ukim.finki.wp.chekalna.repository.UserRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(String  id) {
        return userRepository.findById(id);
    }
}
