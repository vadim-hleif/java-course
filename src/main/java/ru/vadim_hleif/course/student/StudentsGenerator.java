package ru.vadim_hleif.course.student;

import io.github.benas.randombeans.api.EnhancedRandom;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentsGenerator {

    private final EnhancedRandom randomize;

    public StudentsGenerator(EnhancedRandom randomize) {
        this.randomize = randomize;
    }

    public Stream<Student> generateStudentsStream(int seed) {
        return randomize.objects(Student.class, seed);
    }

    public List<Student> generateStudents(int seed) {
        return this.generateStudentsStream(seed).collect(Collectors.toList());
    }

}