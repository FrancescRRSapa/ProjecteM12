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
public class Configuracio {
    private int codisMin;
    private int alumnesAula;
    private String direccioCorreu;
    private String contrasenyaCorreu;
    private String correuEnviaCodis;
    private String correuEnviaAlertaCodis;

    public Configuracio(int codisMin, int alumnesAula, String direccioCorreu, String contrasenyaCorreu, String correuEnviaCodis, String correuEnviaAlertaCodis) {
        this.codisMin = codisMin;
        this.alumnesAula = alumnesAula;
        this.direccioCorreu = direccioCorreu;
        this.contrasenyaCorreu = contrasenyaCorreu;
        this.correuEnviaCodis = correuEnviaCodis;
        this.correuEnviaAlertaCodis = correuEnviaAlertaCodis;
    }

    public int getCodisMin() {
        return codisMin;
    }

    public void setCodisMin(int codisMin) {
        this.codisMin = codisMin;
    }

    public int getAlumnesAula() {
        return alumnesAula;
    }

    public void setAlumnesAula(int alumnesAula) {
        this.alumnesAula = alumnesAula;
    }

    public String getDireccioCorreu() {
        return direccioCorreu;
    }

    public void setDireccioCorreu(String direccioCorreu) {
        this.direccioCorreu = direccioCorreu;
    }

    public String getContrasenyaCorreu() {
        return contrasenyaCorreu;
    }

    public void setContrasenyaCorreu(String contrasenyaCorreu) {
        this.contrasenyaCorreu = contrasenyaCorreu;
    }

    public String getCorreuEnviaCodis() {
        return correuEnviaCodis;
    }

    public void setCorreuEnviaCodis(String correuEnviaCodis) {
        this.correuEnviaCodis = correuEnviaCodis;
    }

    public String getCorreuEnviaAlertaCodis() {
        return correuEnviaAlertaCodis;
    }

    public void setCorreuEnviaAlertaCodis(String correuEnviaAlertaCodis) {
        this.correuEnviaAlertaCodis = correuEnviaAlertaCodis;
    }
    
}
