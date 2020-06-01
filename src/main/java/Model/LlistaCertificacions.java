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
public class LlistaCertificacions {
    /** Llista amb objectes de la classe Certificacio*/
    ArrayList<Certificacio> llistatCertificacio = new ArrayList<Certificacio>();
    /**
     * Afegeix una Certificacio
     * @param c
     */
    public void add(Certificacio c){
        llistatCertificacio.add(c);
    }
    /**
     * Retorna una posició de la llista
     * @param i
     * @return Certificacio object
     */
    public Certificacio get(int i){
        return llistatCertificacio.get(i);
    }
    /**
     * Número de Certificacions que incorpora la llista
     * @return int
     */
    public int size(){
        return llistatCertificacio.size();
    }
}
