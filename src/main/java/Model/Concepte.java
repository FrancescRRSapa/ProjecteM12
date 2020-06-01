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
public class Concepte {
    /** identificador del Concepte [int]*/
    private int idConcepte;
    /** nom del concepte [String]*/
    private String nom;
    /** data a la que comença la vigencia de un concepte [Date]*/
    private Date dataAlta;
    /** data a la que acaba la vigencia de un concepte [Date]*/
    private Date dataBaixa;

    public Concepte(int idConcepte, String nom, Date dataAlta, Date dataBaixa) {
        this.idConcepte = idConcepte;
        this.nom = nom;
        this.dataAlta = dataAlta;
        this.dataBaixa = dataBaixa;
    }
    /**
     * Retorna el identificador de un concepte
     * @return int
     */
    public int getIdConcepte() {
        return idConcepte;
    }
    /**
     * Retorna el nom de un concepte
     * @return String
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifica el nom de un concepte
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retorna la data de començament de vigencia de un Concepte
     * @return Date
     */
    public Date getDataAlta() {
        return dataAlta;
    }
    /**
     * Modifica la data de començament de vigencia de un Concepte
     * @param dataAlta 
     */
    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }
    /**.
     * Retorna la data de finalització de vigencia de un Concepte
     * @return Date
     */
    public Date getDataBaixa() {
        return dataBaixa;
    }
    /**
     * Modifica la data de finalització de vigencia de un Concepte
     * @param dataBaixa 
     */
    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }
    
}
