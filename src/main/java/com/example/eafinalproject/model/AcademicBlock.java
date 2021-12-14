package com.example.eafinalproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "semester")
    private Semester semester;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "numberOfStudent")
    private int numOfStudents;

    @Column(name = "block_order")
    private int blockOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "registrationGroup_id")
    private RegistrationGroup registrationGroup;

    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CourseOffering> courseOfferingList;

    public AcademicBlock(){
        courseOfferingList = new ArrayList<CourseOffering>();
    }



    public long getId() {
        return id;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBlockMonth() {
        return blockMonth;
    }

    public void setBlockMonth(String blockMonth) {
        this.blockMonth = blockMonth;
    }

    public Date getBlockStartDate() {
        return blockStartDate;
    }

    public void setBlockStartDate(Date blockStartDate) {
        this.blockStartDate = blockStartDate;
    }

    public Date getBlockEndDate() {
        return blockEndDate;
    }

    public void setBlockEndDate(Date blockEndDate) {
        this.blockEndDate = blockEndDate;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public int getBlockOrder() {
        return blockOrder;
    }

    public void setBlockOrder(int blockOrder) {
        this.blockOrder = blockOrder;
    }

}