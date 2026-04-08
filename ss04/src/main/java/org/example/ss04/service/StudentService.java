package org.example.ss04.service;

import org.example.ss04.dao.StudentDAO;
import org.example.ss04.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    // tiêm sự phụ thuộc (DI)
    @Autowired
    private StudentDAO studentDAO;
    public List<Student> getAllStudent(){
        List<Student> students = studentDAO.findAll();
        return students;
    }
}
