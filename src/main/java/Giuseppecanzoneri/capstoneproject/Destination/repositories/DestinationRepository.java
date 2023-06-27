package Giuseppecanzoneri.capstoneproject.Destination.repositories;

import java.util.Optional;
import java.util.UUID;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, UUID> {
    Optional<Destination> findByIdAndUser_Id(UUID destinationId, UUID userId);
}
