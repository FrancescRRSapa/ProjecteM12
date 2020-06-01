/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class CodiMOS extends Codi{
    /** codi de Examen de MOS [String] */
    private String codiExamen;

    public CodiMOS(String codiExamen, String usuari, String password, String practiceTest, Date data, int usuariId) {
        super(usuari, password, practiceTest, data, usuariId);
        this.codiExamen = codiExamen;
    }
    public CodiMOS(String codiExamen, String usuari, String password, String practiceTest){
        super(usuari, password, practiceTest);
        this.codiExamen = codiExamen;
    }
    /**
     * Retorna el codi de Examen per al MOS
     * @return String
     */
    public String getCodiExamen() {
        return codiExamen;
    }
    /**
     * Modifica el codi de Examen per al MOS
     * @param codiExamen 
     */
    public void setCodiExamen(String codiExamen) {
        this.codiExamen = codiExamen;
    }
    
}
