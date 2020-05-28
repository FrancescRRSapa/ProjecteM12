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
public class LlistaUsuaris {
    private ArrayList<Usuari> llistatUsuaris = new ArrayList<Usuari>();
    
    public void add(Usuari u){
            llistatUsuaris.add(u);
    }
    
    public int size(){
        return llistatUsuaris.size();
    }
    
    public Usuari get(int i){
        return llistatUsuaris.get(i);
    }
    
}
