package ru.raiffeisen.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private Integer id;
    private Integer year;
    private String name;
    private char color;
    @JsonProperty("pantone_value")
    private String pantoneValue;

}
