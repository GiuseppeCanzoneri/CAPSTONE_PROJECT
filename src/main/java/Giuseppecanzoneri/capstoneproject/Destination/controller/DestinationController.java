package Giuseppecanzoneri.capstoneproject.Destination.controller;


import Giuseppecanzoneri.capstoneproject.Destination.payload.DestinationCreatePayload;
import Giuseppecanzoneri.capstoneproject.Users.User;
import Giuseppecanzoneri.capstoneproject.Users.service.UserService;
import Giuseppecanzoneri.capstoneproject.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Destination saveDestination(@RequestBody @Validated DestinationCreatePayload body) {
        UUID userId = userService.getCurrentUser().getUserId(); // Ottenere l'ID dell'utente corrente
        return destinationService.createDestination(body, userId);
    }


    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("")
    public Page<Destination> getDestinations(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size,
                                             @RequestParam(defaultValue = "id") String sortBy) {
        return destinationService.findAllDestinations(page, size, sortBy);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("/{destinationId}")
    public Destination getDestinationById(@PathVariable UUID destinationId) throws NotFoundException {
        return destinationService.findDestinationById(destinationId);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/{destinationId}")
    public Destination updateDestination(@PathVariable UUID destinationId, @RequestBody DestinationCreatePayload body)
            throws NotFoundException {
        UUID userId = userService.getCurrentUser().getUserId();
        return destinationService.findDestinationByIdAndUpdate(destinationId, body, userId);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/{destinationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDestination(@PathVariable UUID destinationId) throws NotFoundException {
        destinationService.findDestinationByIdAndDelete(destinationId);
    }
}
