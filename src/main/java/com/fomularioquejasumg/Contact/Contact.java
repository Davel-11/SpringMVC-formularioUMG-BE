package com.fomularioquejasumg.Contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

    private Integer id;
    private Integer officeNumber;
    private String emailAddress;

    public Contact() {
    }

    public Contact(Integer officeNumber, String emailAddress) {
        this.officeNumber = officeNumber;
        this.emailAddress = emailAddress;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(Integer officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
