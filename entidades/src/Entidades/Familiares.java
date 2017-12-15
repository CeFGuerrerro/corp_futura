/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DFUENTES
 */
@Entity
@Table(name = "familiares", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "Familiares.findAll", query = "SELECT f FROM Familiares f")
    , @NamedQuery(name = "Familiares.findByDui", query = "SELECT f FROM Familiares f WHERE f.familiaresPK.dui = :dui")
    , @NamedQuery(name = "Familiares.findById", query = "SELECT f FROM Familiares f WHERE f.familiaresPK.id = :id")
    , @NamedQuery(name = "Familiares.findByParentesco", query = "SELECT f FROM Familiares f WHERE f.parentesco = :parentesco")
    , @NamedQuery(name = "Familiares.findByNombre", query = "SELECT f FROM Familiares f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Familiares.findByLugarTrabajo", query = "SELECT f FROM Familiares f WHERE f.lugarTrabajo = :lugarTrabajo")
    , @NamedQuery(name = "Familiares.findByTelefono", query = "SELECT f FROM Familiares f WHERE f.telefono = :telefono")})
public class Familiares implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FamiliaresPK familiaresPK;
    @Basic(optional = false)
    @Column(name = "parentesco", nullable = false, length = 50)
    private String parentesco;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Column(name = "lugar_trabajo", length = 300)
    private String lugarTrabajo;
    @Column(name = "telefono", length = 10)
    private String telefono;
    @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DatosPersonales datosPersonales;

    public Familiares() {
    }

    public Familiares(FamiliaresPK familiaresPK) {
        this.familiaresPK = familiaresPK;
    }

    public Familiares(FamiliaresPK familiaresPK, String parentesco, String nombre) {
        this.familiaresPK = familiaresPK;
        this.parentesco = parentesco;
        this.nombre = nombre;
    }

    public Familiares(String dui, int id) {
        this.familiaresPK = new FamiliaresPK(dui, id);
    }

    public FamiliaresPK getFamiliaresPK() {
        return familiaresPK;
    }

    public void setFamiliaresPK(FamiliaresPK familiaresPK) {
        this.familiaresPK = familiaresPK;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (familiaresPK != null ? familiaresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familiares)) {
            return false;
        }
        Familiares other = (Familiares) object;
        if ((this.familiaresPK == null && other.familiaresPK != null) || (this.familiaresPK != null && !this.familiaresPK.equals(other.familiaresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Familiares[ familiaresPK=" + familiaresPK + " ]";
    }
    
}
