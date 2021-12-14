package com.example.eafinalproject.model;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class RegistrationEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endtDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "regisration_group")
    private List<RegistrationGroup> registrationGroupList;
     public void addRegistrationGroupList(RegistrationGroup registrationGroup){
         registrationGroupList.add(registrationGroup);
     }


}
