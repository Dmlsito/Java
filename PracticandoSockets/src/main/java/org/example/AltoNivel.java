package org.example;

import java.net.*;
public class AltoNivel
{
    public static void main( String[] args )
    {
        //Antes de comenzar a programar vamos a definir una serie de metodos de la clase InetAddress

        /*
        getLocalHost() => devuelve un objeto  InetAddress que representa la direccion IP de la maquina donde se esta
        ejecutando el programa

        InetAddress.getByName(String host) -> devuelve un objeto InetAddress que representa la direccion IP de la maquina
        que se especifica como parametro.

        InetAddress[].getAllByName(String host) devuelve un array de objetos InetAddres. Esto es muy util para saber
        todas las direcciones IP que tenga asiganadas una maquina en particular

        String getHostAddress() -> devuelve la direccion IP de un objeto InetAddress en forma de cadena

        String getHostName() -> Devuelve el nombre del host de un objeto InetAddress

        String getCanonicalHostName => Obtiene el nombre canonico completo de un objeto InetAddress
         */

        InetAddress dir = null;
        try{

            InetAddress dir3 = InetAddress.getByName("localhost");
            System.out.println();
            System.out.println("===========================================");
            System.out.println("Salida para una url");
            dir = InetAddress.getByName("www.google.es");
            System.out.println(dir.getHostName());
            System.out.println("Direcciones IP para " + dir.getHostName());
            InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
            for(int i = 0; i < direcciones.length; i++){
                System.out.println(direcciones[i].toString());
                System.out.println("====================");
            }

        }catch(UnknownHostException e){
            e.printStackTrace();
        }

        pruebaMetodos(dir);


    }

    public static void pruebaMetodos(InetAddress dir){
        InetAddress dir2 = null;
        try{
            //A este objeto dir2 le estoy asignando el objeto InetAddress de esta maquina, que representa su direccion IP
            dir2 = InetAddress.getLocalHost();
            System.out.println("Metodo getLocalHost(): " + dir2);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }

        //Usamos metodos de la clase
        //Consigo el host de el objeto InetAddress
        System.out.println("getHostName(): " + dir.getHostName());
        //Consigo en forma de string la direccion IP del objeto InetAdress
        System.out.println("getHostAddress(): " + dir.getHostAddress());
        //Convierto a string el objeto InetAddress dir
        System.out.println("toString(): " + dir.toString());
        //Obtengo el nombre verdadero del host del objeto dir
        System.out.println("getCanonicalHostName: " + dir.getCanonicalHostName() );
    }
}
