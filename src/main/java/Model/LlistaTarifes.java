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
public class LlistaTarifes {
    private ArrayList<Tarifa> llistatTarifes = new ArrayList<Tarifa>();
    
    public void add(Tarifa t){
        Date data = new Date(System.currentTimeMillis());
        if(data.compareTo(t.getDataBaixa()) >= 0){
            llistatTarifes.add(t);
        }
    }
    
    public int size(){
        return llistatTarifes.size();
    }
    
    public Tarifa get(int i){
        return llistatTarifes.get(i);
    }
}
