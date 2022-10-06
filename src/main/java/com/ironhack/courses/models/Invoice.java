package com.ironhack.courses.models;

import javax.persistence.*;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String invoiceReason;
    private Double amount;
    private boolean isPaid;
    @OneToOne(mappedBy = "invoice")
    private Student student;

    public Invoice() {
    }

    public Invoice(String invoiceReason, Double amount, boolean isPaid) {
        this.invoiceReason = invoiceReason;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public Invoice(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceReason() {
        return invoiceReason;
    }

    public void setInvoiceReason(String invoiceReason) {
        this.invoiceReason = invoiceReason;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
