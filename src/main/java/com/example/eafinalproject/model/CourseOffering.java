package com.example.eafinalproject.model;
import com.example.eafinalproject.RegistrationRequest;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course_offering")
public class CourseOffering {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "block_id")
    private AcademicBlock block;

    @ManyToMany(mappedBy = "courseOfferingCollections", cascade = CascadeType.PERSIST)
    List<RegistrationRequest> registrationRequests = new ArrayList<>();

    @Column(name="code")
    private String code;

    @Column(name="location")
    private String location;

    @Column(name="description", length=1024)
    private String description;

    private final int capacity = 25;

    public CourseOffering() {
    }

    public CourseOffering(AcademicBlock block) {
        this.block = block;

    }
    public CourseOffering(AcademicBlock block, Course course) {
        this.block = block;
        this.course = course;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AcademicBlock getBlock() {
        return block;
    }

    public void setBlock(AcademicBlock block) {
        this.block = block;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<RegistrationRequest> getRegistrationRequests() {
        return registrationRequests;
    }

    public void setStudents(List<RegistrationRequest> registrationRequests) {
        this.registrationRequests = registrationRequests;
    }
}
