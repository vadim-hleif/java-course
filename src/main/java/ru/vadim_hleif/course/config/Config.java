package ru.vadim_hleif.course.config;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.vadim_hleif.course")
public class Config {

    @Bean
    @Qualifier("student-name-generator")
    public EnhancedRandom studentNameRandomize() {
        return new EnhancedRandomBuilder()
                .stringLengthRange(5, 10)
                .build();
    }

    @Bean
    @Qualifier("group-name-generator")
    public EnhancedRandom groupNameRandomize() {
        return new EnhancedRandomBuilder()
                .stringLengthRange(1, 3)
                .build();
    }

}
