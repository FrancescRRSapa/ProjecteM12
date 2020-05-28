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
public class LlistaHoresExamens {
    ArrayList<HoraExamen> llistatHoraExamen = new ArrayList<HoraExamen>();
    
    public void add(HoraExamen h){
            llistatHoraExamen.add(h);
    }
    
    public int size(){
        return llistatHoraExamen.size();
    }
    
    public HoraExamen get(int i){
        return llistatHoraExamen.get(i);
    }
}
