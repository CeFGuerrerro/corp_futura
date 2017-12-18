/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dvid1
 */
@Entity
@Table(name = "mora", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "Mora.findAll", query = "SELECT m FROM Mora m")
    , @NamedQuery(name = "Mora.findByIdMora", query = "SELECT m FROM Mora m WHERE m.idMora = :idMora")
    , @NamedQuery(name = "Mora.findByFechaInicio", query = "SELECT m FROM Mora m WHERE m.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Mora.findByMoraTotal", query = "SELECT m FROM Mora m WHERE m.moraTotal = :moraTotal")
    , @NamedQuery(name = "Mora.findByMoraCancelada", query = "SELECT m FROM Mora m WHERE m.moraCancelada = :moraCancelada")
    , @NamedQuery(name = "Mora.findByEstado", query = "SELECT m FROM Mora m WHERE m.estado = :estado")
    , @NamedQuery(name = "Mora.findByFechaCancelacion", query = "SELECT m FROM Mora m WHERE m.fechaCancelacion = :fechaCancelacion")})
public class Mora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_mora", nullable = false)
    private Integer idMora;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mora_total", precision = 22)
    private Double moraTotal;
    @Column(name = "mora_cancelada", precision = 22)
    private Double moraCancelada;
    @Column(name = "estado")
    private Short estado;
    @Column(name = "fecha_cancelacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCancelacion;
    @JoinColumns({
        @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false)
        , @JoinColumn(name = "id_solicitud_credito", referencedColumnName = "id_solicitud_credito", nullable = false)})
    @ManyToOne(optional = false)
    private SolicitudCredito solicitudCredito;

    public Mora() {
    }

    public Mora(Integer idMora) {
        this.idMora = idMora;
    }

    public Integer getIdMora() {
        return idMora;
    }

    public void setIdMora(Integer idMora) {
        this.idMora = idMora;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Double getMoraTotal() {
        return moraTotal;
    }

    public void setMoraTotal(Double moraTotal) {
        this.moraTotal = moraTotal;
    }

    public Double getMoraCancelada() {
        return moraCancelada;
    }

    public void setMoraCancelada(Double moraCancelada) {
        this.moraCancelada = moraCancelada;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public SolicitudCredito getSolicitudCredito() {
        return solicitudCredito;
    }

    public void setSolicitudCredito(SolicitudCredito solicitudCredito) {
        this.solicitudCredito = solicitudCredito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMora != null ? idMora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mora)) {
            return false;
        }
        Mora other = (Mora) object;
        if ((this.idMora == null && other.idMora != null) || (this.idMora != null && !this.idMora.equals(other.idMora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Mora[ idMora=" + idMora + " ]";
    }
    
}
