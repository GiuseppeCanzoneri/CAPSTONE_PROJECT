package Giuseppecanzoneri.capstoneproject;

import java.util.List;
import java.util.Locale;

import Giuseppecanzoneri.capstoneproject.Users.User;
import Giuseppecanzoneri.capstoneproject.Users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;


@Component
public class UserRunner implements CommandLineRunner {
    @Autowired
    UserRepository usersRepo;
    @Autowired
    private PasswordEncoder bcrypt;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("it"));
        List<User> usersDB = usersRepo.findAll();

        if (usersDB.size()== 1) {
            for (int i = 0; i < 10; i++) {
                try {
                    String nome = faker.name().firstName();
                    String cognome = faker.name().lastName();
                    String username = faker.name().username();
                    String email = faker.internet().emailAddress();
                    String psw = bcrypt.encode(faker.internet().password());

                    User user = new User(nome, cognome, username, email, psw );

                    usersRepo.save(user);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

}