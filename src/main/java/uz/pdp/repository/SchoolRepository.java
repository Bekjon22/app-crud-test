package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.School;

import java.util.UUID;
@Repository
public interface SchoolRepository extends JpaRepository<School, UUID> {

}
