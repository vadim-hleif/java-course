package ru.vadim_hleif.course.student.service;

import io.github.benas.randombeans.api.EnhancedRandom;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vadim_hleif.course.student.dto.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Qualifier("students-random")
public class RandomStudentsGenerator implements StudentsProvider {

    private final EnhancedRandom randomize;

    public RandomStudentsGenerator(@Qualifier("student-name-generator") EnhancedRandom randomize) {
        this.randomize = randomize;
    }

    @Override
    public List<Student> getAll() {
        return generateStudents(20);
    }

    private Stream<Student> generateStudentsStream(int seed) {
        return randomize.objects(Student.class, seed);
    }

    private List<Student> generateStudents(int seed) {
        return this.generateStudentsStream(seed).collect(Collectors.toList());
    }


}