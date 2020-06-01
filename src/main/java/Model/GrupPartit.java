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
public class GrupPartit {
    /** Identificador de Grup Partit [int]*/
    private int idGrupPartit;
    /** nom de Grup Partit [String]*/
    private String nom;
    /** data a la que comença la vigencia de un Grup Partit [Date]*/
    private Date dataAlta;
    /** data a la que finalitza la vigencia de un Grup Partit [Date]*/
    private Date dataBaixa;

    public GrupPartit(int idGrupPartit, String nom, Date data_alta, Date data_baixa) {
        this.idGrupPartit = idGrupPartit;
        this.nom = nom;
        this.dataAlta = data_alta;
        this.dataBaixa = data_baixa;
    }
    /**
     * Retorna el identificador del grup Partit
     * @return int
     */
    public int getIdGrupPartit() {
        return idGrupPartit;
    }
    /**
     * Retorna el nom de un Grup Partit
     * @return String
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifica el nom de un Grup Partit
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retorna la data d'inici de vigencia de un Grup Partit
     * @return Date
     */
    public Date getDataAlta() {
        return dataAlta;
    }
    /**
     * Modifica la data d'inici de vigencia de un Grup Partit
     * @param dataAlta 
     */
    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }
    /**
     * Retorna la data de finalització de vigencia de un Grup Partit
     * @return Date
     */
    public Date getDataBaixa() {
        return dataBaixa;
    }
    /**
     * Modifica la data de finalització de vigencia de un Grup Partit
     * @param dataBaixa 
     */
    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }
    
}

