package mk.ukim.finki.wp.chekalna.web.controller;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.chekalna.model.Professor;
import mk.ukim.finki.wp.chekalna.service.interfaces.ProfessorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProfessorsController {

    private final ProfessorService professorService;

    @GetMapping("/")
    public String showAllProfessors(@RequestParam(value = "search", required = false) String search, Model model) {
        List<Professor> professors;
        if (search != null && !search.isEmpty()) {
            professors = professorService.findProfessorsByName(search);
        } else {
            professors = professorService.getAllProfessors();
        }
        model.addAttribute("professors", professors);
        return "professors";
    }
}
