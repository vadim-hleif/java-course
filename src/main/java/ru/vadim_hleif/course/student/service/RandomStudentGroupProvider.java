package ru.vadim_hleif.course.student.service;

import io.github.benas.randombeans.api.EnhancedRandom;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vadim_hleif.course.student.dto.Student;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@Service
public class RandomStudentGroupProvider implements StudentGroupProvider {

    private final StudentsProvider studentsProvider;
    private final EnhancedRandom randomize;

    public RandomStudentGroupProvider(
            // @Qualifier("students-database")
            @Qualifier("students-database-jpa") StudentsProvider studentsProvider,
            @Qualifier("group-name-generator") EnhancedRandom randomize) {
        this.studentsProvider = studentsProvider;
        this.randomize = randomize;
    }

    @Override
    public Map<String, List<Student>> getAll() {
        return generateStudentGroups(2);
    }

    private Map<String, List<Student>> generateStudentGroups(int groupsCount) {
        List<Student> students = studentsProvider.getAll();

        if (students.isEmpty()) {
            return new HashMap<>();
        }
        return StreamEx.ofSubLists(
                students.stream()
                        .sorted(Comparator.comparing(Student::getName))
                        .collect(Collectors.toList()), students.size() / groupsCount)
                .collect(Collectors.toMap(this::generateRandomString, identity()));
    }

    private String generateRandomString(List<Student> students) {
        return randomize.nextObject(String.class);
    }

}
