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
@Table(name = "pagos", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p")
    , @NamedQuery(name = "Pagos.findByIdPago", query = "SELECT p FROM Pagos p WHERE p.idPago = :idPago")
    , @NamedQuery(name = "Pagos.findByFechaPago", query = "SELECT p FROM Pagos p WHERE p.fechaPago = :fechaPago")
    , @NamedQuery(name = "Pagos.findByNumFactura", query = "SELECT p FROM Pagos p WHERE p.numFactura = :numFactura")
    , @NamedQuery(name = "Pagos.findByMontoPagado", query = "SELECT p FROM Pagos p WHERE p.montoPagado = :montoPagado")
    , @NamedQuery(name = "Pagos.findByCapitalAbonado", query = "SELECT p FROM Pagos p WHERE p.capitalAbonado = :capitalAbonado")
    , @NamedQuery(name = "Pagos.findByInteres", query = "SELECT p FROM Pagos p WHERE p.interes = :interes")
    , @NamedQuery(name = "Pagos.findByIvaIntereses", query = "SELECT p FROM Pagos p WHERE p.ivaIntereses = :ivaIntereses")
    , @NamedQuery(name = "Pagos.findByIvaMora", query = "SELECT p FROM Pagos p WHERE p.ivaMora = :ivaMora")
    , @NamedQuery(name = "Pagos.findByMora", query = "SELECT p FROM Pagos p WHERE p.mora = :mora")
    , @NamedQuery(name = "Pagos.findByCuotaNumero", query = "SELECT p FROM Pagos p WHERE p.cuotaNumero = :cuotaNumero")
    , @NamedQuery(name = "Pagos.findByCancelado", query = "SELECT p FROM Pagos p WHERE p.cancelado = :cancelado")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pago", nullable = false)
    private Integer idPago;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "num_factura", length = 15)
    private String numFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_pagado", precision = 22)
    private Double montoPagado;
    @Column(name = "capital_abonado", precision = 22)
    private Double capitalAbonado;
    @Column(name = "interes", precision = 22)
    private Double interes;
    @Column(name = "iva_intereses", precision = 22)
    private Double ivaIntereses;
    @Column(name = "iva_mora", precision = 22)
    private Double ivaMora;
    @Column(name = "mora", precision = 22)
    private Double mora;
    @Column(name = "cuota_numero")
    private Integer cuotaNumero;
    @Column(name = "cancelado")
    private Boolean cancelado;
    @JoinColumns({
        @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false)
        , @JoinColumn(name = "id_solicitud_credito", referencedColumnName = "id_solicitud_credito", nullable = false)})
    @ManyToOne(optional = false)
    private SolicitudCredito solicitudCredito;

    public Pagos() {
    }

    public Pagos(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public Double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(Double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public Double getCapitalAbonado() {
        return capitalAbonado;
    }

    public void setCapitalAbonado(Double capitalAbonado) {
        this.capitalAbonado = capitalAbonado;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Double getIvaIntereses() {
        return ivaIntereses;
    }

    public void setIvaIntereses(Double ivaIntereses) {
        this.ivaIntereses = ivaIntereses;
    }

    public Double getIvaMora() {
        return ivaMora;
    }

    public void setIvaMora(Double ivaMora) {
        this.ivaMora = ivaMora;
    }

    public Double getMora() {
        return mora;
    }

    public void setMora(Double mora) {
        this.mora = mora;
    }

    public Integer getCuotaNumero() {
        return cuotaNumero;
    }

    public void setCuotaNumero(Integer cuotaNumero) {
        this.cuotaNumero = cuotaNumero;
    }

    public Boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
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
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pagos[ idPago=" + idPago + " ]";
    }
    
}
