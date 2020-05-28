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
public class LlistaReserves {
    private ArrayList<Reserva> llistatReserves = new ArrayList<Reserva>();
    
    public void add(Reserva r){
            llistatReserves.add(r);
    }
    
    public int size(){
        return llistatReserves.size();
    }
    
    public Reserva get(int i){
        return llistatReserves.get(i);
    }
}
