package com.ironhack.courses.models;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;

    @Embedded
    private Address postalAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "physical_street")),
            @AttributeOverride(name = "number", column = @Column(name = "physical_number")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "physical_postal_code")),
            @AttributeOverride(name = "city", column = @Column(name = "physical_city"))
    })
    private Address physicalAddress;

    public Student(Long id, String name, String lastName, Address postalAddress, Address physicalAddress) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.postalAddress = postalAddress;
        this.physicalAddress = physicalAddress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Address getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(Address physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }
}
