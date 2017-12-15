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
 * @author DFUENTES
 */
@Entity
@Table(name = "evaluacion_credito", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "EvaluacionCredito.findAll", query = "SELECT e FROM EvaluacionCredito e")
    , @NamedQuery(name = "EvaluacionCredito.findByDui", query = "SELECT e FROM EvaluacionCredito e WHERE e.evaluacionCreditoPK.dui = :dui")
    , @NamedQuery(name = "EvaluacionCredito.findByIdSolicitudCredito", query = "SELECT e FROM EvaluacionCredito e WHERE e.evaluacionCreditoPK.idSolicitudCredito = :idSolicitudCredito")
    , @NamedQuery(name = "EvaluacionCredito.findByMonto", query = "SELECT e FROM EvaluacionCredito e WHERE e.monto = :monto")
    , @NamedQuery(name = "EvaluacionCredito.findByPlazo", query = "SELECT e FROM EvaluacionCredito e WHERE e.plazo = :plazo")
    , @NamedQuery(name = "EvaluacionCredito.findByCuota", query = "SELECT e FROM EvaluacionCredito e WHERE e.cuota = :cuota")
    , @NamedQuery(name = "EvaluacionCredito.findByFormaPago", query = "SELECT e FROM EvaluacionCredito e WHERE e.formaPago = :formaPago")
    , @NamedQuery(name = "EvaluacionCredito.findByIvaCuota", query = "SELECT e FROM EvaluacionCredito e WHERE e.ivaCuota = :ivaCuota")
    , @NamedQuery(name = "EvaluacionCredito.findByFechaEvaluacion", query = "SELECT e FROM EvaluacionCredito e WHERE e.fechaEvaluacion = :fechaEvaluacion")
    , @NamedQuery(name = "EvaluacionCredito.findByFuentesFondos", query = "SELECT e FROM EvaluacionCredito e WHERE e.fuentesFondos = :fuentesFondos")
    , @NamedQuery(name = "EvaluacionCredito.findByJustificacion", query = "SELECT e FROM EvaluacionCredito e WHERE e.justificacion = :justificacion")
    , @NamedQuery(name = "EvaluacionCredito.findByTipoGarantia", query = "SELECT e FROM EvaluacionCredito e WHERE e.tipoGarantia = :tipoGarantia")})
public class EvaluacionCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluacionCreditoPK evaluacionCreditoPK;
    @Basic(optional = false)
    @Column(name = "monto", nullable = false)
    private double monto;
    @Basic(optional = false)
    @Column(name = "plazo", nullable = false)
    private short plazo;
    @Basic(optional = false)
    @Column(name = "cuota", nullable = false)
    private double cuota;
    @Basic(optional = false)
    @Column(name = "forma_pago", nullable = false)
    private short formaPago;
    @Basic(optional = false)
    @Column(name = "iva_cuota", nullable = false)
    private double ivaCuota;
    @Basic(optional = false)
    @Column(name = "fecha_evaluacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEvaluacion;
    @Basic(optional = false)
    @Column(name = "fuentes_fondos", nullable = false)
    private short fuentesFondos;
    @Basic(optional = false)
    @Column(name = "justificacion", nullable = false, length = 1000)
    private String justificacion;
    @Basic(optional = false)
    @Column(name = "tipo_garantia", nullable = false)
    private short tipoGarantia;
    @JoinColumns({
        @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "id_solicitud_credito", referencedColumnName = "id_solicitud_credito", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private SolicitudCredito solicitudCredito;

    public EvaluacionCredito() {
    }

    public EvaluacionCredito(EvaluacionCreditoPK evaluacionCreditoPK) {
        this.evaluacionCreditoPK = evaluacionCreditoPK;
    }

    public EvaluacionCredito(EvaluacionCreditoPK evaluacionCreditoPK, double monto, short plazo, double cuota, short formaPago, double ivaCuota, Date fechaEvaluacion, short fuentesFondos, String justificacion, short tipoGarantia) {
        this.evaluacionCreditoPK = evaluacionCreditoPK;
        this.monto = monto;
        this.plazo = plazo;
        this.cuota = cuota;
        this.formaPago = formaPago;
        this.ivaCuota = ivaCuota;
        this.fechaEvaluacion = fechaEvaluacion;
        this.fuentesFondos = fuentesFondos;
        this.justificacion = justificacion;
        this.tipoGarantia = tipoGarantia;
    }

    public EvaluacionCredito(String dui, int idSolicitudCredito) {
        this.evaluacionCreditoPK = new EvaluacionCreditoPK(dui, idSolicitudCredito);
    }

    public EvaluacionCreditoPK getEvaluacionCreditoPK() {
        return evaluacionCreditoPK;
    }

    public void setEvaluacionCreditoPK(EvaluacionCreditoPK evaluacionCreditoPK) {
        this.evaluacionCreditoPK = evaluacionCreditoPK;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public short getPlazo() {
        return plazo;
    }

    public void setPlazo(short plazo) {
        this.plazo = plazo;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public short getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(short formaPago) {
        this.formaPago = formaPago;
    }

    public double getIvaCuota() {
        return ivaCuota;
    }

    public void setIvaCuota(double ivaCuota) {
        this.ivaCuota = ivaCuota;
    }

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public short getFuentesFondos() {
        return fuentesFondos;
    }

    public void setFuentesFondos(short fuentesFondos) {
        this.fuentesFondos = fuentesFondos;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public short getTipoGarantia() {
        return tipoGarantia;
    }

    public void setTipoGarantia(short tipoGarantia) {
        this.tipoGarantia = tipoGarantia;
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
        hash += (evaluacionCreditoPK != null ? evaluacionCreditoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionCredito)) {
            return false;
        }
        EvaluacionCredito other = (EvaluacionCredito) object;
        if ((this.evaluacionCreditoPK == null && other.evaluacionCreditoPK != null) || (this.evaluacionCreditoPK != null && !this.evaluacionCreditoPK.equals(other.evaluacionCreditoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EvaluacionCredito[ evaluacionCreditoPK=" + evaluacionCreditoPK + " ]";
    }
    
}
