package org.hfarro.appfacturas;

import org.hfarro.appfacturas.modelo.*;

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

        System.out.println();

        final int CANTIDAD_PRODUCTOS = 5;

        for (int i = 0; i < CANTIDAD_PRODUCTOS ; i++) {
            producto = new Producto();
            System.out.println("Ingrese producto n° "+ producto.getCodigo() +": ");
            producto.setNombre(s.nextLine());

            System.out.println("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.println("Ingrese  la cantidad: ");

            factura.addItemFactura(new ItemFactura(s.nextInt(), producto));

            System.out.println();
            s.nextLine();
        }
        System.out.println(factura.generarDetalle());
    }
}
