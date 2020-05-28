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
public class Reserva {
    private int idReserva;
    private int idUsuari;
    private int idHoraExamen;

    public Reserva(int idReserva, int idUsuari, int idHoraExamen) {
        this.idReserva = idReserva;
        this.idUsuari = idUsuari;
        this.idHoraExamen = idHoraExamen;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public int getIdHoraExamen() {
        return idHoraExamen;
    }

    public void setIdHoraExamen(int idHoraExamen) {
        this.idHoraExamen = idHoraExamen;
    }
    
}
