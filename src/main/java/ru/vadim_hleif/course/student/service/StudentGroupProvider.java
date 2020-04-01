package ru.vadim_hleif.course.student.service;

import ru.vadim_hleif.course.student.dto.Student;

import java.util.List;
import java.util.Map;

public interface StudentGroupProvider {

  Map<String, List<Student>> getAll();
  
}
