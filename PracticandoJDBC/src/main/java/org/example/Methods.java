package org.example;

import java.sql.*;

public class Methods {

    public Methods(){}

    public static Connection conectionToBBDD(){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database = Prueba;"
                + "user = sa;"
                + "password = instiagra;"
                + "encrypt=true;"
                + "trustServerCertificate = true;"
                + "loginTimeout = 30;";
        try{
            Connection connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Conexion establecida");
            return connection;
        }catch(SQLException e){
            System.out.println("Error de conexion");
            throw new RuntimeException(e);
        }
    }

    //Method to create a table
    public static void createTable() throws SQLException {
        Connection connection = null;
        Statement s = null;
        try{
            connection = conectionToBBDD();
            s = connection.createStatement();
            String ddl = "CREATE TABLE Jugadores (id int IDENTITY(1,1) PRIMARY KEY, " +
                    "nombre varchar(20) NOT NULL, dorsal int NOT NULL)";
            s.executeUpdate(ddl);
            System.out.println("Se ha creado la tabla");
        }catch(SQLException e){
            System.out.println("Ha ocurrido un problema");
            throw new RuntimeException(e);
        }
        finally{
            if(connection != null) connection.close();
            if(s != null) s.close();

        }
    }

    //Method to insert data
    public static void insertData(Jugador jugador) throws SQLException{
        Connection connection = null;
        PreparedStatement p = null;
        try{
            connection = conectionToBBDD();
            p = connection.prepareStatement("INSERT INTO Jugadores (nombre, dorsal) VALUES(?, ?)");
            p.setString(1, jugador.getNombre());
            p.setInt(2, jugador.getDorsal());
            p.executeUpdate();
            System.out.println("El dato se ha insertado con exito");
        }catch(SQLException e){
            System.out.println("No se ha podido insertar el dato");
            throw new RuntimeException (e);

        }finally{
            if(connection != null) connection.close();
            if(p != null) p.close();
        }
    }

    //Method to search Data
    public static void select() throws SQLException {
        Connection connection = null;
        PreparedStatement p = null;
        try{
            connection = conectionToBBDD();
            p = connection.prepareStatement("SELECT * FROM Jugadores WHERE nombre =  ? ");
            p.setString(1, "Daniel");
            //Cuando queremos recoger algo de la base de datos tenemos que utilizar el metodo executeQuery que nos devuelve un objet ResultSet con la informacion
            ResultSet info = p.executeQuery();
            System.out.println("Resultado ->");
            Jugador jugador = new Jugador();
            //Lo recorremos
            while(info.next()){
                jugador.setId(info.getInt("id"));
                jugador.setNombre(info.getString("nombre"));
                jugador.setDorsal(info.getInt("dorsal"));
            }
            System.out.println(jugador);

        }catch(SQLException e){
            System.out.println("Ha ocurrido un error");
            throw new RuntimeException(e);
        }finally{
            if(connection != null) connection.close();
            if(p != null) p.close();
        }
    }

    public static void callProcedure() throws SQLException{
        Connection connection = null;
        PreparedStatement p = null;
        try{
            connection = conectionToBBDD();
            p = connection.prepareStatement("{call obtenerJugadores(?)}");
            p.setString(1, "Daniel");
            System.out.println("Resultado =>");
            ResultSet info = p.executeQuery();
            while(info.next()){
                Jugador jugador = new Jugador(info.getInt("id"), info.getString("nombre"), info.getInt("dorsal"));
                System.out.println(jugador);
            }
        }catch(SQLException e){
            System.out.println("Algo ha ocurrido");
            throw new RuntimeException(e);
        }finally{
            if(connection != null) connection.close();
            if(p != null) p.close();
        }
    }

    //Transaction
    public static void transaction() throws SQLException {
        Connection connection = null;
        PreparedStatement p = null;
        try{
            connection = conectionToBBDD();
            connection.setAutoCommit(false);
            p = connection.prepareStatement("INSERT INTO Jugadores (nombre, dorsal) VALUES (?, ?)");
            p.setString(1, "Pedro");
            p.setInt(2, 10);
            p.executeUpdate();
            System.out.println("Se inserto el primer jugador");
            p.setString(1, "Pablo");
            p.setInt(2, 11);
            p.executeUpdate();
            System.out.println("Se inserto el segundo jugador");
            connection.commit();
            System.out.println("La transaccion ha finalizado");
        }catch(SQLException e){
            connection.rollback();
            System.out.println("Algo ha ocurrido");
            throw new RuntimeException(e);
        }finally {
            if(connection != null) connection.close();
            if(p != null) p.close();
        }
    }
    //Method to delete data
    public static void deleteData() throws SQLException{
        Connection connection = null;
        PreparedStatement p = null;
        try{
            connection = conectionToBBDD();
            p = connection.prepareStatement("DELETE  FROM Jugadores WHERE nombre = ?");
            p.setString(1, "Daniel");
            p.executeUpdate();
            System.out.println("Se ha borrado el campo con exito");

        }catch(SQLException e){
            System.out.println("Algo ha ocurrido");
            throw new RuntimeException(e);
        }finally{
            if(connection != null) connection.close();
            if(p != null) p.close();
        }
    }


}
