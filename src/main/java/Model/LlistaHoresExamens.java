/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class LlistaHoresExamens {
    /** Llista amb objectes de la classe HoraExamen*/
    ArrayList<HoraExamen> llistatHoraExamen = new ArrayList<HoraExamen>();
    /**
     * Afegeix una HoraExamen
     * @param h 
     */
    public void add(HoraExamen h){
            llistatHoraExamen.add(h);
    }
    /**
     * Número de HoraExamen que incorpora la llista
     * @return int
     */
    public int size(){
        return llistatHoraExamen.size();
    }
    /**
     * Retorna una posició de la llista
     * @param i
     * @return HoraExamen object
     */
    public HoraExamen get(int i){
        return llistatHoraExamen.get(i);
    }
}
