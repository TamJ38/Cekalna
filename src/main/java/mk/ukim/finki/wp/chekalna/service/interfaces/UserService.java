package mk.ukim.finki.wp.chekalna.service.interfaces;

import mk.ukim.finki.wp.chekalna.model.Number;
import mk.ukim.finki.wp.chekalna.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(String id);

}
