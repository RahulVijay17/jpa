package com.jpa.onetoone.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Passport.class)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    @JsonManagedReference
    private Passport passport;

}
