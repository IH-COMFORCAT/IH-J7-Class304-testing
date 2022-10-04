package com.ironhack.courses.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Section {
    @Id
    private String id;
    private String courseCode;
    private Short roomNumber;
    private String instructor;

    public Section() {
    }

    public Section(String id, String courseCode, Short roomNumber, String instructor) {
        this.id = id;
        this.courseCode = courseCode;
        this.roomNumber = roomNumber;
        this.instructor = instructor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Short getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Short roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
