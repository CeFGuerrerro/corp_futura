/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
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
 * @author dvid1
 */
@Entity
@Table(name = "declaracion_bienes", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "DeclaracionBienes.findAll", query = "SELECT d FROM DeclaracionBienes d")
    , @NamedQuery(name = "DeclaracionBienes.findByIdBien", query = "SELECT d FROM DeclaracionBienes d WHERE d.declaracionBienesPK.idBien = :idBien")
    , @NamedQuery(name = "DeclaracionBienes.findByDui", query = "SELECT d FROM DeclaracionBienes d WHERE d.declaracionBienesPK.dui = :dui")
    , @NamedQuery(name = "DeclaracionBienes.findByCantidad", query = "SELECT d FROM DeclaracionBienes d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DeclaracionBienes.findByNombre", query = "SELECT d FROM DeclaracionBienes d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DeclaracionBienes.findByDescripcion", query = "SELECT d FROM DeclaracionBienes d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "DeclaracionBienes.findByUbicacion", query = "SELECT d FROM DeclaracionBienes d WHERE d.ubicacion = :ubicacion")
    , @NamedQuery(name = "DeclaracionBienes.findByValuo", query = "SELECT d FROM DeclaracionBienes d WHERE d.valuo = :valuo")
    , @NamedQuery(name = "DeclaracionBienes.findByTotalGarantia", query = "SELECT d FROM DeclaracionBienes d WHERE d.totalGarantia = :totalGarantia")})
public class DeclaracionBienes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeclaracionBienesPK declaracionBienesPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "nombre", length = 300)
    private String nombre;
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    @Column(name = "ubicacion", length = 200)
    private String ubicacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valuo", precision = 22)
    private Double valuo;
    @Column(name = "total_garantia", precision = 22)
    private Double totalGarantia;
    @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DatosPersonales datosPersonales;

    public DeclaracionBienes() {
    }

    public DeclaracionBienes(DeclaracionBienesPK declaracionBienesPK) {
        this.declaracionBienesPK = declaracionBienesPK;
    }

    public DeclaracionBienes(int idBien, String dui) {
        this.declaracionBienesPK = new DeclaracionBienesPK(idBien, dui);
    }

    public DeclaracionBienesPK getDeclaracionBienesPK() {
        return declaracionBienesPK;
    }

    public void setDeclaracionBienesPK(DeclaracionBienesPK declaracionBienesPK) {
        this.declaracionBienesPK = declaracionBienesPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getValuo() {
        return valuo;
    }

    public void setValuo(Double valuo) {
        this.valuo = valuo;
    }

    public Double getTotalGarantia() {
        return totalGarantia;
    }

    public void setTotalGarantia(Double totalGarantia) {
        this.totalGarantia = totalGarantia;
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
        hash += (declaracionBienesPK != null ? declaracionBienesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeclaracionBienes)) {
            return false;
        }
        DeclaracionBienes other = (DeclaracionBienes) object;
        if ((this.declaracionBienesPK == null && other.declaracionBienesPK != null) || (this.declaracionBienesPK != null && !this.declaracionBienesPK.equals(other.declaracionBienesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DeclaracionBienes[ declaracionBienesPK=" + declaracionBienesPK + " ]";
    }
    
}
