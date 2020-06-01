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
public class LlistaUsuaris {
    /** Llista amb objectes de la classe Usuari*/
    private ArrayList<Usuari> llistatUsuaris = new ArrayList<Usuari>();
    /**
     * Afegeix un Usuari
     * @param u 
     */
    public void add(Usuari u){
            llistatUsuaris.add(u);
    }
    /**
     * Número de Usuaris que incorpora la llista
     * @return int
     */
    public int size(){
        return llistatUsuaris.size();
    }
    /**
     * Retorna una posició de la llista
     * @param i
     * @return Usuari object
     */
    public Usuari get(int i){
        return llistatUsuaris.get(i);
    }
    
}
