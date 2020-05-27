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
public class GrupPartit {
    private int idGrupPartit;
    private String nom;
    private Date dataAlta;
    private Date dataBaixa;

    public GrupPartit(int idGrupPartit, String nom, Date data_alta, Date data_baixa) {
        this.idGrupPartit = idGrupPartit;
        this.nom = nom;
        this.dataAlta = data_alta;
        this.dataBaixa = data_baixa;
    }

    public int getIdGrupPartit() {
        return idGrupPartit;
    }

    public void setIdGrupPartit(int idGrupPartit) {
        this.idGrupPartit = idGrupPartit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

