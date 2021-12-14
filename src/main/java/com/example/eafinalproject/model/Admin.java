package com.example.eafinalproject.model;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "person")
public class Admin extends Person {
    private String AdminId;
    private String position;
    private char gender;

    public String getAdminId() {
        return AdminId;
    }

    public void setAdminId(String adminId) {
        AdminId = adminId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
