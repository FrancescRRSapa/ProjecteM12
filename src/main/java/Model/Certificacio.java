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
public class Certificacio {
    private int idCertificacio;
    private String nom;
    private String descripcio;
    private Date dataPublicacio;
    private String nivellAlumneRecomanat;
    private String[] tarifes;

    public Certificacio(int idCertificacio, String nom, String descripcio, Date dataPublicacio, String nivellAlumneRecomanat, String tarifes) {
        this.idCertificacio = idCertificacio;
        this.nom = nom;
        this.descripcio = descripcio;
        this.dataPublicacio = dataPublicacio;
        this.nivellAlumneRecomanat = nivellAlumneRecomanat;
        this.tarifes = tarifes.split(";");
    }

    public int getIdCertificacio() {
        return idCertificacio;
    }

    public void setIdCertificacio(int idCertificacio) {
        this.idCertificacio = idCertificacio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Date getDataPublicacio() {
        return dataPublicacio;
    }

    public void setDataPublicacio(Date dataPublicacio) {
        this.dataPublicacio = dataPublicacio;
    }

    public String getNivellAlumneRecomanat() {
        return nivellAlumneRecomanat;
    }

    public void setNivellAlumneRecomanat(String nivellAlumneRecomanat) {
        this.nivellAlumneRecomanat = nivellAlumneRecomanat;
    }

    public String[] getTarifes() {
        return tarifes;
    }

    public void setTarifes(String[] tarifes) {
        this.tarifes = tarifes;
    }
    
}
