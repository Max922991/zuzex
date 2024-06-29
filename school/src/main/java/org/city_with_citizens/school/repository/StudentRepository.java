package org.city_with_citizens.school.repository;

import org.city_with_citizens.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    Optional<Student> findStudentByCitizenId(UUID citizenId);

}
