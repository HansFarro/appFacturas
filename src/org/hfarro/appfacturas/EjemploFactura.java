package org.hfarro.appfacturas;

import org.hfarro.appfacturas.modelo.Cliente;
import org.hfarro.appfacturas.modelo.Factura;
import org.hfarro.appfacturas.modelo.ItemFactura;
import org.hfarro.appfacturas.modelo.Producto;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Andrés");

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese una descripcion de la factura");
        String  desc = s.nextLine();
        Factura factura = new Factura(desc,cliente);

        Producto producto;
        String nombre;
        float precio;
        int cantidad;

        System.out.println();

        final int CANTIDAD_PRODUCTOS = 5;

        for (int i = 0; i < CANTIDAD_PRODUCTOS ; i++) {
            producto = new Producto();
            System.out.println("Ingrese producto n° "+ producto.getCodigo() +": ");
            nombre = s.nextLine();
            producto.setNombre(nombre);

            System.out.println("Ingrese el precio: ");
            precio = s.nextFloat();
            producto.setPrecio(precio);

            System.out.println("Ingrese  la cantidad: ");
            cantidad = s.nextInt();

            ItemFactura item = new ItemFactura(cantidad, producto);
            factura.addItemFactura(item);

            System.out.println();
            s.nextLine();
        }
        System.out.println(factura.generarDetalle());
    }
}
