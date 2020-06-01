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
public class Tarifa {
    /** identificador de la tarifa [int]*/
    private int idTarifa;
    /** identificador de Grup Partit per aquesta tarifa [int]*/
    private int idGrupPartit;
    /** identificador de Concepte per aquesta tarifa [int]*/
    private int idConcepte;
    /** nom de la tarifa [String] */
    private String nom;
    /** preu de la tarifa [double] */
    private double preu;
    /** data a la que comença la vigencia de la tarifa */
    private Date dataAlta;
    /** data a la que finalitza la vigencia de la tarifa */
    private Date dataBaixa;

    public Tarifa(int idTarifa, int idGrupPartit, int idConcepte, String nom, double preu, Date data_alta, Date data_baixa) {
        this.idTarifa = idTarifa;
        this.idGrupPartit = idGrupPartit;
        this.idConcepte = idConcepte;
        this.nom = nom;
        this.preu = preu;
        this.dataAlta = data_alta;
        this.dataBaixa = data_baixa;
    }
    /**
     * Retorna el id de la tarifa
     * @return int
     */
    public int getIdTarifa() {
        return idTarifa;
    }
    /**
     * Retorna el id del Grup Partit de la tarifa
     * @return int
     */
    public int getIdGrupPartit() {
        return idGrupPartit;
    }
    /**
     * Modifica el id del Grup Partit de la tarifa
     * @param idGrupPartit 
     */
    public void setIdGrupPartit(int idGrupPartit) {
        this.idGrupPartit = idGrupPartit;
    }
    /**
     * Retorna el id del Concepte de la tarifa
     * @return int
     */
    public int getIdConcepte() {
        return idConcepte;
    }
    /**
     * Modifica el id del Concepte de la tarifa
     * @param idConcepte 
     */
    public void setIdConcepte(int idConcepte) {
        this.idConcepte = idConcepte;
    }
    /**
     * Retorna el nom de la tarifa
     * @return String
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifica el nom de la tarifa
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retorna el preu de la tarifa
     * @return double
     */
    public double getPreu() {
        return preu;
    }
    /**
     * Modifica el preu de la tarifa
     * @param preu 
     */
    public void setPreu(double preu) {
        this.preu = preu;
    }
    /**
     * Retorna la data a la que comença la vigencia de la tarifa
     * @return Date
     */
    public Date getDataAlta() {
        return dataAlta;
    }
    /**
     * Modifica la data a la que comença la vigencia de la tarifa
     * @param dataAlta 
     */
    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }
    /**
     * Retorna la data a la que finalitza la vigencia de una tarifa
     * @return Date
     */
    public Date getDataBaixa() {
        return dataBaixa;
    }
    /**
     * Modifica la data a la que finalitza la vigencia de una tarifa
     * @param dataBaixa 
     */
    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }
}
