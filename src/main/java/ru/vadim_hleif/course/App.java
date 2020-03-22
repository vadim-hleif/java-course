package ru.vadim_hleif.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vadim_hleif.course.config.Config;
import ru.vadim_hleif.course.student.Student;
import ru.vadim_hleif.course.student.StudentGroupProvider;

import java.util.List;
import java.util.Map;

public class App {
    private static final ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
    private static final StudentGroupProvider groupProvider = ctx.getBean(StudentGroupProvider.class);

    public static void main(String[] args) {
        Map<String, List<Student>> groups = groupProvider.generateStudentGroups(1000, 4);

        System.out.println(groups);
    }
}
