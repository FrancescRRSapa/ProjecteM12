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
public class HoraExamen {
    private int idHoraExamen;
    private Date diaSetmana;
    private String hora;
    private String tipus;

    public HoraExamen(int idHoraExamen, Date diaSetmana, String hora, String tipus) {
        this.idHoraExamen = idHoraExamen;
        this.diaSetmana = diaSetmana;
        this.hora = hora;
        this.tipus = tipus;
    }

    public int getIdHoraExamen() {
        return idHoraExamen;
    }

    public void setIdHoraExamen(int idHoraExamen) {
        this.idHoraExamen = idHoraExamen;
    }

    public Date getDiaSetmana() {
        return diaSetmana;
    }

    public void setDiaSetmana(Date diaSetmana) {
        this.diaSetmana = diaSetmana;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    
    
}
