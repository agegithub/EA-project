package com.example.eafinalproject.model;
import lombok.*;
import javax.persistence.*;
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@MappedSuperclass
@Data
@Entity
//@GeneratedValue(strategy = InheritanceType.JOINED)
public abstract class  Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Embedded
    @Column(name = "mailing_address")
    private Address mailingAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Embedded
    @Column(name = "home_addres")
    private Address homeAddress;
}
