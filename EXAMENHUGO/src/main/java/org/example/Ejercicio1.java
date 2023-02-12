package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * Hello world!
 *
 */
public class Ejercicio1
{
    public static void main( String[] args )
    {

        try {
            //Llamamos a los metodos
            crearDirectorio();
            crearFichero();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private static void crearDirectorio(){

        File directorio = new File("C:\\ExamenFic");

        //Comprobamos que el directorio no existe

        try {

            if (!directorio.exists()) {
                System.out.println("Se ha creado el directorio");
                directorio.mkdir();
            } else {
                System.out.println("El directorio ya existe");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void crearFichero(){


        File fSaludo = new File("C:\\ExamenFic\\saludo.txt");
        String cadena = "El hombre que mueve montañas empieza apartando piedras pequeñas";
        OutputStreamWriter writer = null;
        FileOutputStream out = null;

        try{
            //Creamos el fichero si no existe

            if(!fSaludo.exists()){
                System.out.println("Se ha creado con exito el fichero");
                fSaludo.createNewFile();
            }else{
                System.out.println("El fichero ya se ha creado");
            }

            //Creamos los metodos de escritura

             out = new FileOutputStream(fSaludo);
             writer = new OutputStreamWriter(out, "ISO-8859-1");

             //Recorremos el contenido de la cadena y vamos escribiendo cada caracter en el fichero fSaludo
            for(int i = 0; i < cadena.length(); i++){
                writer.write(cadena.charAt(i));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(writer != null){
                    //Cerramos la escritura
                    writer.close();
                }
            }catch (Exception e){}
        }
    }
}
