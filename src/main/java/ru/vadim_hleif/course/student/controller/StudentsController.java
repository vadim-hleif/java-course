package ru.vadim_hleif.course.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vadim_hleif.course.student.dto.Student;
import ru.vadim_hleif.course.student.service.RandomStudentGroupProvider;

import java.util.List;
import java.util.Map;

@Controller
public class StudentsController {

    @Autowired
    private RandomStudentGroupProvider provider;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);

        Map<String, List<Student>> studentGroup = provider.getAll();

        model.addAttribute("groups", studentGroup);
        return "greeting.html";
    }

}