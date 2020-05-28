/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author ferna
 */
public class CodiMOS extends Codi{
    private String codiExamen;

    public CodiMOS(String codiExamen, String usuari, String password, String practiceTest, Date data, int usuariId) {
        super(usuari, password, practiceTest, data, usuariId);
        this.codiExamen = codiExamen;
    }
    
    public CodiMOS(String codiExamen, String usuari, String password, String practiceTest){
        super(usuari, password, practiceTest);
        this.codiExamen = codiExamen;
    }

    public String getCodiExamen() {
        return codiExamen;
    }

    public void setCodiExamen(String codiExamen) {
        this.codiExamen = codiExamen;
    }
    
}
