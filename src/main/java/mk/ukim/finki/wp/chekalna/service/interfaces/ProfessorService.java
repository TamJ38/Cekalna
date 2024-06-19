package mk.ukim.finki.wp.chekalna.service.interfaces;

import mk.ukim.finki.wp.chekalna.model.Professor;
import mk.ukim.finki.wp.chekalna.model.exceptions.ProfessorNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {


    List<Professor> getAllProfessors();

    Professor getProfessorById(String id) throws ProfessorNotFoundException;

    List<Professor> findProfessorsByName(String name);

    Optional<Professor> findById(String username);
}
