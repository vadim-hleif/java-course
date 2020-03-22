package ru.vadim_hleif.course.student;

import org.junit.jupiter.api.Test;
import ru.vadim_hleif.course.config.Config;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEmptyString.emptyString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentsGeneratorTest {

    private final StudentsGenerator generator = new StudentsGenerator(new Config().studentNameRandomize());

    @Test
    void shouldGenerateCorrectNumbers() {
        List<Student> result = generator.generateStudents(10);

        assertNotNull(result);

        assertEquals(10, result.size());

        for (Student student : result) {
            assertThat(student.getName(), is(not(nullValue())));
            assertThat(student.getName(), is(not(emptyString())));
        }
    }
}