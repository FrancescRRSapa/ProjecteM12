/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author ferna
 */
public class LlistaConceptes {
    private ArrayList<Concepte> llistatConceptes = new ArrayList<Concepte>();
    
    public void add(Concepte c){
        Date data = new Date(System.currentTimeMillis());
        if(data.compareTo(c.getDataBaixa()) >= 0){
            llistatConceptes.add(c);
        }
    }
    
    public int size(){
        return llistatConceptes.size();
    }
    
    public Concepte get(int i){
        return llistatConceptes.get(i);
    }
}
