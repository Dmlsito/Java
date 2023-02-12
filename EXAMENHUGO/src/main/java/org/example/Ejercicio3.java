package org.example;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Ejercicio3 {

    public static void main( String[] args )
    {
        String ruta = "Ejercicio3.dat";

        //Creo el arraylist
        ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
        Jugador jugador1 = new Jugador("Daniel", 4, 49.3);
        Jugador jugador2 = new Jugador("Marcos", 6, 98.3);
        Jugador jugador3 = new Jugador("Pablo", 7, 87.4);
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);

        //Escribimos estos tres jugadores en el fichero creado

        escribirFichero( listaJugadores, ruta);

        //Limpiamos el anterior ArrayList
        listaJugadores.clear();
        listaJugadores = leerFichero(ruta);

        System.out.println(listaJugadores);



    }

    private static void escribirFichero(ArrayList<Jugador> listaJugadores, String ruta){

        File file = new File(ruta);
        RandomAccessFile random = null;


        try{

            if(!file.exists()){
                System.out.println("Has creado este fichero con exito");
                file.createNewFile();
            }else{
                System.out.println("Este fichero ya ha sido creado");
            }

            random = new RandomAccessFile(file, "rw");

            //Recorremos la lista de los jugadores

            for(Jugador jugador: listaJugadores){

                //Escribimos el nombre
                StringBuilder nombre = new StringBuilder(jugador.getNombre());
                //Al setear el nombre en un SringBuilder le podemos setear una longitud, asi todos los nombres ocuparan los mismos bytes
                //En concreto 20
                nombre.setLength(10);
                random.writeChars(nombre.toString());
                random.writeInt(jugador.getDorsal());
                random.writeDouble(jugador.getPuntuacion());
            }

            //
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(random != null){
                    random.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static ArrayList<Jugador> leerFichero(String ruta) {
        RandomAccessFile random2 = null;
       StringBuilder nombre1 = new StringBuilder();
       StringBuilder nombre2 = new StringBuilder();
       StringBuilder nombre3 = new StringBuilder();
        ArrayList<Jugador> listadoJugadores = new ArrayList<Jugador>();

        try {
            random2 = new RandomAccessFile(ruta, "rw");


            //Nos ponemos en el primer jugador
            random2.seek(0);

            //Recorremos diez posiciones porque hemos seteado anteriormete que todos los nombres ocupen 10 caracteres
            for(int i = 0; i < 10; i++){
                nombre1.append(random2.readChar());
            }

            Jugador jugador1 = new Jugador(nombre1.toString(), random2.readInt(), random2.readDouble());
            listadoJugadores.add(jugador1);

            //Nos posicionamos en el segundo jugador

            random2.seek(32);
            for(int j = 0; j < 10; j++){
               nombre2.append(random2.readChar());
            }
            Jugador jugador2 = new Jugador(nombre2.toString(), random2.readInt(), random2.readDouble());
            listadoJugadores.add(jugador2);

            //Nos posicionamos en el tercer jugador

            random2.seek(64);
            for(int i = 0; i < 10; i++){
                nombre3.append(random2.readChar());
            }
            Jugador jugador3 = new Jugador(nombre3.toString(), random2.readInt(), random2.readDouble());
            listadoJugadores.add(jugador3);



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //Cerramos todo
            try{
                if(random2 != null){
                    random2.close();
                }
            }catch (Exception e){}
        }

        return listadoJugadores;
    }
}
