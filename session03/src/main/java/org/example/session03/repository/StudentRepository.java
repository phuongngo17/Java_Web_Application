package org.example.session03.repository;

import org.example.session03.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        students.add(new Student(1, "Nguyen Van A", "SV001", "CNTT", 2022, 3.8, "Đang học"));
        students.add(new Student(2, "Tran Thi B", "SV002", "Kinh tế", 2021, 3.2, "Bảo lưu"));
        students.add(new Student(3, "Le Van C", "SV003", "CNTT", 2020, 3.9, "Tốt nghiệp"));
        students.add(new Student(4, "Pham Van D", "SV004", "CNTT", 2023, 2.8, "Đang học"));
    }

    public List<Student> findAll() {
        return students;
    }
}