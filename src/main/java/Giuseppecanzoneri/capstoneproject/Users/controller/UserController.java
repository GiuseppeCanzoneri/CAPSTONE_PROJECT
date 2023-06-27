package Giuseppecanzoneri.capstoneproject.Users.controller;

import Giuseppecanzoneri.capstoneproject.Users.User;
import Giuseppecanzoneri.capstoneproject.Users.service.UserService;
import Giuseppecanzoneri.capstoneproject.Users.payload.UserRegistrationPayload;
import epicenergyservice.u2bw.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")


public class UserController {

}