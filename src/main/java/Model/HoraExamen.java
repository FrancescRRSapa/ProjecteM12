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
public class HoraExamen {
    /** identificador de una Hora Examen [int]*/
    private int idHoraExamen;
    /** dia al que és realitza l'Examen [Date]*/
    private Date diaSetmana;
    /** hora al que és realitza l'Examan [String]*/
    private String hora;
    /** MTA/MOS [String]*/
    private String tipus;

    public HoraExamen(int idHoraExamen, Date diaSetmana, String hora, String tipus) {
        this.idHoraExamen = idHoraExamen;
        this.diaSetmana = diaSetmana;
        this.hora = hora;
        this.tipus = tipus;
    }
    /**
     * Retorna el identificador de HoraExamen
     * @return int
     */
    public int getIdHoraExamen() {
        return idHoraExamen;
    }
    /**
     * Retorna la data al que és realitza l'examen
     * @return Date
     */
    public Date getDiaSetmana() {
        return diaSetmana;
    }
    /**
     * Modifica la data al que és realitza l'examen
     * @param diaSetmana 
     */
    public void setDiaSetmana(Date diaSetmana) {
        this.diaSetmana = diaSetmana;
    }
    /**
     * Retorna l'hora a la qual és realitza l'examen
     * @return StringRetorna l'hora a la qual és realitza l'examen
     */
    public String getHora() {
        return hora;
    }
    /**
     * Modifica l'hora a la qual és realitza l'examen
     * @param hora 
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    /**
     * Retorna el tipus d'examen
     * @return String MTA/MOS
     */
    public String getTipus() {
        return tipus;
    }
    /**
     * Modifica el tipus d'examen
     * @param tipus
     */
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    
    
}
