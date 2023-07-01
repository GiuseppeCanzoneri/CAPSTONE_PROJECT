package Giuseppecanzoneri.capstoneproject.Users;

import java.util.*;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import Giuseppecanzoneri.capstoneproject.Users.utils.UserType;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({ "password" })
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID UserId;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Destination> destinations;
//    private List<Destination> preferiti;

    public User(String nome, String cognome, String username, String email, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = UserType.USER;
//        this.preferiti = new ArrayList<>();
    }

//    public void addDestination(Destination destination) {
//        preferiti.add(destination);
//        destination.getUser().add(this);
//    }
//
//    public void removeDestination(Destination destination) {
//        preferiti.remove(destination);
//        destination.getUser().remove(this);
//    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }


    public String getEmailFromUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
