package org.example;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

public class Ejercicio2 {

    public static void main( String[] args )
    {
        String path = "Ejercicio2.xml";

        leerXML(path);

    }
    private static void leerXML(String path){

        try{

            DocumentBuilderFactory fabricaCreador = DocumentBuilderFactory.newInstance();
            DocumentBuilder creador = fabricaCreador.newDocumentBuilder();
            Document documento = creador.parse(path);

            //Recuperamos el elemento raiz
            Element raiz = documento.getDocumentElement();

            //Creamos una nodelist con los subnodos del elemento raiz

            NodeList nodos = raiz.getElementsByTagName("pico");

            for(int i = 0; i < nodos.getLength(); i++){

                //Vamos recorriendo y guardando cada nodo
                Node nodoRio = nodos.item(i);

                Element element = (Element) nodoRio;


                //Cabecera
                System.out.println("rio " + i);
                String atributo = element.getAttribute("Nombre");
                System.out.println("Nombre: " + atributo);

                if(nodoRio != null){

                  //Recuperamos los subnodos de rio
                  NodeList subnodosRio = nodoRio.getChildNodes();
                  //Recorremos

                    for(int j = 0; j < subnodosRio.getLength(); j++){

                      Node nodo = subnodosRio.item(j);





                      if(nodo.getNodeType() == Node.ELEMENT_NODE){

                            //Recuperamos el nombre del rio
                            System.out.print(nodo.getNodeName() + ": ");

                            Node contenido = nodo.getFirstChild();
                            if(contenido.getNodeValue() != null && contenido.getNodeType() == Node.TEXT_NODE){
                                System.out.println(contenido.getNodeValue());
                            }


                        }
                    }
                    System.out.println();


                }


            }

        }catch (Exception e ){
            System.out.println("ERROR");
        }

    }
}
