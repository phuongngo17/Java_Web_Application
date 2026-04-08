package org.example.ss04.dao;

import org.example.ss04.model.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentDAO {
   private List<Student> students =  new ArrayList<>(Arrays.asList(
            new Student(1,"Trang",20,true),
            new Student(2,"Minh",23,false),
            new Student(3,"Huy",18,true)
    ));

   //Phương thức lấy về danh sách

    public List<Student> findAll() {
        return students;
    }
    public List<Student> search(String keyword) {
        return students.stream().filter(s->s.getFullName().toLowerCase().contains(keyword.toLowerCase())).toList();
    }
}
