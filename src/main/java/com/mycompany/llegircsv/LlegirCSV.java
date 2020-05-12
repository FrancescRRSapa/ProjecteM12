/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.llegircsv;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Francesc
 */
public class LlegirCSV {
    public static ArrayList<String[]> llegirDades (String path) {
        ArrayList<String[]> tota_linia = new ArrayList<String[]>();
        //ArrayList<String> tota_linia = new ArrayList<String>();

        //Faig un sol arraylist per tots els camps que llegirem perque no sabem quants tindrem depenen de si necessitem
        //llegir el fitxer de clients o de vehicles o lloguers?

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;   
            while ((line = br.readLine()) != null) {
                String[] valorsSeparats = line.split(";");
                tota_linia.add(valorsSeparats);
            }
        } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("Ha fallat!, Error " + e);
        }
         return tota_linia;
    }
}
