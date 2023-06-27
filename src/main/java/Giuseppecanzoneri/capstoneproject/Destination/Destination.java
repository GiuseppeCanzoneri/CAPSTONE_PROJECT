package Giuseppecanzoneri.capstoneproject.Destination;


import Giuseppecanzoneri.capstoneproject.Users.User;
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
    @GeneratedValue
    private UUID idDestination;
    private String name;
    private String description;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Destination(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }
}
