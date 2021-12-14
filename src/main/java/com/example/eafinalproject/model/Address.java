package com.example.eafinalproject.model;
import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address {
    private int id;
    private String street;
    private String postalCode;
    private String city;
    private String province;
    private String country;
}