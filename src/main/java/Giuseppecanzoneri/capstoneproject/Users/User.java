// User.java

package Giuseppecanzoneri.capstoneproject.Users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import Giuseppecanzoneri.capstoneproject.Users.utils.UserType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
@JsonIgnoreProperties({ "password", "active", "authorities", "enabled", "credentialsNonExpired", "accountNonExpired",
        "accountNonLocked" })
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private UUID userId;
    private String username;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    @Enumerated(EnumType.STRING)
    private UserType role;

    @ManyToMany
    @JoinTable(name = "preferiti", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    @JsonManagedReference
    @JsonIgnoreProperties({"users"})
    private List<Destination> preferiti;

    public User(String username, String email, String password, String nome, String cognome) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.role = UserType.USER;
        this.preferiti = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        preferiti.add(destination);
        destination.getUsers().add(this);
    }

    public void removeDestination(Destination destination) {
        preferiti.remove(destination);
        destination.getUsers().remove(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
