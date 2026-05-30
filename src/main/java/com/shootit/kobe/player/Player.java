package com.shootit.kobe.player;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    // Jakarta validation constraints is fucking useful bro ong!
    private Long playerId;

    @NotBlank(message = "Player name cannot be BLANK.")
    @Size(min = 2, max = 70, message = "Player name cannot be LOWER than 2 or HIGHER than 70.")
    private String playerName;

    @Min(value = 0, message = "Player jersey cannot be NEGATIVE.")
    @Max(value = 99, message = "Player jersey cannot be HIGHER than 99.")
    private int jerseyNumber;

    @Min(value = 18, message = "Player must be 18 and ABOVE to be drafted.")
    @Max(value = 50, message = "Player age ABOVE 50 is unrealistic.")
    private int age;

    @Min(value = 0, message = "Player years of experience cannot be NEGATIVE.")
    @Max(value = 30, message = "Player years of experience is UNREALISTIC.")
    private int yearsPro;

    @NotBlank(message = "Player position cannot be BLANK.")
    @Pattern(regexp = "PG|SG|SF|PF|C", message = "Player position must be EITHER one of: PG, SG, SF, PF, or C.")
    private String position;
}
