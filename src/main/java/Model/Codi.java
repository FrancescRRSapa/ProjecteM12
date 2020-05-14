/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Francesc
 */
public class Codi {
    private String usuari;
    private String password;
    private String practiceTest;

    //Constructor
    public Codi(String usuari, String password, String practiceTest) {
        this.usuari = usuari;
        this.password = password;
        this.practiceTest = practiceTest;
    }
    
    //GETTERS I SETTERS
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
}
