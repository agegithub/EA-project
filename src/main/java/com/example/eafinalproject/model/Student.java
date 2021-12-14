package com.example.eafinalproject.model;

import com.example.eafinalproject.RegistrationRequest;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Data
@Table(name = "person")
public class Student extends Person {
    @Column(name = "student_id", nullable = false, length = 20)
    private int StudentId;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "email", nullable = false, length = 20)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    private RegistrationGroup registrationGroup;

    @OneToMany(cascade =  CascadeType.ALL)
    private List<RegistrationRequest> registrationRequestList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Registration registrations;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Registrations", joinColumns { @JoinColumn})

    @Embedded
    private Address mailingAddress;
    @Embedded
    private Address homeAddress;

    public Student(int id, String firstName, String lastName, Address mailingAddress, String phoneNumber, String email,
                   Address homeAddress, int studentId, String name, String email1, Address mailingAddress1, Address homeAddress1) {
        super(id, firstName, lastName, mailingAddress, phoneNumber, email, homeAddress);
        StudentId = studentId;
        this.name = name;
        this.email = email1;
        this.mailingAddress = mailingAddress1;
        this.homeAddress = homeAddress1;
    }
    public Student(int studentId, String name, String email, Address mailingAddress, Address homeAddress) {
        StudentId = studentId;
        this.name = name;
        this.email = email;
        this.mailingAddress = mailingAddress;
        this.homeAddress = homeAddress;
    }

    public int getStudentId() {
        return StudentId;
    }
    public void addRegistrationRequestList(RegistrationRequest registrationRequest){
        registrationRequestList.add(registrationRequest);}

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegistrationGroup getRegistrationGroup() {
        return registrationGroup;
    }

    public void setRegistrationGroup(RegistrationGroup registrationGroup) {
        this.registrationGroup = registrationGroup;
    }

    public List<RegistrationRequest> getRegistrationRequestList() {
        return registrationRequestList;
    }

    public void setRegistrationRequestList(List<RegistrationRequest> registrationRequestList) {
        this.registrationRequestList = registrationRequestList;
    }

    public Registration getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Registration registrations) {
        this.registrations = registrations;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}