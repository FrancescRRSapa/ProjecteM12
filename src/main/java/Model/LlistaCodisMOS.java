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
public class LlistaCodisMOS {
    ArrayList<CodiMOS> llistaMOS = new ArrayList<CodiMOS>();
    
    public LlistaCodisMOS llegirCodis(InputStream file){
        LlistaCodisMOS llistatMOS = new LlistaCodisMOS();
        ArrayList<String[]> dades = (ArrayList<String[]>) LlegirCSV.llegirDades(file);
            for(int i = 0; i < dades.size(); i++) {
                CodiMOS codi1 = new CodiMOS(dades.get(i)[3], dades.get(i)[0],dades.get(i)[1], dades.get(i)[2]);
                llistaMOS.add(codi1);
            }
            return llistatMOS;
    }
    public void add(CodiMOS codi){
        llistaMOS.add(codi);
    }
    
    public int size(){
        return llistaMOS.size();
    }
    
    public CodiMOS get(int i){
        return llistaMOS.get(i);
    }
}
