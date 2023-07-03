package Giuseppecanzoneri.capstoneproject.Destination.service;




import java.util.UUID;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import Giuseppecanzoneri.capstoneproject.Destination.payload.DestinationCreatePayload;
import Giuseppecanzoneri.capstoneproject.Destination.repositories.DestinationRepository;
import Giuseppecanzoneri.capstoneproject.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class DestinationService {
    @Autowired
    private DestinationRepository destinationRepo;

    public Page<Destination> find(int page, int size, String sortBy, String name) {
        if (size < 0)
            size = 10;
        if (size > 100)
            size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        if (!name.equals("")) {
            return destinationRepo.findByName(name, pageable);
        } else {
            return destinationRepo.findAll(pageable);
        }
    }

    public Destination findById(UUID id) throws NotFoundException {
        return destinationRepo.findById(id).orElseThrow(() -> new NotFoundException("Film non trovato!"));

    }

    public Destination create(DestinationCreatePayload u) {

        Destination newDestination = new Destination(u.getName(),u.getDescription(),u.getUrlCopertina());
        return destinationRepo.save(newDestination);
    }

    public Destination findByIdAndUpdate(UUID id, DestinationCreatePayload d) {
        Destination found = this.findById(id);
        found.setId(id);
        found.setName(d.getName());
        found.setDescription(found.getDescription());
        found.setUrlCopertina(d.getUrlCopertina());;
        found.setUsers(found.getUsers());
        return destinationRepo.save(found);

    }

    public void findByIdAndDelete(UUID id) throws NotFoundException {
        Destination found = this.findById(id);
        destinationRepo.delete(found);
    }
}