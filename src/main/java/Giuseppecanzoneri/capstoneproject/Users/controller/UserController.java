package Giuseppecanzoneri.capstoneproject.Users.controller;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import Giuseppecanzoneri.capstoneproject.Destination.service.DestinationService;
import Giuseppecanzoneri.capstoneproject.Users.payload.AggiungiPreferitiPayload;
import Giuseppecanzoneri.capstoneproject.Users.repository.UserRepository;
import Giuseppecanzoneri.capstoneproject.exceptions.BadRequestException;
import Giuseppecanzoneri.capstoneproject.exceptions.NotFoundException;
import Giuseppecanzoneri.capstoneproject.Users.User;
import Giuseppecanzoneri.capstoneproject.Users.payload.UserRegistrationPayload;
import Giuseppecanzoneri.capstoneproject.Users.service.UserService;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    DestinationService destinationService;

    @Autowired
  UserRepository userRepository;

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Validated UserRegistrationPayload body) {
        return userService.createUser(body);
    }

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "idUser") String sortBy) {
        return userService.findAllUsers(page, size, sortBy);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable UUID userId) throws NotFoundException {
        return userService.findUserById(userId);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable UUID userId, @RequestBody UserRegistrationPayload body)
            throws NotFoundException {
        return userService.findUserByIdAndUpdate(userId, body);
    }
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID userId) throws NotFoundException {
        userService.findUserByIdAndDelete(userId);
    }

    @GetMapping("/me")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.findUserByUsername(username);
    }

    @GetMapping("/me/preferiti")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public List<Destination> getPreferiti() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.findUserByUsername(username).getPreferiti();
    }

    @PostMapping("/me/preferiti")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public User addDestinationToPreferiti(@RequestBody AggiungiPreferitiPayload payload) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findUserByUsername(username);

        Destination destination = destinationService.findById(payload.getIdDestination());

        if (user.getPreferiti().contains(destination)) {
            throw new BadRequestException("Non puoi aggiungere la stessa destinazione due volte!");
        }

        user.addDestination(destination);
        return userRepository.save(user);
    }

    @DeleteMapping("/me/preferiti/{destinationId}")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public User removeDestinationFromPreferiti(@PathVariable UUID destinationId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findUserByUsername(username);

        Destination destination = destinationService.findById(destinationId);

        user.removeDestination(destination);
        return userRepository.save(user);
    }

}