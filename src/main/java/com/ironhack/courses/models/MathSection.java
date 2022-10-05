package com.ironhack.courses.models;

import javax.persistence.*;

@Entity
public class MathSection extends Section{

    private int mathCredits;

    public MathSection(String id, String courseCode, Short roomNumber, String instructor, int mathCredits) {
        super(id, courseCode, roomNumber, instructor);
        this.mathCredits = mathCredits;
    }

    public MathSection() {
    }

    public int getMathCredits() {
        return mathCredits;
    }

    public void setMathCredits(int mathCredits) {
        this.mathCredits = mathCredits;
    }
}
