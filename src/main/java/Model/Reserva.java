/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.HoresExamensDAO;
import DAO.UsuarisDAO;
import java.sql.SQLException;

/**
 *
 * @author ferna
 */
public class Reserva {
    private int idReserva;
    private Usuari usuari;
    private HoraExamen horaExamen;

    public Reserva(int idReserva, int idUsuari, int idHoraExamen) throws SQLException, ClassNotFoundException {
        this.idReserva = idReserva;
        this.usuari = UsuarisDAO.buscar(idUsuari);
        this.horaExamen = HoresExamensDAO.buscar(idHoraExamen);
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public HoraExamen getHoraExamen() {
        return horaExamen;
    }

    public void setHoraExamen(HoraExamen horaExamen) {
        this.horaExamen = horaExamen;
    }
    
}
