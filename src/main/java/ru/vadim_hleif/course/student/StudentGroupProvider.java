package ru.vadim_hleif.course.student;

import io.github.benas.randombeans.api.EnhancedRandom;
import one.util.streamex.StreamEx;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class StudentGroupProvider {

    private final StudentsGenerator generator;
    private final EnhancedRandom randomize;

    public StudentGroupProvider(StudentsGenerator generator, EnhancedRandom randomize) {
        this.generator = generator;
        this.randomize = randomize;
    }

    public Map<String, List<Student>> generateStudentGroups(int studentsCount, int groupsCount) {
        return StreamEx.ofSubLists(
                generator.generateStudentsStream(studentsCount)
                        .sorted(Comparator.comparing(Student::getName))
                        .collect(Collectors.toList()), studentsCount / groupsCount)
                .collect(Collectors.toMap(this::generateRandomString, identity()));
    }

    private String generateRandomString(List<Student> students) {
        return randomize.nextObject(String.class);
    }
}
