package ru.vadim_hleif.course.student;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentsGeneratorTest {

    private final StudentsGenerator generator = new StudentsGenerator(randomize);

    @Test
    void shouldGenerateCorrectNumbers() {
        List<Student> result = generator.generateStudents(10);

        assertNotNull(result);

        assertEquals(result.size(), 10);
    }
}