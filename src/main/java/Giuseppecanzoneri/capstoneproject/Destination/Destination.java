package Giuseppecanzoneri.capstoneproject.Destination;

import Giuseppecanzoneri.capstoneproject.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Destinations")
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Destination(String name, String description, String urlCopertina) {
        this.name = name;
        this.description = description;
        this.urlCopertina = urlCopertina;
    }
}
