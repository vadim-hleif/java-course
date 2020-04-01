package ru.vadim_hleif.course.student.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import ru.vadim_hleif.course.student.database.entities.StudentEntity;

@Service
public interface StudentsJpaRepository extends JpaRepository<StudentEntity, Long> {

}