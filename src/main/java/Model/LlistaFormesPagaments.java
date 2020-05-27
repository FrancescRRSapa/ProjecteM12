/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author ferna
 */
public class LlistaFormesPagaments {
    ArrayList<Examen> llistaFormesPagaments = new ArrayList<Examen>();
    
    public LlistaExamens llegirExamens() throws ParseException{
        LlistaFormesPagaments llistatFormesPagaments = new LlistaFormesPagaments();
        ArrayList<String[]> dades = (ArrayList<String[]>) LlegirCSV.llegirDades(file);
            for(int i = 0; i < dades.size(); i++) {
                Examen examen = new Examen(Integer.parseInt(dades.get(i)[0]), Integer.parseInt(dades.get(i)[1]), Boolean.parseBoolean(dades.get(i)[2]), 
                        new SimpleDateFormat("yyyy/MM/dd").parse(dades.get(i)[3]), 
                        new SimpleDateFormat("yyyy/MM/dd").parse(dades.get(i)[4]), dades.get(i)[5], dades.get(i)[6]);
                llistatExamens.add(examen);
            }
            return llistatExamens;
    }
    public void add(Examen examen){
        llistaExamens.add(examen);
    }
    
    public int size(){
        return llistaExamens.size();
    }
    
    public Examen get(int i){
        return llistaExamens.get(i);
    }
}
