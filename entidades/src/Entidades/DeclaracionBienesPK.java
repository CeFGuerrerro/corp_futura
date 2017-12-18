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
public class DeclaracionBienesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_bien", nullable = false)
    private int idBien;
    @Basic(optional = false)
    @Column(name = "dui", nullable = false, length = 10)
    private String dui;

    public DeclaracionBienesPK() {
    }

    public DeclaracionBienesPK(int idBien, String dui) {
        this.idBien = idBien;
        this.dui = dui;
    }

    public int getIdBien() {
        return idBien;
    }

    public void setIdBien(int idBien) {
        this.idBien = idBien;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idBien;
        hash += (dui != null ? dui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeclaracionBienesPK)) {
            return false;
        }
        DeclaracionBienesPK other = (DeclaracionBienesPK) object;
        if (this.idBien != other.idBien) {
            return false;
        }
        if ((this.dui == null && other.dui != null) || (this.dui != null && !this.dui.equals(other.dui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DeclaracionBienesPK[ idBien=" + idBien + ", dui=" + dui + " ]";
    }
    
}
