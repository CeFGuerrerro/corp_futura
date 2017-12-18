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
 * @author dvid1
 */
@Entity
@Table(name = "informacion_negocio", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "InformacionNegocio.findAll", query = "SELECT i FROM InformacionNegocio i")
    , @NamedQuery(name = "InformacionNegocio.findByDui", query = "SELECT i FROM InformacionNegocio i WHERE i.dui = :dui")
    , @NamedQuery(name = "InformacionNegocio.findByNombre", query = "SELECT i FROM InformacionNegocio i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "InformacionNegocio.findByGiro", query = "SELECT i FROM InformacionNegocio i WHERE i.giro = :giro")
    , @NamedQuery(name = "InformacionNegocio.findByDireccion", query = "SELECT i FROM InformacionNegocio i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "InformacionNegocio.findByComoLlegar", query = "SELECT i FROM InformacionNegocio i WHERE i.comoLlegar = :comoLlegar")
    , @NamedQuery(name = "InformacionNegocio.findByTiempoFuncion", query = "SELECT i FROM InformacionNegocio i WHERE i.tiempoFuncion = :tiempoFuncion")
    , @NamedQuery(name = "InformacionNegocio.findByTelefono", query = "SELECT i FROM InformacionNegocio i WHERE i.telefono = :telefono")
    , @NamedQuery(name = "InformacionNegocio.findByHorarios", query = "SELECT i FROM InformacionNegocio i WHERE i.horarios = :horarios")
    , @NamedQuery(name = "InformacionNegocio.findByRutasVenta", query = "SELECT i FROM InformacionNegocio i WHERE i.rutasVenta = :rutasVenta")
    , @NamedQuery(name = "InformacionNegocio.findByUtilidadMensual", query = "SELECT i FROM InformacionNegocio i WHERE i.utilidadMensual = :utilidadMensual")
    , @NamedQuery(name = "InformacionNegocio.findByNumeroEmpleados", query = "SELECT i FROM InformacionNegocio i WHERE i.numeroEmpleados = :numeroEmpleados")
    , @NamedQuery(name = "InformacionNegocio.findByTipoLocal", query = "SELECT i FROM InformacionNegocio i WHERE i.tipoLocal = :tipoLocal")})
public class InformacionNegocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dui", nullable = false, length = 10)
    private String dui;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "giro", nullable = false, length = 200)
    private String giro;
    @Basic(optional = false)
    @Column(name = "direccion", nullable = false, length = 500)
    private String direccion;
    @Column(name = "como_llegar", length = 1000)
    private String comoLlegar;
    @Basic(optional = false)
    @Column(name = "tiempo_funcion", nullable = false, length = 50)
    private String tiempoFuncion;
    @Column(name = "telefono", length = 10)
    private String telefono;
    @Column(name = "horarios", length = 500)
    private String horarios;
    @Column(name = "rutas_venta", length = 500)
    private String rutasVenta;
    @Basic(optional = false)
    @Column(name = "utilidad_mensual", nullable = false, length = 10)
    private String utilidadMensual;
    @Column(name = "numero_empleados", length = 10)
    private String numeroEmpleados;
    @Basic(optional = false)
    @Column(name = "tipo_local", nullable = false)
    private short tipoLocal;
    @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DatosPersonales datosPersonales;

    public InformacionNegocio() {
    }

    public InformacionNegocio(String dui) {
        this.dui = dui;
    }

    public InformacionNegocio(String dui, String nombre, String giro, String direccion, String tiempoFuncion, String utilidadMensual, short tipoLocal) {
        this.dui = dui;
        this.nombre = nombre;
        this.giro = giro;
        this.direccion = direccion;
        this.tiempoFuncion = tiempoFuncion;
        this.utilidadMensual = utilidadMensual;
        this.tipoLocal = tipoLocal;
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

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComoLlegar() {
        return comoLlegar;
    }

    public void setComoLlegar(String comoLlegar) {
        this.comoLlegar = comoLlegar;
    }

    public String getTiempoFuncion() {
        return tiempoFuncion;
    }

    public void setTiempoFuncion(String tiempoFuncion) {
        this.tiempoFuncion = tiempoFuncion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getRutasVenta() {
        return rutasVenta;
    }

    public void setRutasVenta(String rutasVenta) {
        this.rutasVenta = rutasVenta;
    }

    public String getUtilidadMensual() {
        return utilidadMensual;
    }

    public void setUtilidadMensual(String utilidadMensual) {
        this.utilidadMensual = utilidadMensual;
    }

    public String getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(String numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public short getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(short tipoLocal) {
        this.tipoLocal = tipoLocal;
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
        if (!(object instanceof InformacionNegocio)) {
            return false;
        }
        InformacionNegocio other = (InformacionNegocio) object;
        if ((this.dui == null && other.dui != null) || (this.dui != null && !this.dui.equals(other.dui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.InformacionNegocio[ dui=" + dui + " ]";
    }
    
}
