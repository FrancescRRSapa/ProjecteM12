/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */


public class LlegirCSV {
    /**
    * Llegeix un fitxer csv i l'inforpora al ArrayList
    * @param file
    * @return ArrayList<String[]>
    */
    public static ArrayList<String[]> llegirDades (InputStream file) {
        ArrayList<String[]> tota_linia = new ArrayList<String[]>();
        //ArrayList<String> tota_linia = new ArrayList<String>();

        //Faig un sol arraylist per tots els camps que llegirem perque no sabem quants tindrem depenen de si necessitem
        //llegir el fitxer de clients o de vehicles o lloguers?
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
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
