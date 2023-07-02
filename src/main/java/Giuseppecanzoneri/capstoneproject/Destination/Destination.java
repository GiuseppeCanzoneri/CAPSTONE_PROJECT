// Destination.java

package Giuseppecanzoneri.capstoneproject.Destination;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Giuseppecanzoneri.capstoneproject.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;



import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "destinations")
@Data
@NoArgsConstructor
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID destinationId;
    private String name;

    @Column(length = 5000)
    private String description;

    private String urlCopertina;

    @ManyToMany(mappedBy = "preferiti")
    @JsonIgnore
    private List<User> users;

    public Destination(String name, String description, String urlCopertina) {
        this.name = name;
        this.description = description;
        this.urlCopertina = urlCopertina;
        this.users = new ArrayList<>();
    }
}
