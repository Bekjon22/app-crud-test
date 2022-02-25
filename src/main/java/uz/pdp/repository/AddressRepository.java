package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.Address;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    Optional<Address> findByRegionAndDeleted(String name, boolean deleted);

    Optional<Address> findByRegionAndDeletedAndIdNot(String region, boolean deleted, UUID id);



}
