package com.ironhack.courses.models;

import javax.persistence.*;

@Entity
public class ScienceSection extends Section {
    private int scienceCredits;
    private int labNumber;

    public ScienceSection(String id, String courseCode, Short roomNumber, String instructor, int scienceCredits, int labNumber) {
        super(id, courseCode, roomNumber, instructor);
        this.scienceCredits = scienceCredits;
        this.labNumber = labNumber;
    }

    public ScienceSection() {
    }

    public int getScienceCredits() {
        return scienceCredits;
    }

    public void setScienceCredits(int scienceCredits) {
        this.scienceCredits = scienceCredits;
    }

    public int getLabNumber() {
        return labNumber;
    }

    public void setLabNumber(int labNumber) {
        this.labNumber = labNumber;
    }
}
