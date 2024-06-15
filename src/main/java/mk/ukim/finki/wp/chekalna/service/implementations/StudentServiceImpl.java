package mk.ukim.finki.wp.chekalna.service.implementations;

import mk.ukim.finki.wp.chekalna.model.DTO.StudentDto;
import mk.ukim.finki.wp.chekalna.model.Student;
import mk.ukim.finki.wp.chekalna.repository.StudentRepository;
import mk.ukim.finki.wp.chekalna.service.interfaces.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private  final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public Page<Student> find(Integer page, Integer size, String nameOrIndex, String studyProgramCode) {
        return null;
    }

    @Override
    public List<StudentDto> importStudents(List<StudentDto> students) {
        return null;
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}
