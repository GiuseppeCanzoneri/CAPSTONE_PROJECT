package Giuseppecanzoneri.capstoneproject.Users.controller;


import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")


public class UserController {

}