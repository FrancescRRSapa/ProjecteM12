/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author ferna
 */
public class LlistaCodis {
    ArrayList<Codi> llistaCodis = new ArrayList<Codi>();
    
    public LlistaCodis llegirCodis(InputStream file){
        LlistaCodis llistatCodis = new LlistaCodis();
        ArrayList<String[]> dades = (ArrayList<String[]>) LlegirCSV.llegirDades(file);
            for(int i = 0; i < dades.size(); i++) {
                if(dades.get(i).length == 4){
                    CodiMOS codi = new CodiMOS(dades.get(i)[3], dades.get(i)[0],dades.get(i)[1], dades.get(i)[2]);
                    llistatCodis.add(codi);
                }else{
                    Codi codi = new Codi(dades.get(i)[0],dades.get(i)[1], dades.get(i)[2]);
                    llistatCodis.add(codi);
                }
            }
            return llistatCodis;
    }
    public void add(Codi codi){
        llistaCodis.add(codi);
    }
    
    public int size(){
        return llistaCodis.size();
    }
    
    public Codi get(int i){
        return llistaCodis.get(i);
    }
}
