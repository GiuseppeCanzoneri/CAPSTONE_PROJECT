package Giuseppecanzoneri.capstoneproject.Users.repository;

import java.util.Optional;
import java.util.UUID;


import Giuseppecanzoneri.capstoneproject.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

}