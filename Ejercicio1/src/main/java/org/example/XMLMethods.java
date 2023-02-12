package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLMethods {

    public static Location listLocation(String path){
        Location location = null;

        try{
            File file = new File(path);
            if(file.exists()){
                JAXBContext context = JAXBContext.newInstance(Location.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                location = (Location) unmarshaller.unmarshal(file);
            }else{
                System.out.println("El fichero no se ha podido encontrar");
            }
        }catch(Exception e){
            System.out.println("Se ha producido un error");
        }
        return location;

    }
    public List<City> recuperarCiudades(Location location){
        List<City> listadoCiudades = new ArrayList<City>();
        try {
            for(CountryRegion countryRegion: location.getListadoRegiones()){

                if(countryRegion.getListadoEstados() != null){
                    for(State state: countryRegion.getListadoEstados()){

                        if(state.getListadoCiudades() != null){
                            for (City city1:state.getListadoCiudades()){

                                City city = new City(city1.getName(),city1.getCode());
                                listadoCiudades.add(city);
                            }
                        }}}}
        }catch (Exception e){
            e.printStackTrace();
        }

        return listadoCiudades;
    }
}
