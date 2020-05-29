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
public class Examen {
    private int id_examen;
    private int id_usuari;
    private int id_certificacio;
    private boolean pagat;
    private Date data_solicitud;
    private Date data_pagament;
    private int codi_id;
    private String estat;

    public Examen(int id_examen, int id_usuari, int id_certificacio, boolean pagat, Date data_solicitud, Date data_pagament, int codi_id, String estat) {
        this.id_examen = id_examen;
        this.id_usuari = id_usuari;
        this.id_certificacio = id_certificacio;
        this.pagat = pagat;
        this.data_solicitud = data_solicitud;
        this.data_pagament = data_pagament;
        this.codi_id = codi_id;
        this.estat = estat;
    }

    public int getId_examen() {
        return id_examen;
    }

    public void setId_examen(int id_examen) {
        this.id_examen = id_examen;
    }

    public int getId_usuari() {
        return id_usuari;
    }

    public void setId_usuari(int id_usuari) {
        this.id_usuari = id_usuari;
    }

    public int getId_certificacio() {
        return id_certificacio;
    }

    public void setId_certificacio(int id_certificacio) {
        this.id_certificacio = id_certificacio;
    }

    public boolean isPagat() {
        return pagat;
    }

    public void setPagat(boolean pagat) {
        this.pagat = pagat;
    }

    public Date getData_solicitud() {
        return data_solicitud;
    }

    public void setData_solicitud(Date data_solicitud) {
        this.data_solicitud = data_solicitud;
    }

    public Date getData_pagament() {
        return data_pagament;
    }

    public void setData_pagament(Date data_pagament) {
        this.data_pagament = data_pagament;
    }

    public int getCodi_id() {
        return codi_id;
    }

    public void setCodi_id(int codi_id) {
        this.codi_id = codi_id;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
    
    
}
