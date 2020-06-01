/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class LlistaConceptes {
    /** Llista amb objectes de la classe Concepte*/
    private ArrayList<Concepte> llistatConceptes = new ArrayList<Concepte>();
    /**
     * Afegeix un Concepte si aquest té vigencia
     * @param c
     */
    public void add(Concepte c){
        Date data = new Date(System.currentTimeMillis());
        if(data.compareTo(c.getDataBaixa()) >= 0){
            llistatConceptes.add(c);
        }
    }
    /**
     * Retorna una posició de la llista
     * @return int
     */
    public int size(){
        return llistatConceptes.size();
    }
    /**
     * Retorna una posició de la llista
     * @param i
     * @return Concepte
     */
    public Concepte get(int i){
        return llistatConceptes.get(i);
    }
}
