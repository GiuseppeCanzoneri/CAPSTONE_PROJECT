package Giuseppecanzoneri.capstoneproject.Destination.service;





import Giuseppecanzoneri.capstoneproject.Destination.payload.DestinationCreatePayload;
import Giuseppecanzoneri.capstoneproject.Destination.repositories.DestinationRepository;
import Giuseppecanzoneri.capstoneproject.Users.User;
import Giuseppecanzoneri.capstoneproject.Users.repository.UserRepository;
import Giuseppecanzoneri.capstoneproject.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;



import java.util.UUID;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;
    @Autowired
    private UserRepository userRepository;

    public Page<Destination> findAllDestinations(int page, int size, String sortBy) {
        if (size < 0)
            size = 10;
        if (size > 100)
            size = 20;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return destinationRepository.findAll(pageable);
    }

    public Destination createDestination(DestinationCreatePayload payload, User user) {
        Destination destination = new Destination(payload.getName(), payload.getDescription(), user);
        return destinationRepository.save(destination);
    }


    public Destination findDestinationById(UUID destinationId) throws NotFoundException {
        return destinationRepository.findById(destinationId)
                .orElseThrow(() -> new NotFoundException("Destination not found with ID: " + destinationId));
    }

    public Destination findDestinationByIdAndUpdate(UUID destinationId, DestinationCreatePayload payload)
            throws NotFoundException {
        Destination destination = findDestinationById(destinationId);
        destination.setName(payload.getName());
        destination.setDescription(payload.getDescription());
        return destinationRepository.save(destination);
    }

    public void findDestinationByIdAndDelete(UUID destinationId) throws NotFoundException {
        Destination destination = findDestinationById(destinationId);
        destinationRepository.delete(destination);
    }


 
}
