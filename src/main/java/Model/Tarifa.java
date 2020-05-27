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
public class Tarifa {
    private int idTarifa;
    private int idGrupPartit;
    private int idConcepte;
    private String nom;
    private double preu;
    private Date dataAlta;
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

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public int getIdGrupPartit() {
        return idGrupPartit;
    }

    public void setIdGrupPartit(int idGrupPartit) {
        this.idGrupPartit = idGrupPartit;
    }

    public int getIdConcepte() {
        return idConcepte;
    }

    public void setIdConcepte(int idConcepte) {
        this.idConcepte = idConcepte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }
    
    
}
