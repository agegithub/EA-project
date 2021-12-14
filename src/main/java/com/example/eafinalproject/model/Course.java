package com.example.eafinalproject.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@Column(name="title")
    private String name;

	@Column(name="course_id")
    private int courseId;  //from string to int

	@Column(name="description", length=1024)
    private String description;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="prerequisite_id")
	private Course prerequisite;
}