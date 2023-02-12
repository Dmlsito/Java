package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class CountryRegion {

    private ArrayList<State> listadoEstados;
    private String name;
    private String code;

    public CountryRegion() {
    }

    public CountryRegion(ArrayList<State> listadoEstados, String name, String code) {
        this.listadoEstados = listadoEstados;
        this.name = name;
        this.code = code;
    }

    public ArrayList<State> getListadoEstados() {
        return listadoEstados;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @XmlElement(name = "State")
    public void setListadoEstados(ArrayList<State> listadoEstados) {
        this.listadoEstados = listadoEstados;
    }
    @XmlAttribute(name = "Name")
    public void setName(String name) {
        this.name = name;
    }
    @XmlAttribute(name = "Code")
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CountryRegion{" +
                "listadoEstados=" + listadoEstados +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
