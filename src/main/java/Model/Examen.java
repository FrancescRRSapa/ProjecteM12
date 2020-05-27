/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;


/**
 *
 * @author ferna
 */
public class Examen {
    private int idUsuari;
    private int idExamen;
    private boolean pagat;
    private Date dataSolicitud;
    private Date dataPagament;
    private String codiUtilitzat;
    private String estat;

    public Examen(int idUsuari, int idExamen, boolean pagat, Date dataSolicitud, Date dataPagament, String codiUtilitzat, String estat) {
        this.idUsuari = idUsuari;
        this.idExamen = idExamen;
        this.pagat = pagat;
        this.dataSolicitud = dataSolicitud;
        this.dataPagament = dataPagament;
        this.codiUtilitzat = codiUtilitzat;
        this.estat = estat;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public boolean isPagat() {
        return pagat;
    }

    public void setPagat(boolean pagat) {
        this.pagat = pagat;
    }

    public Date getDataSolicitud() {
        return dataSolicitud;
    }

    public void setDataSolicitud(Date dataSolicitud) {
        this.dataSolicitud = dataSolicitud;
    }

    public Date getDataPagament() {
        return dataPagament;
    }

    public void setDataPagament(Date dataPagament) {
        this.dataPagament = dataPagament;
    }

    public String getCodiUtilitzat() {
        return codiUtilitzat;
    }

    public void setCodiUtilitzat(String codiUtilitzat) {
        this.codiUtilitzat = codiUtilitzat;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
    
}
