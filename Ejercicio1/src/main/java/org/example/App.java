package org.example;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        String path = "Ciudades.xml";
        XMLMethods methods = new XMLMethods();
        Location location = methods.listLocation(path);
        //System.out.println(methods.recuperarCiudades(location));
        JDBCMethods methodsJDBC = new JDBCMethods();
        methodsJDBC.crearTabla();
        methodsJDBC.insertarAll(methods.recuperarCiudades(location));


    }
}
