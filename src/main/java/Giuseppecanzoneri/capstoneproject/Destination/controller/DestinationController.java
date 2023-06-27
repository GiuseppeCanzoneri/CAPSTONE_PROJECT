package Giuseppecanzoneri.capstoneproject.Destination.controller;


import Giuseppecanzoneri.capstoneproject.Destination.payload.DestinationCreatePayload;
import Giuseppecanzoneri.capstoneproject.Users.User;
import Giuseppecanzoneri.capstoneproject.Users.service.UserService;
import Giuseppecanzoneri.capstoneproject.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;

import Giuseppecanzoneri.capstoneproject.Destination.service.DestinationService;


import java.util.UUID;

@RestController
@RequestMapping("/destinations")
public class DestinationController {
    @Autowired
    private DestinationService destinationService;
    @Autowired
    private UserService userService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Destination saveDestination(@RequestBody @Validated DestinationCreatePayload body) {
        User currentUser = userService.getCurrentUser(); // Ottieni l'utente corrente
        return destinationService.createDestination(body, currentUser);
    }


    @GetMapping("")
    public Page<Destination> getDestinations(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size,
                                             @RequestParam(defaultValue = "id") String sortBy) {
        return destinationService.findAllDestinations(page, size, sortBy);
    }

    @GetMapping("/{destinationId}")
    public Destination getDestinationById(@PathVariable UUID destinationId) throws NotFoundException {
        return destinationService.findDestinationById(destinationId);
    }

    @PutMapping("/{destinationId}")
    public Destination updateDestination(@PathVariable UUID destinationId, @RequestBody DestinationCreatePayload body)
            throws NotFoundException {
        return destinationService.findDestinationByIdAndUpdate(destinationId, body);
    }

    @DeleteMapping("/{destinationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDestination(@PathVariable UUID destinationId) throws NotFoundException {
        destinationService.findDestinationByIdAndDelete(destinationId);
    }
}
