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
    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    public Student(String name, String lastName, Address postalAddress, Address physicalAddress, Invoice invoice) {
        this.name = name;
        this.lastName = lastName;
        this.postalAddress = postalAddress;
        this.physicalAddress = physicalAddress;
        this.invoice = invoice;
    }

    public Student(String name, String lastName, Address postalAddress, Address physicalAddress) {
        this.name = name;
        this.lastName = lastName;
        this.postalAddress = postalAddress;
        this.physicalAddress = physicalAddress;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getPostalAddress() {
        return postalAddress;
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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }


}
