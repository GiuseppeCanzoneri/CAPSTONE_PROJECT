package Giuseppecanzoneri.capstoneproject.Users.controller;

import Giuseppecanzoneri.capstoneproject.exceptions.NotFoundException;
import Giuseppecanzoneri.capstoneproject.Users.User;
import Giuseppecanzoneri.capstoneproject.Users.payload.UserRegistrationPayload;
import Giuseppecanzoneri.capstoneproject.Users.service.UserService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Validated UserRegistrationPayload body) {
        return userService.createUser(body);
    }

    @GetMapping("")
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "idUser") String sortBy) {
        return userService.findAllUsers(page, size, sortBy);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable UUID userId) throws NotFoundException {
        return userService.findUserById(userId);
    }
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable UUID userId, @RequestBody UserRegistrationPayload body)
            throws NotFoundException {
        return userService.findUserByIdAndUpdate(userId, body);
    }
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID userId) throws NotFoundException {
        userService.findUserByIdAndDelete(userId);
    }
}