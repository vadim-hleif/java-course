package ru.vadim_hleif.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vadim_hleif.course.student.Student;
import ru.vadim_hleif.course.student.StudentGroupProvider;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private StudentGroupProvider provider;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);

        Map<String, List<Student>> stringListMap = provider.generateStudentGroups(10, 2);

        model.addAttribute("students", stringListMap);
        return "test";
    }

}