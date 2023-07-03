package Giuseppecanzoneri.capstoneproject.Destination.repositories;

import java.util.Optional;
import java.util.UUID;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface DestinationRepository extends JpaRepository<Destination, UUID> {


    @Query("SELECT d FROM Destination d WHERE LOWER(d.name) LIKE CONCAT('%', LOWER(:name), '%')")
    Page<Destination> findByName(String name, Pageable pageable);

}