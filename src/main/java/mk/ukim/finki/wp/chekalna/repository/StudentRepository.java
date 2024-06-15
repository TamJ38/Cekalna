package mk.ukim.finki.wp.chekalna.repository;


import mk.ukim.finki.wp.chekalna.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaSpecificationRepository<Student, String>{
    Optional<Student> findByEmail(String email);
}
