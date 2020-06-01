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
public class LlistaReserves {
    /** Llista amb objectes de la classe Reserva*/
    private ArrayList<Reserva> llistatReserves = new ArrayList<Reserva>();
    /**
     * Afegeix una Reserva
     * @param r 
     */
    public void add(Reserva r){
            llistatReserves.add(r);
    }
    /**
     * Número de Reserves que incorpora la llista
     * @return int
     */
    public int size(){
        return llistatReserves.size();
    }
    /**
     * Retorna una posició de la llista
     * @param i
     * @return Reserva object
     */
    public Reserva get(int i){
        return llistatReserves.get(i);
    }
}
