/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author ferna
 */
public class LlistaCertificacions {
    ArrayList<Certificacio> llistatCertificacio = new ArrayList<Certificacio>();
    
    public void add(Certificacio c){
        llistatCertificacio.add(c);
    }
    
    public Certificacio get(int i){
        return llistatCertificacio.get(i);
    }
    
    public int size(){
        return llistatCertificacio.size();
    }
}
