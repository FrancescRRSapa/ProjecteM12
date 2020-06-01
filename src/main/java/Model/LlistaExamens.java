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
public class LlistaExamens {
    /** Llista amb objectes de la classe Examen*/
    private ArrayList<Examen> llistatExamens = new ArrayList<Examen>();
    /**
     * Afegeix un Examen
     * @param e 
     */
    public void add(Examen e){
        llistatExamens.add(e);
    }
    /**
     * Número de Examens que incorpora la llista
     * @return int
     */
    public int size(){
        return llistatExamens.size();
    }
    /**
     * Retorna un Examen de la llista
     * @param i
     * @return Examen
     */
    public Examen get(int i){
        return llistatExamens.get(i);
    }
}
