package org.example.session03.service;

import org.example.session03.model.Student;
import org.example.session03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAll(String sortBy, String search, String faculty) {

        List<Student> list = new ArrayList<>(repo.findAll());

        // FILTER
        if (search != null && !search.isEmpty()) {
            list = list.stream()
                    .filter(s -> s.getFullName().toLowerCase().contains(search.toLowerCase()))
                    .toList();
        }

        if (faculty != null && !faculty.isEmpty()) {
            list = list.stream()
                    .filter(s -> s.getFaculty().equalsIgnoreCase(faculty))
                    .toList();
        }

        // SORTx
        if ("name".equals(sortBy)) {
            list = list.stream()
                    .sorted(Comparator.comparing(Student::getFullName))
                    .toList();
        }

        if ("gpa".equals(sortBy)) {
            list = list.stream()
                    .sorted((a, b) -> Double.compare(b.getGpa(), a.getGpa()))
                    .toList();
        }

        return list;
    }

    public Student findById(int id) {
        return repo.findAll().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // DASHBOARD
    public double getAvgGpa() {
        return repo.findAll().stream()
                .mapToDouble(Student::getGpa)
                .average().orElse(0);
    }

    public Student getTopStudent() {
        return repo.findAll().stream()
                .max(Comparator.comparing(Student::getGpa))
                .orElse(null);
    }

    public Map<String, Long> getStatusStats() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(Student::getStatus, Collectors.counting()));
    }
}
