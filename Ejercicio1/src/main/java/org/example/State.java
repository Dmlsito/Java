package org.example;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class State {

    private ArrayList<City> listadoCiudades;

    public State() {
    }

    public State(ArrayList<City> listadoCiudades) {
        this.listadoCiudades = listadoCiudades;
    }

    public ArrayList<City> getListadoCiudades() {
        return listadoCiudades;
    }
    @XmlElement(name = "City")
    public void setListadoCiudades(ArrayList<City> listadoCiudades) {
        this.listadoCiudades = listadoCiudades;
    }

    @Override
    public String toString() {
        return "State{" +
                "listadoCiudades=" + listadoCiudades +
                '}';
    }
}
