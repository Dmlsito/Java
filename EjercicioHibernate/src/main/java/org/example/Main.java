package org.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {

        /*Ejercicio
        * Operaciones CRUD de proveedores(Suppliers)
        * Listar proveedores de una ciudad concreta mediante SQL nativo
        * Listar todos los proveedores mediante HQL
        * Operaciones CRUD de categorias mediante SQL nativo
        * Operaciones CRUD de productos (Products)
        * Obtener cuantos productos tenemos en stock (UnitsInStock) mediante SQL nativo
        * Listar todos lso productos, mostrando toda la informacion de su proveedor y categoria */
        try {
            Suppliers suplier = new Suppliers("Esto es una prueba", "Esto es una prueba", "Esto es una prueba", "Esto es una prueba", "Esto es una prueba", "Esto es una prueba", "Esto es una prueba", "Esto es una prueba", "Esto es una prueba", "Esto es una prueba", "Esto es una prueba");
            OperacionesCRUD operacion = new OperacionesCRUD();
            operacion.insert(suplier);
        }catch(Exception e){
            System.out.println("Ha ocurrido un problema");
        }
    }

}
