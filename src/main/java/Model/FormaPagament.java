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
public class FormaPagament {
    private String formaPagament;
    private Date dataAlta;
    private Date dataBaixa;

    public FormaPagament(String formaPagament, Date dataAlta, Date dataBaixa) {
        this.formaPagament = formaPagament;
        this.dataAlta = dataAlta;
        this.dataBaixa = dataBaixa;
    }

    public String getFormaPagament() {
        return formaPagament;
    }

    public void setFormaPagament(String formaPagament) {
        this.formaPagament = formaPagament;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }
    
    
}
