/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.sql.Date;

/**
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class LlistaGrupsPartits {
    /** Llista amb objectes de la classe GrupCertificacio*/
    private ArrayList<GrupPartit> llistatGrupsPartits = new ArrayList<GrupPartit>();
    /**
     * Afegeix un GrupPartit si té vigencia
     * @param g 
     */
    public void add(GrupPartit g){
        Date data = new Date(System.currentTimeMillis());
        if(data.compareTo(g.getDataBaixa()) > 0){
            llistatGrupsPartits.add(g);
        }
    }
    /**
     * Número de GrupPartit que incorpora la llista
     * @return int
     */
    public int size(){
        return llistatGrupsPartits.size();
    }
    /**
     * Retorna una posició de la llista
     * @param i
     * @return GrupPartit
     */
    public GrupPartit get(int i){
        return llistatGrupsPartits.get(i);
    }
}
