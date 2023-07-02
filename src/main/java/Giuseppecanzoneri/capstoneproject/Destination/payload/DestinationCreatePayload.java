package Giuseppecanzoneri.capstoneproject.Destination.payload;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;



//private String name;
//private String description;
@Getter
@Setter
public class DestinationCreatePayload {
    @NotNull(message = "Il nome è obbligatorio")
    @Size(min = 3, max = 30, message = "Nome min 3 caratteri, massimo 30")
    String name;
    @NotNull(message = "La descrizione è obbligatoria")
    String description ;
    @NotNull(message = "La URL della copertina è obbligatoria")
    String UrlCopertina ;

    public DestinationCreatePayload(@NotNull(message = "Il nome è obbligatorio") String name, @NotNull(message = "la Descrizione è obbligatoria") String description,   @NotNull(message = "La URL della copertina è obbligatoria")
    String UrlCopertina ) {
        this.name = name;
        this.description = description;
        this.UrlCopertina=UrlCopertina;
    }


}


