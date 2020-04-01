package ru.vadim_hleif.course.student.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vadim_hleif.course.student.database.entities.StudentEntity;
import ru.vadim_hleif.course.student.dto.Student;
import ru.vadim_hleif.course.student.service.StudentsProvider;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("students-database-jpa")
public class StudentsJpaProvider implements StudentsProvider {

    private final StudentsJpaRepository repository;

    public StudentsJpaProvider(StudentsJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToStudent)
                .collect(Collectors.toList());
    }

    private Student mapToStudent(StudentEntity entity) {
        return new Student(entity.getName());
    }
}
