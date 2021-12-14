package com.example.eafinalproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Faculty extends Person {
        @ManyToMany(cascade = CascadeType.ALL)
        private List<Course> course = new ArrayList<>();
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "faculty")
        private List<CourseOffering> courseOfferings = new ArrayList<>();
        @Column(name= "title")
        private int title;
        @Column(name = "name")
        private String name;
        @Column(name = "name")
        private String email;
}

