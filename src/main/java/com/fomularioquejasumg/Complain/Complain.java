package com.fomularioquejasumg.Complain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Complain {

    Integer id;
    String complainText;
    String requestText;
    Integer idProvider;
    Date complainDate;
    String invoiceId;
    Integer idSede;

    public Complain() {
    }

    public Complain(String complainText, String requestText, Integer idProvider, Date complainDate, String invoiceId, Integer idSede) {
        this.complainText = complainText;
        this.requestText = requestText;
        this.idProvider = idProvider;
        this.complainDate = complainDate;
        this.invoiceId = invoiceId;
        this.idSede = idSede;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
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
