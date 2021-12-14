package com.example.eafinalproject;
import com.example.eafinalproject.model.CourseOffering;
import lombok.*;
import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class RegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(cascade =  CascadeType.ALL)
    @JoinColumn(name = "registrationRequestId")

    private List <CourseOffering> courseOfferingCollections;
}
