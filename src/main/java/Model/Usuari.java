/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ferna
 */
public class Usuari {
    private int idUsuari;
    private String nom;
    private String cognoms;
    private String dni;
    private String adreca;
    private String correu;
    private String telefon;
    private String password;
    private String tipus_usuari;
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

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipus_usuari() {
        return tipus_usuari;
    }

    public void setTipus_usuari(String tipus_usuari) {
        this.tipus_usuari = tipus_usuari;
    }

    public String getLlista_examens() {
        return llista_examens;
    }

    public void setLlista_examens(String llista_examens) {
        this.llista_examens = llista_examens;
    }
    
    
}
