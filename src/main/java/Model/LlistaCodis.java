/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class LlistaCodis {
    /** Llista amb objectes de la classe Codi*/
    ArrayList<Codi> llistaCodis = new ArrayList<Codi>();
    /**
     * Crea objectes CodiMOS o CodiMTA i l'incorpora a la llista de codis
     * @param file
     * @return LlistaCodis
     */
    public LlistaCodis llegirCodis(InputStream file){
        LlistaCodis llistatCodis = new LlistaCodis();
        ArrayList<String[]> dades = (ArrayList<String[]>) LlegirCSV.llegirDades(file);
            for(int i = 0; i < dades.size(); i++) {
                if(dades.get(i).length == 4){
                    CodiMOS codi = new CodiMOS(dades.get(i)[3], dades.get(i)[0],dades.get(i)[1], dades.get(i)[2]);
                    llistatCodis.add(codi);
                }else{
                    CodiMTA codi = new CodiMTA(dades.get(i)[0],dades.get(i)[1], dades.get(i)[2]);
                    llistatCodis.add(codi);
                }
            }
            return llistatCodis;
    }
    /**
     * Afegeix un Codi
     * @param codi 
     */
    public void add(Codi codi){
        llistaCodis.add(codi);
    }
    /**
     * Número de Codis que incorpora la llista
     * @return int
     */
    public int size(){
        return llistaCodis.size();
    }
    /**
     * Retorna una posició de la llista
     * @param i
     * @return Codi
     */
    public Codi get(int i){
        return llistaCodis.get(i);
    }
}
