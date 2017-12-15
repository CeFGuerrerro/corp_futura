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
 * @author DFUENTES
 */
@Embeddable
public class CodeudoresPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_codeudor", nullable = false)
    private int idCodeudor;
    @Basic(optional = false)
    @Column(name = "dui", nullable = false, length = 10)
    private String dui;

    public CodeudoresPK() {
    }

    public CodeudoresPK(int idCodeudor, String dui) {
        this.idCodeudor = idCodeudor;
        this.dui = dui;
    }

    public int getIdCodeudor() {
        return idCodeudor;
    }

    public void setIdCodeudor(int idCodeudor) {
        this.idCodeudor = idCodeudor;
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
        hash += (int) idCodeudor;
        hash += (dui != null ? dui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodeudoresPK)) {
            return false;
        }
        CodeudoresPK other = (CodeudoresPK) object;
        if (this.idCodeudor != other.idCodeudor) {
            return false;
        }
        if ((this.dui == null && other.dui != null) || (this.dui != null && !this.dui.equals(other.dui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CodeudoresPK[ idCodeudor=" + idCodeudor + ", dui=" + dui + " ]";
    }
    
}
