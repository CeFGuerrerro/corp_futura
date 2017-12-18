/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dvid1
 */
@Embeddable
public class EvaluacionCreditoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "dui", nullable = false, length = 10)
    private String dui;
    @Basic(optional = false)
    @Column(name = "id_solicitud_credito", nullable = false)
    private int idSolicitudCredito;

    public EvaluacionCreditoPK() {
    }

    public EvaluacionCreditoPK(String dui, int idSolicitudCredito) {
        this.dui = dui;
        this.idSolicitudCredito = idSolicitudCredito;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public int getIdSolicitudCredito() {
        return idSolicitudCredito;
    }

    public void setIdSolicitudCredito(int idSolicitudCredito) {
        this.idSolicitudCredito = idSolicitudCredito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dui != null ? dui.hashCode() : 0);
        hash += (int) idSolicitudCredito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionCreditoPK)) {
            return false;
        }
        EvaluacionCreditoPK other = (EvaluacionCreditoPK) object;
        if ((this.dui == null && other.dui != null) || (this.dui != null && !this.dui.equals(other.dui))) {
            return false;
        }
        if (this.idSolicitudCredito != other.idSolicitudCredito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EvaluacionCreditoPK[ dui=" + dui + ", idSolicitudCredito=" + idSolicitudCredito + " ]";
    }
    
}
