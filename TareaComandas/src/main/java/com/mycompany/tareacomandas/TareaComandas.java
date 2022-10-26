/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tareacomandas;

import controlador.ProductoDAOmySQL;
import java.util.ArrayList;
import modelos.Producto;

/**
 *
 * @author Syzer
 */
public class TareaComandas {

    static ProductoDAOmySQL dao = new ProductoDAOmySQL();
    
    public static void main(String[] args) {
        
        
        ProductoDAOmySQL p = new ProductoDAOmySQL();
        
        System.out.println(p.verProducto(1).getNombre()+" "+p.verProducto(1).getPrecio());
        
        ArrayList<Producto> carta = new ArrayList<>();
        
      
        for (Producto producto : dao.verCarta()) {
            System.out.println(producto.toString());
            carta.add(producto);
        }
        
        System.out.println("-------------------");
            for (Producto producto : carta) {
                System.out.println(producto);
        }
            
          
        Producto p1 = new Producto();
        p1.setNombre("Sandwich de pavo");
        p1.setTipo("Integral");
        p1.setPrecio(5);
        p1.setDisponibilidad("SI");
        
        dao.añadir(p1);
        p1.setPrecio(50);
        p1.setDisponibilidad("AGOTADO");
        dao.update(p1);
        
        
        
        
        
        
        
        
        
    }
}
