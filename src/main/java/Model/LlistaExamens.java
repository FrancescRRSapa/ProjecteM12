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
public class LlistaExamens {
    private ArrayList<Examen> llistatExamens = new ArrayList<Examen>();
    public void add(Examen e){
        llistatExamens.add(e);
    }
    
    public int size(){
        return llistatExamens.size();
    }
    
    public Examen get(int i){
        return llistatExamens.get(i);
    }
}
