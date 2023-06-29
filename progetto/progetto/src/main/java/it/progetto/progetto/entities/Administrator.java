package it.progetto.progetto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Administrator {

    private int idAdministrator;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
