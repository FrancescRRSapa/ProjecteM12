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
public class LlistaTarifes {
    /** Llista amb objectes de la classe Tarifa*/
    private ArrayList<Tarifa> llistatTarifes = new ArrayList<Tarifa>();
    /**
     * Afegeix una Tarifa si té vigencia
     * @param t 
     */
    public void add(Tarifa t){
        Date data = new Date(System.currentTimeMillis());
        if(data.compareTo(t.getDataBaixa()) >= 0){
            llistatTarifes.add(t);
        }
    }
    /**
     * Número de Certificacions que incorpora la llista
     * @return int
     */
    public int size(){
        return llistatTarifes.size();
    }
    /**
     * Retorna una posició de la llista
     * @param i
     * @return Tarifa object
     */
    public Tarifa get(int i){
        return llistatTarifes.get(i);
    }
}
