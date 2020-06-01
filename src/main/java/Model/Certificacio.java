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
public class Certificacio {
    //Parametres
    /** Identificacor de Certificacio [int] */
    private int idCertificacio;
    /** Nom de la Certificacio [String] */
    private String nom;
    /** Descripcio de la Certificacio (eines que utilitza...) [String] */
    private String descripcio;
    /** Data a la que és va publicar la certificacío [Date] */
    private Date dataPublicacio;
    /** Nivell al que és recomana fer una Certificació [String] */
    private String nivellAlumneRecomanat;
    /** Llista de tarifes que incorpora la certificacio [String[]] */
    private String[] tarifes;

    public Certificacio(int idCertificacio, String nom, String descripcio, Date dataPublicacio, String nivellAlumneRecomanat, String tarifes) {        
        this.idCertificacio = idCertificacio;
        this.nom = nom;
        this.descripcio = descripcio;
        this.dataPublicacio = dataPublicacio;
        this.nivellAlumneRecomanat = nivellAlumneRecomanat;
        this.tarifes = tarifes.split(";");
    }
    //mètodes
    /**
     * Retorna un id de una Certificacio
     * @return int 
     */
    public int getIdCertificacio() {
        return idCertificacio;
    }
    /**
     * Retorna el nom de una certificació
     * @return String
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifica el nom de una Certificació
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retorna la Descripció de una Certificació
     * @return String
     */
    public String getDescripcio() {
        return descripcio;
    }
    /**
     * Modifica la descripció de una Certificació
     * @param descripcio
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    /**
     * Retorna la Data a la que és va publicar la Certificació
     * @return Date
     */
    public Date getDataPublicacio() {
        return dataPublicacio;
    }
    /**
     * Modifica la Data a la que és va publicar la Certificació
     * @param dataPublicacio 
     */
    public void setDataPublicacio(Date dataPublicacio) {
        this.dataPublicacio = dataPublicacio;
    }
    /**
     * Retorna el nivell al que és recomana fer la Certificació
     * @return String
     */
    public String getNivellAlumneRecomanat() {
        return nivellAlumneRecomanat;
    }
    /**
     * Modifica el nivell al que és recomana fer la Certificació
     * @param nivellAlumneRecomanat 
     */
    public void setNivellAlumneRecomanat(String nivellAlumneRecomanat) {
        this.nivellAlumneRecomanat = nivellAlumneRecomanat;
    }
    /**
     * Retorna un llistat de Tarifes que és poden aplicar a la Certificació
     * @return String[]
     */
    public String[] getTarifes() {
        return tarifes;
    }
    /**
     * Modifica un llistat de Tarifes que és poden aplicar a la Certificació
     * @param tarifes 
     */
    public void setTarifes(String[] tarifes) {
        this.tarifes = tarifes;
    }
    
}
