package Giuseppecanzoneri.capstoneproject.Users.service;

import Giuseppecanzoneri.capstoneproject.Users.User;
import Giuseppecanzoneri.capstoneproject.Users.payload.UserRegistrationPayload;
import Giuseppecanzoneri.capstoneproject.Users.repository.UserRepository;
import Giuseppecanzoneri.capstoneproject.exceptions.BadRequestException;
import Giuseppecanzoneri.capstoneproject.exceptions.NotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> findAllUsers(int page, int size, String sortBy) {
        if (size < 0)
            size = 10;
        if (size > 100)
            size = 20;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return userRepository.findAll(pageable);
    }

    public User createUser(UserRegistrationPayload payload) {
        String email = payload.getEmail();

        if (!isValidEmail(email)) {
            throw new BadRequestException("L'email inserita non è valida.");
        }

        userRepository.findByEmail(email).ifPresent(user -> {
            throw new NotFoundException("Utente non trovato con ID: " + user.getUserId());
        });

        User newUser = new User(payload.getNome(), payload.getCognome(), payload.getUsername(), email, payload.getPassword());
        return userRepository.save(newUser);
    }

    private boolean isValidEmail(String email) {
        return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
    }

    public User findUserById(UUID id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Utente non trovato con ID: " + id));
    }

    public User findUserByIdAndUpdate(UUID id, UserRegistrationPayload payload) throws NotFoundException {
        User foundUser = findUserById(id);
        foundUser.setUserId(id);
        foundUser.setNome(payload.getNome());
        foundUser.setCognome(payload.getCognome());
        foundUser.setUsername(payload.getUsername());
        foundUser.setEmail(payload.getEmail());
        foundUser.setPassword(payload.getPassword());
        return userRepository.save(foundUser);
    }

    public void findUserByIdAndDelete(UUID id) throws NotFoundException {
        User foundUser = findUserById(id);
        userRepository.delete(foundUser);
    }

    public User findUserByEmail(String email) throws NotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Utente non trovato con email: " + email));
    }

    public User findUserByUsername(String username) throws NotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("Utente non trovato con username: " + username));
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Utente corrente non trovato"));
    }
}
