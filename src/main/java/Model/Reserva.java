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
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class Reserva {
    /** identificador de Reserva [int]*/
    private int idReserva;
    /** usuari que realitza la reserva [Usuari]*/
    private Usuari usuari; 
    /** dia i hora de la reserva [HoraExamen]*/
    private HoraExamen horaExamen;

    public Reserva(int idReserva, int idUsuari, int idHoraExamen) throws SQLException, ClassNotFoundException {
        this.idReserva = idReserva;
        this.usuari = UsuarisDAO.buscar(idUsuari);
        this.horaExamen = HoresExamensDAO.buscar(idHoraExamen);
    }
    /**
     * Retorna el identificador de la Reserva
     * @return int
     */
    public int getIdReserva() {
        return idReserva;
    }
    /**
     * Retorna el usuari que realitza la reserva
     * @return Usuari
     */
    public Usuari getUsuari() {
        return usuari;
    }
    /**
     * Modifica el Usuari que realitza la reserva
     * @param usuari 
     */
    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }
    /**
     * Retorna el dia y hora de la reserva
     * @return HoraExamen
     */
    public HoraExamen getHoraExamen() {
        return horaExamen;
    }
    /**
     * Modifica el dia y hora de la reserva
     * @param horaExamen 
     */
    public void setHoraExamen(HoraExamen horaExamen) {
        this.horaExamen = horaExamen;
    }
    
}
