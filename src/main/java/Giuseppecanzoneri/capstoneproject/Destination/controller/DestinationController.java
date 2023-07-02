package Giuseppecanzoneri.capstoneproject.Destination.controller;



import java.util.UUID;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import Giuseppecanzoneri.capstoneproject.Destination.payload.DestinationCreatePayload;
import Giuseppecanzoneri.capstoneproject.Destination.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @Autowired
    DestinationService destinationService;

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public Page<Destination> getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size,
                                      @RequestParam(defaultValue = "id") String sortBy,
                                      @RequestParam(defaultValue = "") String nome) {
        return destinationService.find(page, size, sortBy, nome);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public Destination getById(@PathVariable UUID id) throws Exception {
        return destinationService.findById(id);
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Destination createDestination(@RequestBody DestinationCreatePayload body) {
        return destinationService.create(body);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Destination getByIdAndUpdate(@PathVariable UUID id, @RequestBody DestinationCreatePayload body) {
        return destinationService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDestination(@PathVariable UUID id) {
        destinationService.findByIdAndDelete(id);
    }

}
