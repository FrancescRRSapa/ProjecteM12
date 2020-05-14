/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import llegircsv.*;
import Model.Codi;
import llegircsv.LlegirCSV;
import java.util.ArrayList;
/**
 *
 * @author Francesc
 */
public class LlistaCodisPreTestMOS {
    ArrayList<CodiPreTestMOS> llistaPreTestMOS = new ArrayList<CodiPreTestMOS>();
    String path = "C:\\Users\\ferna\\Documents\\ProjecteM12\\ProjecteM12\\src\\main\\java\\llegircsv\\codisPreTest.csv";
    
    public ArrayList<CodiPreTestMOS> llegirCodis(){
        ArrayList<String[]> llistaCodis = (ArrayList<String[]>) LlegirCSV.llegirDades(path);
            for(int i = 0; i < llistaCodis.size(); i++) {
                CodiPreTestMOS codi1 = new CodiPreTestMOS(llistaCodis.get(i)[0],llistaCodis.get(i)[1], llistaCodis.get(i)[2]);
                llistaPreTestMOS.add(codi1);
            }
            return llistaPreTestMOS;
    }
    public void afegirCodi(CodiPreTestMOS codi){
        llistaPreTestMOS.add(codi);
    }
}
