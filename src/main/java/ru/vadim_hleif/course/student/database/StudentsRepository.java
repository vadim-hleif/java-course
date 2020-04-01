package ru.vadim_hleif.course.student.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.vadim_hleif.course.student.dto.Student;
import ru.vadim_hleif.course.student.service.StudentsProvider;

import java.util.List;

@Service
@Qualifier("students-database")
public class StudentsRepository implements StudentsProvider {

    private final JdbcTemplate template;

    public StudentsRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Student> getAll() {
        // org.springframework.jdbc.core.BeanPropertyRowMapper - abstract solution with reflection
        return template.query("SELECT * from student", (rs, rowNum) -> new Student(rs.getString("name")));
    }

}