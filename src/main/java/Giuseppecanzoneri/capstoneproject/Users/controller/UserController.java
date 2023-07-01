package Giuseppecanzoneri.capstoneproject.Users.controller;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import Giuseppecanzoneri.capstoneproject.Users.repository.UserRepository;
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


//    @GetMapping("/me/preferiti")
//    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
//    public List<Destination> getPreferiti() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        return UserService.findUserByUsername(username).getPreferiti();
//    }

//    @PostMapping("/me/preferiti")
//    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
//    @ResponseStatus(HttpStatus.CREATED)
//    public User addFilmToPreferiti(@RequestBody AggiungiPreferitiPayload payload) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        User user = usersService.findByUsername(username);
//
//        Film film = filmsService.findById(payload.getIdFilm());
//
//        if (user.getPreferiti().contains(film)) {
//            throw new BadRequestException("Non puoi aggiungere lo stesso film due volte!");
//        }
//
//        user.addFilm(film);
//        return usersRepo.save(user);
//    }

//    @DeleteMapping("/me/preferiti/{filmId}")
//    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public User removeFilmFromPreferiti(@PathVariable UUID filmId) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        User user = UserService.findUserByUsername(username);
//
//        Destination destination = UserService.findUserById(filmId);
//
//        user.removeDestination(destination);
//        return usersRepo.save(user);
//    }

}