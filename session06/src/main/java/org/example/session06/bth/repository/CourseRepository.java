package org.example.session06.bth.repository;
import org.example.session06.bth.model.Course;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    private static final List<Course> COURSES = new ArrayList<>();

    static {
        COURSES.add(new Course(1L, "IELTS-6.5", "IELTS Target 6.5", "Intermediate",
                "Luyen ky nang IELTS Academic tu 5.0 len 6.5.", "Ms. Lan", "12 tuan",
                new BigDecimal("5000000"), LocalDate.of(2026, 5, 10), 18, 20));
        COURSES.add(new Course(2L, "ENG-BASIC", "English Foundation", "Beginner",
                "Xay nen tang ngu phap va phat am co ban.", "Mr. Hung", "10 tuan",
                new BigDecimal("3200000"), LocalDate.of(2026, 5, 15), 0, 25));
        COURSES.add(new Course(3L, "TOEIC-750", "TOEIC Intensive 750+", "Advanced",
                "Tang toc chien thuat lam bai TOEIC cho muc tieu 750+.", "Ms. Nhi", "8 tuan",
                new BigDecimal("4500000"), LocalDate.of(2026, 6, 1), 12, 20));
        COURSES.add(new Course(4L, "SPEAK-B1", "Speaking for Work B1", "Intermediate",
                "Luyen phan xa giao tiep va thuyet trinh cong viec.", "Mr. Tuan", "9 tuan",
                new BigDecimal("3800000"), LocalDate.of(2026, 5, 20), 20, 20));
        COURSES.add(new Course(5L, "KID-START", "Kids Starter A1", "Beginner",
                "Lop danh cho hoc vien nho tuoi bat dau hoc tieng Anh.", "Ms. Hoa", "14 tuan",
                new BigDecimal("2800000"), LocalDate.of(2026, 6, 8), 6, 18));
    }

    public List<Course> findAll() {
        return new ArrayList<>(COURSES);
    }

    public Optional<Course> findByCode(String code) {
        return COURSES.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();
    }

    public Optional<Course> findById(Long id) {
        return COURSES.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public void save(Course updated) {
        findById(updated.getId()).ifPresent(course -> {
            course.setFee(updated.getFee());
            course.setStartDate(updated.getStartDate());
        });
    }

    public boolean deleteById(Long id) {
        return COURSES.removeIf(course -> course.getId().equals(id));
    }
}