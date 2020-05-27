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
public class Concepte {
    private int idConcepte;
    private String nom;
    private Date dataAlta;
    private Date dataBaixa;

    public Concepte(int idConcepte, String nom, Date dataAlta, Date dataBaixa) {
        this.idConcepte = idConcepte;
        this.nom = nom;
        this.dataAlta = dataAlta;
        this.dataBaixa = dataBaixa;
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
