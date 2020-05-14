/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ferna
 */
public class CodiTestMOS extends Codi{
    private String codiExamen;

    public CodiTestMOS(String codiExamen, String usuari, String password, String practiceTest) {
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
