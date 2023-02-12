package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement(name = "Location")
public class Location {
    private ArrayList<CountryRegion> listadoRegiones;

    public Location() {
    }

    public Location(ArrayList<CountryRegion> listadoRegiones) {
        this.listadoRegiones = listadoRegiones;
    }

    public ArrayList<CountryRegion> getListadoRegiones() {
        return listadoRegiones;
    }
    @XmlElement(name = "CountryRegion")
    public void setListadoRegiones(ArrayList<CountryRegion> listadoRegiones) {
        this.listadoRegiones = listadoRegiones;
    }

    @Override
    public String toString() {
        return "Location{" +
                 listadoRegiones +
                '}';
    }
}
