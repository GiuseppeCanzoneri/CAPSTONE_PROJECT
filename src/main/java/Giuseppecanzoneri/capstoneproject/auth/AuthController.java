package Giuseppecanzoneri.capstoneproject.auth;


import Giuseppecanzoneri.capstoneproject.Users.User;
import Giuseppecanzoneri.capstoneproject.Users.service.UserService;
import Giuseppecanzoneri.capstoneproject.Users.payload.UserLoginPayload;
import Giuseppecanzoneri.capstoneproject.Users.payload.UserRegistrationPayload;
import epicenergyservice.u2bw.auth.payloads.AuthenticationSuccessfullPayload;
import epicenergyservice.u2bw.exceptions.NotFoundException;
import epicenergyservice.u2bw.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;
    @Autowired
    private PasswordEncoder bcrypt;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Validated UserRegistrationPayload body) {

        body.setPassword(bcrypt.encode(body.getPassword()));
        User createdUser = userService.create(body);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationSuccessfullPayload> login(@RequestBody UserLoginPayload body)
            throws NotFoundException {

        User user = userService.findByUserName(body.getUsername());

        String plainPW = body.getPassword();
        String hashedPW = user.getPassword();

        if (!bcrypt.matches(plainPW, hashedPW))
            throw new UnauthorizedException("Credenziali non valide");

        String token = JWTTools.createToken(user);
        return new ResponseEntity<>(new AuthenticationSuccessfullPayload(token), HttpStatus.OK);
    }

}
