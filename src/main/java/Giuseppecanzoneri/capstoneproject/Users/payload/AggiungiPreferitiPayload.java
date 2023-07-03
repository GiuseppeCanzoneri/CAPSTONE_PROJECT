package Giuseppecanzoneri.capstoneproject.Users.payload;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AggiungiPreferitiPayload {
    @NotNull(message = "L'id della destinazione è obbligatorio")
    UUID idDestination;
}