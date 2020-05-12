/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.llegircsv;
import com.mycompany.llegircsv.Codi;
import com.mycompany.llegircsv.LlegirCSV;
import java.util.ArrayList;
/**
 *
 * @author Francesc
 */
public class llistaCodis {
    ArrayList<Codi> llistaUsuariExamen = new ArrayList<Codi>();
    String path = "C:\\Users\\Francesc\\Documents\\Documents classe\\DAW2\\M12 - Projecte\\proyectom12\\proyectom12\\src\\main\\java\\com\\mycompany\\llegircsv\\codisPreTest.csv";
    
    public ArrayList<Codi> llegirCodis(){
        ArrayList<String[]> llistaCodis = new ArrayList<String[]>();
        llistaCodis = (ArrayList<String[]>) LlegirCSV.llegirDades(path);
        //ArrayList<Codi> Codis = new ArrayList<>();
            for(int i = 0; i < llistaCodis.size(); i++) {
                Codi codi1 = new Codi(llistaCodis.get(i)[0],llistaCodis.get(i)[1], llistaCodis.get(i)[2]);
                llistaUsuariExamen.add(codi1);
            }
            return llistaUsuariExamen;
    }
    public void afegirCodi(Codi codi){
        llistaUsuariExamen.add(codi);
    }
}
