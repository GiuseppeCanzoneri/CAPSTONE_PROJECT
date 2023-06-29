package Giuseppecanzoneri.capstoneproject.Destination;


import Giuseppecanzoneri.capstoneproject.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String description;
    private String UrlCopertina;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Destination(String name, String description,String UrlCopertina) {
        this.name = name;
        this.description = description;
        this.UrlCopertina= UrlCopertina;
//        this.user = user;
    }
}
