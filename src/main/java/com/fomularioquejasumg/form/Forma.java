package com.fomularioquejasumg.form;

import java.util.Date;

public class Forma {

    private Integer idMunicipio;
    private String address;
    private Integer officeNumber;
    private String emailAddress;

    private String socialReason;
    private String nit;
    private String name;

    String complainText;
    String requestText;
    Date complainDate;
    String invoiceId;
    Integer idSede;


    public Forma() {
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComplainText() {
        return complainText;
    }

    public void setComplainText(String complainText) {
        this.complainText = complainText;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    public Date getComplainDate() {
        return complainDate;
    }

    public void setComplainDate(Date complainDate) {
        this.complainDate = complainDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }
}
