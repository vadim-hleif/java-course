package ru.vadim_hleif.course.student.service;

import io.github.benas.randombeans.api.EnhancedRandom;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vadim_hleif.course.student.dto.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@Service
public class RandomStudentGroupProvider implements StudentGroupProvider {

  private final RandomStudentsGenerator generator;
  private final EnhancedRandom randomize;

  public RandomStudentGroupProvider(RandomStudentsGenerator generator, @Qualifier("group-name-generator") EnhancedRandom randomize) {
    this.generator = generator;
    this.randomize = randomize;
  }

  @Override
  public Map<String, List<Student>> getAll() {
    return generateStudentGroups(20, 2);
  }

  private Map<String, List<Student>> generateStudentGroups(int studentsCount, int groupsCount) {
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
