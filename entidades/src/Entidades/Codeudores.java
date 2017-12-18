/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dvid1
 */
@Entity
@Table(name = "codeudores", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "Codeudores.findAll", query = "SELECT c FROM Codeudores c")
    , @NamedQuery(name = "Codeudores.findByIdCodeudor", query = "SELECT c FROM Codeudores c WHERE c.codeudoresPK.idCodeudor = :idCodeudor")
    , @NamedQuery(name = "Codeudores.findByDui", query = "SELECT c FROM Codeudores c WHERE c.codeudoresPK.dui = :dui")})
public class Codeudores implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CodeudoresPK codeudoresPK;
    @JoinColumn(name = "dui_codeudor", referencedColumnName = "dui", nullable = false)
    @ManyToOne(optional = false)
    private DatosPersonales duiCodeudor;
    @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DatosPersonales datosPersonales;

    public Codeudores() {
    }

    public Codeudores(CodeudoresPK codeudoresPK) {
        this.codeudoresPK = codeudoresPK;
    }

    public Codeudores(int idCodeudor, String dui) {
        this.codeudoresPK = new CodeudoresPK(idCodeudor, dui);
    }

    public CodeudoresPK getCodeudoresPK() {
        return codeudoresPK;
    }

    public void setCodeudoresPK(CodeudoresPK codeudoresPK) {
        this.codeudoresPK = codeudoresPK;
    }

    public DatosPersonales getDuiCodeudor() {
        return duiCodeudor;
    }

    public void setDuiCodeudor(DatosPersonales duiCodeudor) {
        this.duiCodeudor = duiCodeudor;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeudoresPK != null ? codeudoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codeudores)) {
            return false;
        }
        Codeudores other = (Codeudores) object;
        if ((this.codeudoresPK == null && other.codeudoresPK != null) || (this.codeudoresPK != null && !this.codeudoresPK.equals(other.codeudoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Codeudores[ codeudoresPK=" + codeudoresPK + " ]";
    }
    
}
