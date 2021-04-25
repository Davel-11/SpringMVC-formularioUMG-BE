package com.fomularioquejasumg.DepMuni;

import com.fomularioquejasumg.Departamento.Departamento;
import com.fomularioquejasumg.Municipio.Municipio;

import java.util.ArrayList;

public class DepoMuni {

    Departamento departamento;
    ArrayList<Municipio> muniList;

    public DepoMuni() {
    }

    public DepoMuni(Departamento departamento, ArrayList<Municipio> muniList) {
        this.departamento = departamento;
        this.muniList = muniList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public ArrayList<Municipio> getMuniList() {
        return muniList;
    }

    public void setMuniList(ArrayList<Municipio> muniList) {
        this.muniList = muniList;
    }
}
