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
    
    public ArrayList<CodiMOS> llegirCodis(InputStream file){
        ArrayList<String[]> llistaCodis = (ArrayList<String[]>) LlegirCSV.llegirDades(file);
            for(int i = 0; i < llistaCodis.size(); i++) {
                CodiMOS codi1 = new CodiMOS(llistaCodis.get(i)[3], llistaCodis.get(i)[0],llistaCodis.get(i)[1], llistaCodis.get(i)[2]);
                llistaMOS.add(codi1);
            }
            return llistaMOS;
    }
    public void afegirCodi(CodiMOS codi){
        llistaMOS.add(codi);
    }
}
