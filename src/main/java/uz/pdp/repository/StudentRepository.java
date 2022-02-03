package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.Student;

import java.util.UUID;
@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

}
