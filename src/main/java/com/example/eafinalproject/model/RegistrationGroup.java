package com.example.eafinalproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class RegistrationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany()
    private List<Student> students;
    @OneToMany(mappedBy = "registrationGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AcademicBlock> blocks;
}
