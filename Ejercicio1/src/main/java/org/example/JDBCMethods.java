package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JDBCMethods {
    public void crearTabla() throws SQLException {

        Connection c = Hikari.getConnection();
        Statement s = null;

        try{
            s= c.createStatement();
            String sentenciaDDL ="CREATE TABLE Ciudades ("
                    +"Id int IDENTITY(1,1) NOT NULL PRIMARY KEY,"
                    +"Name varchar(50) NOT NULL,"
                    +"Code varchar(50) NOT NULL)";

            s.executeUpdate(sentenciaDDL);
            System.out.println("Crear tabla OK");


        }catch (SQLException e){
            System.out.println("Crear tabla KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();
            if(c!=null) c.close();


        }
    }

    public void insertarAll(List<City> listadoCiudades) throws SQLException {
        Connection connection = null;
        PreparedStatement p = null;

        try{
            connection = Hikari.getConnection();
            p = connection.prepareStatement("INSERT INTO Ciudades (Name, Code) VALUES(?, ?)");
            for(City city: listadoCiudades){
                p.setString(1, city.getName());
                p.setString(2, city.getCode());

                p.addBatch();
            }
            p.executeBatch();
        }catch(SQLException e){
            System.out.println("Se ha producido un error");
            throw new RuntimeException(e);
        }finally {
            if(connection != null) connection.close();
            if(p != null) p.close();
        }

    }
}
