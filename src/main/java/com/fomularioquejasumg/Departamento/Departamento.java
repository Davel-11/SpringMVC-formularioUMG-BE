package com.fomularioquejasumg.Departamento;

import com.fomularioquejasumg.Municipio.Municipio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Departamento {

    Integer id;
    String name;
    Integer idRegion;

    public Departamento() {
    }

    public Departamento(Integer id, String name, Integer idRegion) {
        this.id = id;
        this.name = name;
        this.idRegion = idRegion;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

}
