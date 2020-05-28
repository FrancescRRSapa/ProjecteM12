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
public class CodiMTA extends Codi{

    public CodiMTA(String usuari, String password, String practiceTest, Date data, int usuariId) {
        super(usuari, password, practiceTest, data, usuariId);
    }
    
    public CodiMTA(String usuari, String password, String practiceTest){
        super(usuari, password, practiceTest);
    }
}
