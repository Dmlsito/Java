package org.example;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.net.*;
public class AltoNivel {
    public static void main(String[] args) {
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
        pruebaMetodos();


    }
    public static void pruebaMetodos () {

        InetAddress dir = null;
        InetAddress dir2 = null;
        try{
            dir = InetAddress.getByName("localhost");
            dir2 = InetAddress.getByName("www.google.es");

            System.out.println("El localhost de dir es: " + dir.getLocalHost());
            System.out.println("El localhost de dir2 es: " + dir2.getLocalHost());
            //Ambos tienen el mismo localHost porque se la direccion IP a la que hacen referencia es la de la maquina qeu esta ejecutando el programa
            System.out.println(dir.getHostName());
            System.out.println(dir2.getHostName());
            System.out.println(dir.getHostAddress());
            System.out.println(dir2.getHostAddress());


        }catch(Exception e){
            System.out.println("Ha ocurrido un error");
        }

    }
}
