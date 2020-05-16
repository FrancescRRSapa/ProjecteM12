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
public class LlistaCodisMTA {
    ArrayList<CodiMTA> llistaMTA = new ArrayList<CodiMTA>();
    
    public ArrayList<CodiMTA> llegirCodis(InputStream file){
        ArrayList<String[]> llistaCodis = (ArrayList<String[]>) LlegirCSV.llegirDades(file);
            for(int i = 0; i < llistaCodis.size(); i++) {
                CodiMTA codi1 = new CodiMTA(llistaCodis.get(i)[0],llistaCodis.get(i)[1], llistaCodis.get(i)[2]);
                llistaMTA.add(codi1);
            }
            return llistaMTA;
    }
    public void afegirCodi(CodiMTA codi){
        llistaMTA.add(codi);
    }
}
