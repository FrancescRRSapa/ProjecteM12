/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class Usuari {
    /** identificador de l'Usuari [int] */
    private int idUsuari;
    /** nom de l'Usuari [String] */
    private String nom;
    /** cognoms de l'Usuari [String] */
    private String cognoms;
    /** dni de l'Usuari [String] */
    private String dni;
    /** adreça de l'Usuari [String] */
    private String adreca;
    /** correu de l'Usuari [String] */
    private String correu;
    /** telefon de contacte de l'Usuari [String] */
    private String telefon;
    /** password de l'Usuari [String] */
    private String password;
    /** rol de l'Usuari [String] */
    private String tipus_usuari;
    /** llista d'examens que a realitzat un usuari */
    private String llista_examens;

    public Usuari(int idUsuari, String nom, String cognoms, String dni, String adreca, String correu, String telefon, String password, String tipus_usuari, String llista_examens) {
        this.idUsuari = idUsuari;
        this.nom = nom;
        this.cognoms = cognoms;
        this.dni = dni;
        this.adreca = adreca;
        this.correu = correu;
        this.telefon = telefon;
        this.password = password;
        this.tipus_usuari = tipus_usuari;
        this.llista_examens = llista_examens;
    }
    /**
     * Retorna el identificador de un Usuari
     * @return int
     */
    public int getIdUsuari() {
        return idUsuari;
    }
    /**
     * Retorna el nom de l'Usuari
     * @return String
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifica el nom de l'Usuari
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retorna els cognoms de l'Usuari
     * @return String
     */
    public String getCognoms() {
        return cognoms;
    }
    /**
     * Modifica els cognoms de l'Usuari
     * @param cognoms 
     */
    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }
    /**
     * Retorna el document d'identitat de l'Usuari
     * @return String
     */
    public String getDni() {
        return dni;
    }
    /**
     * Retorna l'adreça d'un Usuari
     * @return String
     */
    public String getAdreca() {
        return adreca;
    }
    /**
     * Modifica l'adreça d'un Usuari
     * @param adreca 
     */
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }
    /**
     * Retorna el correu electrònic d'un Usauri
     * @return String
     */
    public String getCorreu() {
        return correu;
    }
    /**
     * Modifica el correu electrònic d'un Usauri
     * @param correu 
     */
    public void setCorreu(String correu) {
        this.correu = correu;
    }
    /**
     * Retorna el telefon d'un Usuari
     * @return String
     */
    public String getTelefon() {
        return telefon;
    }
    /**
     * Modifica el telefon d'un Usuari
     * @param telefon 
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    /**
     * Retorna la contrasenya d'un Usuari
     * @return String
     */
    public String getPassword() {
        return password;
    }
    /**
     * Modifica la contrasenya d'un Usuari
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Retorna el rol del Usuari
     * @return String
     */
    public String getTipus_usuari() {
        return tipus_usuari;
    }
    /**
     * Modifica el rol del Usuari
     * @param tipus_usuari 
     */
    public void setTipus_usuari(String tipus_usuari) {
        this.tipus_usuari = tipus_usuari;
    }
    /**
     * Retorna un llistat dels examens realitzats per l'Usuari
     * @return String
     */
    public String getLlista_examens() {
        return llista_examens;
    }
    /**
     *Modifica un llistat dels examens realitzats per l'Usuari
     * @param llista_examens 
     */
    public void setLlista_examens(String llista_examens) {
        this.llista_examens = llista_examens;
    }
    
    
}
