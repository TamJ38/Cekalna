package mk.ukim.finki.wp.chekalna.repository;

import mk.ukim.finki.wp.chekalna.model.Professor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaSpecificationRepository<Professor, String> {
}