package com.shootit.kobe.playerstats;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerStats {

    private Long id;

    @Min(value = 25, message = "Outside Scoring cannot be LOWER than 25.")
    @Max(value = 99, message = "Outside Scoring cannot be HIGHER than 99.")
    private int outsideScoring;

    @Min(value = 25, message = "Inside Scoring cannot be LOWER than 25.")
    @Max(value = 99, message = "Inside Scoring cannot be HIGHER than 99.")
    private int insideScoring;

    @Min(value = 25, message = "Post Defense cannot be LOWER than 25.")
    @Max(value = 99, message = "Post Defense cannot be HIGHER than 99.")
    private int postDefense;

    @Min(value = 25, message = "Perimeter Defense cannot be LOWER than 25.")
    @Max(value = 99, message = "Perimeter Defense cannot be HIGHER than 99.")
    private int perimeterDefense;

    @Min(value = 25, message = "Rebounding cannot be LOWER than 25.")
    @Max(value = 99, message = "Rebounding Defense cannot be HIGHER than 99.")
    private int rebounding;

    @Min(value = 25, message = "Athleticism cannot be LOWER than 25.")
    @Max(value = 99, message = "Athleticism Defense cannot be HIGHER than 99.")
    private int athleticism;

    @Min(value = 25, message = "Playmaking cannot be LOWER than 25.")
    @Max(value = 99, message = "Playmaking Defense cannot be HIGHER than 99.")
    private int playmaking;

}
