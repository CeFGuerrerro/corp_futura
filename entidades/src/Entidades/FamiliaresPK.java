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
public class FamiliaresPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "dui", nullable = false, length = 10)
    private String dui;
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private int id;

    public FamiliaresPK() {
    }

    public FamiliaresPK(String dui, int id) {
        this.dui = dui;
        this.id = id;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dui != null ? dui.hashCode() : 0);
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamiliaresPK)) {
            return false;
        }
        FamiliaresPK other = (FamiliaresPK) object;
        if ((this.dui == null && other.dui != null) || (this.dui != null && !this.dui.equals(other.dui))) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.FamiliaresPK[ dui=" + dui + ", id=" + id + " ]";
    }
    
}
