/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dvid1
 */
@Entity
@Table(name = "creditos", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "Creditos.findAll", query = "SELECT c FROM Creditos c")
    , @NamedQuery(name = "Creditos.findByDui", query = "SELECT c FROM Creditos c WHERE c.creditosPK.dui = :dui")
    , @NamedQuery(name = "Creditos.findByIdSolicitudCredito", query = "SELECT c FROM Creditos c WHERE c.creditosPK.idSolicitudCredito = :idSolicitudCredito")
    , @NamedQuery(name = "Creditos.findByMonto", query = "SELECT c FROM Creditos c WHERE c.monto = :monto")
    , @NamedQuery(name = "Creditos.findByPlazo", query = "SELECT c FROM Creditos c WHERE c.plazo = :plazo")
    , @NamedQuery(name = "Creditos.findByCuota", query = "SELECT c FROM Creditos c WHERE c.cuota = :cuota")
    , @NamedQuery(name = "Creditos.findByFormaPago", query = "SELECT c FROM Creditos c WHERE c.formaPago = :formaPago")
    , @NamedQuery(name = "Creditos.findByFechaInicio", query = "SELECT c FROM Creditos c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Creditos.findByFechaVencimiento", query = "SELECT c FROM Creditos c WHERE c.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "Creditos.findByFechaPrimerPago", query = "SELECT c FROM Creditos c WHERE c.fechaPrimerPago = :fechaPrimerPago")
    , @NamedQuery(name = "Creditos.findByAsesoria", query = "SELECT c FROM Creditos c WHERE c.asesoria = :asesoria")
    , @NamedQuery(name = "Creditos.findByCuotaFinal", query = "SELECT c FROM Creditos c WHERE c.cuotaFinal = :cuotaFinal")
    , @NamedQuery(name = "Creditos.findByDescuentoCf", query = "SELECT c FROM Creditos c WHERE c.descuentoCf = :descuentoCf")
    , @NamedQuery(name = "Creditos.findByCapitalDes", query = "SELECT c FROM Creditos c WHERE c.capitalDes = :capitalDes")
    , @NamedQuery(name = "Creditos.findByInteresesDes", query = "SELECT c FROM Creditos c WHERE c.interesesDes = :interesesDes")
    , @NamedQuery(name = "Creditos.findByMoraDes", query = "SELECT c FROM Creditos c WHERE c.moraDes = :moraDes")
    , @NamedQuery(name = "Creditos.findBySaldoPagado", query = "SELECT c FROM Creditos c WHERE c.saldoPagado = :saldoPagado")
    , @NamedQuery(name = "Creditos.findBySaldoRestante", query = "SELECT c FROM Creditos c WHERE c.saldoRestante = :saldoRestante")
    , @NamedQuery(name = "Creditos.findByInteresPagados", query = "SELECT c FROM Creditos c WHERE c.interesPagados = :interesPagados")
    , @NamedQuery(name = "Creditos.findByIvaPagado", query = "SELECT c FROM Creditos c WHERE c.ivaPagado = :ivaPagado")
    , @NamedQuery(name = "Creditos.findByMoraPagada", query = "SELECT c FROM Creditos c WHERE c.moraPagada = :moraPagada")
    , @NamedQuery(name = "Creditos.findByCuotasPagadas", query = "SELECT c FROM Creditos c WHERE c.cuotasPagadas = :cuotasPagadas")
    , @NamedQuery(name = "Creditos.findByCuotasPorPagar", query = "SELECT c FROM Creditos c WHERE c.cuotasPorPagar = :cuotasPorPagar")
    , @NamedQuery(name = "Creditos.findByEstado", query = "SELECT c FROM Creditos c WHERE c.estado = :estado")})
public class Creditos implements Serializable {

    @Column(name = "total_intereses")
    private Double totalIntereses;
    @Column(name = "total_iva")
    private Double totalIva;
    @Column(name = "desembolso")
    private Double desembolso;
    @Column(name = "iva_asesoria")
    private Double ivaAsesoria;
    @Column(name = "iva_cuota_final")
    private Double ivaCuotaFinal;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CreditosPK creditosPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto", precision = 22)
    private Double monto;
    @Column(name = "plazo")
    private Short plazo;
    @Column(name = "cuota", precision = 22)
    private Double cuota;
    @Column(name = "forma_pago")
    private Short formaPago;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "fecha_primer_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPrimerPago;
    @Column(name = "asesoria", precision = 22)
    private Double asesoria;
    @Column(name = "cuota_final", precision = 22)
    private Double cuotaFinal;
    @Column(name = "descuento_cf")
    private Boolean descuentoCf;
    @Column(name = "capital_des", precision = 22)
    private Double capitalDes;
    @Column(name = "intereses_des", precision = 22)
    private Double interesesDes;
    @Column(name = "mora_des", precision = 22)
    private Double moraDes;
    @Column(name = "saldo_pagado", precision = 22)
    private Double saldoPagado;
    @Column(name = "saldo_restante", precision = 22)
    private Double saldoRestante;
    @Column(name = "interes_pagados", precision = 22)
    private Double interesPagados;
    @Column(name = "iva_pagado", precision = 22)
    private Double ivaPagado;
    @Column(name = "mora_pagada", precision = 22)
    private Double moraPagada;
    @Column(name = "cuotas_pagadas")
    private Integer cuotasPagadas;
    @Column(name = "cuotas_por_pagar")
    private Integer cuotasPorPagar;
    @Column(name = "estado")
    private Short estado;
    @JoinColumns({
        @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "id_solicitud_credito", referencedColumnName = "id_solicitud_credito", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private SolicitudCredito solicitudCredito;

    public Creditos() {
    }

    public Creditos(CreditosPK creditosPK) {
        this.creditosPK = creditosPK;
    }

    public Creditos(String dui, int idSolicitudCredito) {
        this.creditosPK = new CreditosPK(dui, idSolicitudCredito);
    }

    public CreditosPK getCreditosPK() {
        return creditosPK;
    }

    public void setCreditosPK(CreditosPK creditosPK) {
        this.creditosPK = creditosPK;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Short getPlazo() {
        return plazo;
    }

    public void setPlazo(Short plazo) {
        this.plazo = plazo;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public Short getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Short formaPago) {
        this.formaPago = formaPago;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaPrimerPago() {
        return fechaPrimerPago;
    }

    public void setFechaPrimerPago(Date fechaPrimerPago) {
        this.fechaPrimerPago = fechaPrimerPago;
    }

    public Double getAsesoria() {
        return asesoria;
    }

    public void setAsesoria(Double asesoria) {
        this.asesoria = asesoria;
    }

    public Double getCuotaFinal() {
        return cuotaFinal;
    }

    public void setCuotaFinal(Double cuotaFinal) {
        this.cuotaFinal = cuotaFinal;
    }

    public Boolean getDescuentoCf() {
        return descuentoCf;
    }

    public void setDescuentoCf(Boolean descuentoCf) {
        this.descuentoCf = descuentoCf;
    }

    public Double getCapitalDes() {
        return capitalDes;
    }

    public void setCapitalDes(Double capitalDes) {
        this.capitalDes = capitalDes;
    }

    public Double getInteresesDes() {
        return interesesDes;
    }

    public void setInteresesDes(Double interesesDes) {
        this.interesesDes = interesesDes;
    }

    public Double getMoraDes() {
        return moraDes;
    }

    public void setMoraDes(Double moraDes) {
        this.moraDes = moraDes;
    }

    public Double getSaldoPagado() {
        return saldoPagado;
    }

    public void setSaldoPagado(Double saldoPagado) {
        this.saldoPagado = saldoPagado;
    }

    public Double getSaldoRestante() {
        return saldoRestante;
    }

    public void setSaldoRestante(Double saldoRestante) {
        this.saldoRestante = saldoRestante;
    }

    public Double getInteresPagados() {
        return interesPagados;
    }

    public void setInteresPagados(Double interesPagados) {
        this.interesPagados = interesPagados;
    }

    public Double getIvaPagado() {
        return ivaPagado;
    }

    public void setIvaPagado(Double ivaPagado) {
        this.ivaPagado = ivaPagado;
    }

    public Double getMoraPagada() {
        return moraPagada;
    }

    public void setMoraPagada(Double moraPagada) {
        this.moraPagada = moraPagada;
    }

    public Integer getCuotasPagadas() {
        return cuotasPagadas;
    }

    public void setCuotasPagadas(Integer cuotasPagadas) {
        this.cuotasPagadas = cuotasPagadas;
    }

    public Integer getCuotasPorPagar() {
        return cuotasPorPagar;
    }

    public void setCuotasPorPagar(Integer cuotasPorPagar) {
        this.cuotasPorPagar = cuotasPorPagar;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
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
        hash += (creditosPK != null ? creditosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditos)) {
            return false;
        }
        Creditos other = (Creditos) object;
        if ((this.creditosPK == null && other.creditosPK != null) || (this.creditosPK != null && !this.creditosPK.equals(other.creditosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Creditos[ creditosPK=" + creditosPK + " ]";
    }

    public Double getTotalIntereses() {
        return totalIntereses;
    }

    public void setTotalIntereses(Double totalIntereses) {
        this.totalIntereses = totalIntereses;
    }

    public Double getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Double totalIva) {
        this.totalIva = totalIva;
    }

    public Double getDesembolso() {
        return desembolso;
    }

    public void setDesembolso(Double desembolso) {
        this.desembolso = desembolso;
    }

    public Double getIvaAsesoria() {
        return ivaAsesoria;
    }

    public void setIvaAsesoria(Double ivaAsesoria) {
        this.ivaAsesoria = ivaAsesoria;
    }

    public Double getIvaCuotaFinal() {
        return ivaCuotaFinal;
    }

    public void setIvaCuotaFinal(Double ivaCuotaFinal) {
        this.ivaCuotaFinal = ivaCuotaFinal;
    }
    
}
