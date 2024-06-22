package mk.ukim.finki.wp.chekalna.service.implementations;


import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.chekalna.model.Professor;
import mk.ukim.finki.wp.chekalna.model.exceptions.ProfessorNotFoundException;
import mk.ukim.finki.wp.chekalna.repository.ProfessorRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.ProfessorService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    @Override
    public List<Professor> getAllProfessors() {
//        return professorRepository.findAll(Sort.by("email"));
        return professorRepository.findAll(Sort.by("name"));
    }

    @Override
    public Professor getProfessorById(String id) throws ProfessorNotFoundException {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ProfessorNotFoundException("Professor with id " + id + " doesn't exist"));
    }

    public List<Professor> findProfessorsByName(String name) {
        return professorRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Optional<Professor> findById(String username) {
        return professorRepository.findById(username);
    }

}
