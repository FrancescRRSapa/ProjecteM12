/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author ferna
 */
public class LlistaGrupsPartits {
    private ArrayList<GrupPartit> llistatGrupsPartits = new ArrayList<GrupPartit>();
    
    public void add(GrupPartit g){
        Date data = new Date(System.currentTimeMillis());
        if(data.compareTo(g.getDataBaixa()) > 0){
            llistatGrupsPartits.add(g);
        }
    }
    
    public int size(){
        return llistatGrupsPartits.size();
    }
    
    public GrupPartit get(int i){
        return llistatGrupsPartits.get(i);
    }
}
