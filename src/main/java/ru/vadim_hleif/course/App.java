package ru.vadim_hleif.course;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import ru.vadim_hleif.course.student.Student;
import ru.vadim_hleif.course.student.StudentGroupProvider;
import ru.vadim_hleif.course.student.StudentsGenerator;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        EnhancedRandom studentNameRandomize = new EnhancedRandomBuilder()
                .stringLengthRange(5, 10)
                .build();
        EnhancedRandom groupNameRandomize = new EnhancedRandomBuilder()
                .stringLengthRange(1, 3)
                .build();

        StudentGroupProvider studentGroupProvider = new StudentGroupProvider(
                new StudentsGenerator(studentNameRandomize), groupNameRandomize
        );
        Map<String, List<Student>> groups = studentGroupProvider.generateStudentGroups(1000, 4);

        System.out.println(groups);
    }
}
