package org.example.session07.repository;

import org.example.session07.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"Trang",true,20,"Huế"),
                    new Student(2,"Huy",false,22,"Hà Nội"),
                    new Student(3, "Chiến",true,25,"Thanh Hóa")
            )
    );
    public List<Student> getStudents(){
        return students;
    }
    public void addStudent(Student student){
        students.add(student);
    }
}
