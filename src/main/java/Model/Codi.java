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
public class Codi {
    /** usuari proporcionat per Microsoft per els preTest[String]*/
    private String usuari;
    /** contrasenya proporcionada per Microsoft per els preTest [String]*/
    private String password;
    /** practiceTest proporcionat per Microsoft per els preTest [String]*/
    private String practiceTest;
    /** data a la que s'incorpora el codi a la base de dades [Date]*/
    private Date data;
    /** usuari al que assignem el codi [int]*/
    private int usuariId;
    /** codi de Examen de MOS [String]*/
    private String codiExamen;

    public Codi(String usuari, String password, String practiceTest, Date data, int usuariId) {
        this.usuari = usuari;
        this.password = password;
        this.practiceTest = practiceTest;
        this.data = data;
        this.usuariId = usuariId;
    }
    
    public Codi(String usuari, String password, String practiceTest){
        this.usuari = usuari;
        this.password = password;
        this.practiceTest = practiceTest;
    }
    /**
     * Retorna el Usuari de PreTest
     * @return String 
     */
    public String getUsuari() {
        return usuari;
    }
    /**
     * Modifica el usuari de PreTest
     * @param usuari 
     */
    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }
    /**
     * Retorna la contrassenya del PreTest
     * @return String
     */
    public String getPassword() {
        return password;
    }
    /**
     * Modifica la contrassenya del PreTest
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Retorna el codi de PracticeTest
     * @return String
     */
    public String getPracticeTest() {
        return practiceTest;
    }
    /**
     * Modifica el codi de PracticeTest
     * @param practiceTest 
     */
    public void setPracticeTest(String practiceTest) {
        this.practiceTest = practiceTest;
    }
    /**
     * Retorna la data de inserció del codi
     * @return Date
     */
    public Date getData() {
        return data;
    }
    /**
     * Modifica la data de inserció del codi
     * @param data
     */
    public void setData(Date data) {
        this.data = data;
    }
    /**
     * Retorna el id del usuari al que pertany el codi
     * @return int
     */
    public int getUsuariId() {
        return usuariId;
    }
    /**
     * Modifica el id del usuari al que pertany el codi
     * @param usuariId 
     */
    public void setUsuariId(int usuariId) {
        this.usuariId = usuariId;
    }
    /**
     * Retorna el codi del Examen de MOS
     * @return String
     */
    public String getCodiExamen() {
        return codiExamen;
    }
}
