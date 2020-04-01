package ru.vadim_hleif.course.student.service;

import ru.vadim_hleif.course.student.dto.Student;

import java.util.List;

public interface StudentsProvider {

    List<Student> getAll();

}
