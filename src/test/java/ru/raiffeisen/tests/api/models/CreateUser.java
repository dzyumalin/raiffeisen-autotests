package ru.raiffeisen.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUser {

    private Integer id;
    private String name;
    private String job;

}
