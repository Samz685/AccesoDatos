package com.mycompany.practicacsv;
import java.io.*;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
public class Practica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el libro que quieres leer: ");
        String archivo = sc.nextLine();
        String archivotxt = archivo + ".txt";
        leerArchivo(archivotxt);
        copiaTexto(archivotxt, archivo +"_histograma.csv");  
     }
     public static void leerArchivo(String origen){
         try(var fr = new BufferedReader(new FileReader(origen));)
         {
             String palabra; 
         while((palabra = fr.readLine())!=null){
             System.out.println(palabra);
             palabra = palabra.toUpperCase();  
         }
     }   catch (FileNotFoundException ex) {
             Logger.getLogger(Practica.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Practica.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     public static void copiaTexto(String origen,String destino)
    {
        String[] HEADERS = { "palabra", "cantidad"};
          HashMap<String, Integer> words = new HashMap<String, Integer>();
        try( var fr = new BufferedReader(new FileReader(origen));
             FileWriter out = new FileWriter(destino);
             CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT .withHeader(HEADERS)))
        {
             String palabra;
             System.out.println("____________________________________");
             while((palabra = fr.readLine())!= null){
             palabra = palabra.replace("\"", "");  
             palabra = palabra.replace("'", "");
             for(int i=0;i<=9;i++) {
                 String num = ""+i;
                 palabra = palabra.replace(num, "");
             }
             String[] palabras = palabra.split("[\\s,.:()?!¿¡-]");
             for(String p: palabras){
                p=p.toLowerCase();  
                if(p.length() > 2){
                    System.out.println(p);
                    String palabaCandidata = p;
                if (words.containsKey(palabaCandidata)){
                    words.computeIfPresent(palabaCandidata, (k,v)->v+1);
                }else{
                 words.computeIfAbsent(palabaCandidata, k->1);
                }
                }
            }             
         }
             System.out.println("____________________________________"); 
             for(String key : words.keySet()){
            System.out.println("Palabra: "+key+" || Cantidad: "+words.get(key));
            System.out.println("---------------------------------------");
            printer.printRecord(key,words.get(key));
        }
        } catch (IOException ex) {
            Logger.getLogger(Practica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
