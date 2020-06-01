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
public class Examen {
    /** Identificador de un examen [int] */
    private int id_examen;
    /** Identificador del usuari que fa aquest examen [int]*/
    private int id_usuari;
    /** Identificador de la certificacio de la que és fa l'examen [int]*/
    private int id_certificacio;
    /** Determina si s'ha pagat la quota del examen [boolean]*/
    private boolean pagat;
    /** Data a la que és solicita un examem [Date]*/
    private Date data_solicitud;
    /** Data a la que s'efectua el pagament [Date]*/
    private Date data_pagament;
    /** codi al que se l'ha assignat [String]*/
    private String codi_id;
    /** estat del examen (No evaluat/Aprovat/Suspés)[String]*/
    private String estat;

    public Examen(int id_examen, int id_usuari, int id_certificacio, boolean pagat, Date data_solicitud, Date data_pagament, String codi_id, String estat) {
        this.id_examen = id_examen;
        this.id_usuari = id_usuari;
        this.id_certificacio = id_certificacio;
        this.pagat = pagat;
        this.data_solicitud = data_solicitud;
        this.data_pagament = data_pagament;
        this.codi_id = codi_id;
        this.estat = estat;
    }
    /**
     * Retorna el id del examen
     * @return int
     */
    public int getId_examen() {
        return id_examen;
    }
    /**
     * Retorna el id de l'usuari que realitza l'examen
     * @return int
     */
    public int getId_usuari() {
        return id_usuari;
    }
    /**
     * Modifica el id de l'usuari que realitza l'examen
     * @param id_usuari 
     */
    public void setId_usuari(int id_usuari) {
        this.id_usuari = id_usuari;
    }
    /**
     * Retorna el id de la certificació cursada
     * @return int
     */
    public int getId_certificacio() {
        return id_certificacio;
    }
    /**
     * Modifica el id de la certificació cursada
     * @param id_certificacio 
     */
    public void setId_certificacio(int id_certificacio) {
        this.id_certificacio = id_certificacio;
    }
    /**
     * Retorna si s'ha pagat la quota
     * @return boolean
     */
    public boolean isPagat() {
        return pagat;
    }
    /**
     * Modifica si s'ha pagat la quota
     * @param pagat 
     */
    public void setPagat(boolean pagat) {
        this.pagat = pagat;
    }
    /**
     * Retorna la data de solicitud de un examen
     * @return Date
     */
    public Date getData_solicitud() {
        return data_solicitud;
    }
    /**
     * Modifica la data de solicitud de un examen
     * @param data_solicitud 
     */
    public void setData_solicitud(Date data_solicitud) {
        this.data_solicitud = data_solicitud;
    }
    /**
     * Retorna la data de pagament de un examen
     * @return Date
     */
    public Date getData_pagament() {
        return data_pagament;
    }
    /**
     * Modifica la data de pagament de un examen
     * @param data_pagament 
     */
    public void setData_pagament(Date data_pagament) {
        this.data_pagament = data_pagament;
    }
    /**
     * Retorna el codi de examen utilitzat
     * @return String
     */
    public String getCodi_id() {
        return codi_id;
    }
    /**
     * Modifica el codi de examen utilitzat
     * @param codi_id 
     */
    public void setCodi_id(String codi_id) {
        this.codi_id = codi_id;
    }
    /**
     * Retorna el estat del examen
     * @return String No evaluat/Aprovat/Suspés
     */
    public String getEstat() {
        return estat;
    }
    /**
     * Modifica el estat del examen
     * @param estat 
     */
    public void setEstat(String estat) {
        this.estat = estat;
    }
    
    
}
