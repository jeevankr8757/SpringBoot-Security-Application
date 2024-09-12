package SpringSecurityproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import SpringSecurityproject.Entity.Students;
import SpringSecurityproject.Repository.StudentRepository;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/students")
    public List<Students> getAllStudents() {
        return repo.findAll();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/students/{id}")
    public Students getStudent(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Students student) {
        repo.save(student);
    }
}