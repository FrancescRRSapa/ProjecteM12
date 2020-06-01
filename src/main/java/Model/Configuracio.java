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
public class Configuracio {
    /** Número de codis als que hem de donar avís al administrador [int] */
    private int codisMin;
    /** Número de alumnes que poden apuntarse a un examen com a máxim [int]*/
    private int alumnesAula;
    /** direccio de correu a la que tractar com a administrador, gestió mail [String] */
    private String direccioCorreu;
    /** contrasenya del correu per els mails [String] */
    private String contrasenyaCorreu;
    /** correu que s'utilitza per enviar codis */
    private String correuEnviaCodis;
    /** correu d'alerta per demanar codis */
    private String correuEnviaAlertaCodis;

    public Configuracio(int codisMin, int alumnesAula, String direccioCorreu, String contrasenyaCorreu, String correuEnviaCodis, String correuEnviaAlertaCodis) {
        this.codisMin = codisMin;
        this.alumnesAula = alumnesAula;
        this.direccioCorreu = direccioCorreu;
        this.contrasenyaCorreu = contrasenyaCorreu;
        this.correuEnviaCodis = correuEnviaCodis;
        this.correuEnviaAlertaCodis = correuEnviaAlertaCodis;
    }
    /**
     * Retorna el número de codis als que avisar per demanar més
     * @return int
     */
    public int getCodisMin() {
        return codisMin;
    }
    /**
     * Modifica el número de codis als que avisar per demanar més
     * @param codisMin 
     */
    public void setCodisMin(int codisMin) {
        this.codisMin = codisMin;
    }
    /**
     * Retorna el número d'alumnes que poden cursar un exámen
     * @return int
     */
    public int getAlumnesAula() {
        return alumnesAula;
    }
    /**
     * Modifica el número d'alumnes que poden cursar un exámen
     * @param alumnesAula 
     */
    public void setAlumnesAula(int alumnesAula) {
        this.alumnesAula = alumnesAula;
    }
    /**
     * Retorna el correu que s'utilitza per enviar mails
     * @return String
     */
    public String getDireccioCorreu() {
        return direccioCorreu;
    }
    /**
     * Modifica el correu que s'utilitza per enviar mails
     * @param direccioCorreu 
     */
    public void setDireccioCorreu(String direccioCorreu) {
        this.direccioCorreu = direccioCorreu;
    }
    /**
     * Retorna la contrasenya del mail direccioCorreu
     * @return String
     */
    public String getContrasenyaCorreu() {
        return contrasenyaCorreu;
    }
    /**
     * Modifica la contrasenya del mail direccioCorreu
     * @param contrasenyaCorreu 
     */
    public void setContrasenyaCorreu(String contrasenyaCorreu) {
        this.contrasenyaCorreu = contrasenyaCorreu;
    }
    /**
     * Retorna el mail per enviar codis
     * @return String
     */
    public String getCorreuEnviaCodis() {
        return correuEnviaCodis;
    }
    /**
     * Modifica el mail per enviar codis
     * @param correuEnviaCodis 
     */
    public void setCorreuEnviaCodis(String correuEnviaCodis) {
        this.correuEnviaCodis = correuEnviaCodis;
    }
    /**
     * Retorna el mail d'alerta per demanar codis
     * @return String
     */
    public String getCorreuEnviaAlertaCodis() {
        return correuEnviaAlertaCodis;
    }
    /**
     * Modifica el mail d'alerta per demanar codis
     * @param correuEnviaAlertaCodis 
     */
    public void setCorreuEnviaAlertaCodis(String correuEnviaAlertaCodis) {
        this.correuEnviaAlertaCodis = correuEnviaAlertaCodis;
    }
    
}
