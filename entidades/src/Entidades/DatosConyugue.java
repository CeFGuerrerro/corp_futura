/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author DFUENTES
 */
@Entity
@Table(name = "datos_conyugue", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "DatosConyugue.findAll", query = "SELECT d FROM DatosConyugue d")
    , @NamedQuery(name = "DatosConyugue.findByDui", query = "SELECT d FROM DatosConyugue d WHERE d.dui = :dui")
    , @NamedQuery(name = "DatosConyugue.findByNombre", query = "SELECT d FROM DatosConyugue d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DatosConyugue.findByDireccion", query = "SELECT d FROM DatosConyugue d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "DatosConyugue.findByLugarTrabajo", query = "SELECT d FROM DatosConyugue d WHERE d.lugarTrabajo = :lugarTrabajo")
    , @NamedQuery(name = "DatosConyugue.findByCargo", query = "SELECT d FROM DatosConyugue d WHERE d.cargo = :cargo")
    , @NamedQuery(name = "DatosConyugue.findByTelefono", query = "SELECT d FROM DatosConyugue d WHERE d.telefono = :telefono")})
public class DatosConyugue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dui", nullable = false, length = 10)
    private String dui;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion", nullable = false, length = 500)
    private String direccion;
    @Column(name = "lugar_trabajo", length = 300)
    private String lugarTrabajo;
    @Column(name = "cargo", length = 200)
    private String cargo;
    @Column(name = "telefono", length = 10)
    private String telefono;
    @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DatosPersonales datosPersonales;

    public DatosConyugue() {
    }

    public DatosConyugue(String dui) {
        this.dui = dui;
    }

    public DatosConyugue(String dui, String nombre, String direccion) {
        this.dui = dui;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
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

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
        hash += (dui != null ? dui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosConyugue)) {
            return false;
        }
        DatosConyugue other = (DatosConyugue) object;
        if ((this.dui == null && other.dui != null) || (this.dui != null && !this.dui.equals(other.dui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DatosConyugue[ dui=" + dui + " ]";
    }
    
}
