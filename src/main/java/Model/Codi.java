/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Francesc
 */
public class Codi {
    private String usuari;
    private String password;
    private String practiceTest;
    private Date data;
    private int usuariId;
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

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPracticeTest() {
        return practiceTest;
    }

    public void setPracticeTest(String practiceTest) {
        this.practiceTest = practiceTest;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getUsuariId() {
        return usuariId;
    }

    public void setUsuariId(int usuariId) {
        this.usuariId = usuariId;
    }

    public String getCodiExamen() {
        return codiExamen;
    }
}
