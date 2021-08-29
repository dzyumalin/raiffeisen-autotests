package ru.raiffeisen.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private Integer id,
            year;
    private String name,
            job,
            email,
            avatar,
            token,
            error;
    @JsonProperty("pantone_value")
    private String pantoneValue;
    private char color;

}
