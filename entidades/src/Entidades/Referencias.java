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
@Table(name = "referencias", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "Referencias.findAll", query = "SELECT r FROM Referencias r")
    , @NamedQuery(name = "Referencias.findByDui", query = "SELECT r FROM Referencias r WHERE r.referenciasPK.dui = :dui")
    , @NamedQuery(name = "Referencias.findById", query = "SELECT r FROM Referencias r WHERE r.referenciasPK.id = :id")
    , @NamedQuery(name = "Referencias.findByNombre", query = "SELECT r FROM Referencias r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Referencias.findByDireccion", query = "SELECT r FROM Referencias r WHERE r.direccion = :direccion")
    , @NamedQuery(name = "Referencias.findByEmpresa", query = "SELECT r FROM Referencias r WHERE r.empresa = :empresa")
    , @NamedQuery(name = "Referencias.findByParentesco", query = "SELECT r FROM Referencias r WHERE r.parentesco = :parentesco")
    , @NamedQuery(name = "Referencias.findByTelefono", query = "SELECT r FROM Referencias r WHERE r.telefono = :telefono")
    , @NamedQuery(name = "Referencias.findByTipoReferencia", query = "SELECT r FROM Referencias r WHERE r.tipoReferencia = :tipoReferencia")})
public class Referencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReferenciasPK referenciasPK;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Column(name = "direccion", length = 500)
    private String direccion;
    @Column(name = "empresa", length = 300)
    private String empresa;
    @Basic(optional = false)
    @Column(name = "parentesco", nullable = false, length = 50)
    private String parentesco;
    @Column(name = "telefono", length = 10)
    private String telefono;
    @Basic(optional = false)
    @Column(name = "tipo_referencia", nullable = false)
    private boolean tipoReferencia;
    @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DatosPersonales datosPersonales;

    public Referencias() {
    }

    public Referencias(ReferenciasPK referenciasPK) {
        this.referenciasPK = referenciasPK;
    }

    public Referencias(ReferenciasPK referenciasPK, String nombre, String parentesco, boolean tipoReferencia) {
        this.referenciasPK = referenciasPK;
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.tipoReferencia = tipoReferencia;
    }

    public Referencias(String dui, int id) {
        this.referenciasPK = new ReferenciasPK(dui, id);
    }

    public ReferenciasPK getReferenciasPK() {
        return referenciasPK;
    }

    public void setReferenciasPK(ReferenciasPK referenciasPK) {
        this.referenciasPK = referenciasPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean getTipoReferencia() {
        return tipoReferencia;
    }

    public void setTipoReferencia(boolean tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
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
        hash += (referenciasPK != null ? referenciasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referencias)) {
            return false;
        }
        Referencias other = (Referencias) object;
        if ((this.referenciasPK == null && other.referenciasPK != null) || (this.referenciasPK != null && !this.referenciasPK.equals(other.referenciasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Referencias[ referenciasPK=" + referenciasPK + " ]";
    }
    
}
