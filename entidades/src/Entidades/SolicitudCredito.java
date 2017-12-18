/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dvid1
 */
@Entity
@Table(name = "solicitud_credito", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "SolicitudCredito.findAll", query = "SELECT s FROM SolicitudCredito s")
    , @NamedQuery(name = "SolicitudCredito.findByIdSolicitudCredito", query = "SELECT s FROM SolicitudCredito s WHERE s.solicitudCreditoPK.idSolicitudCredito = :idSolicitudCredito")
    , @NamedQuery(name = "SolicitudCredito.findByDui", query = "SELECT s FROM SolicitudCredito s WHERE s.solicitudCreditoPK.dui = :dui")
    , @NamedQuery(name = "SolicitudCredito.findByFechaSolicitud", query = "SELECT s FROM SolicitudCredito s WHERE s.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "SolicitudCredito.findByTipoCredito", query = "SELECT s FROM SolicitudCredito s WHERE s.tipoCredito = :tipoCredito")
    , @NamedQuery(name = "SolicitudCredito.findByMontoRequerido", query = "SELECT s FROM SolicitudCredito s WHERE s.montoRequerido = :montoRequerido")
    , @NamedQuery(name = "SolicitudCredito.findByPlazo", query = "SELECT s FROM SolicitudCredito s WHERE s.plazo = :plazo")
    , @NamedQuery(name = "SolicitudCredito.findByCuota", query = "SELECT s FROM SolicitudCredito s WHERE s.cuota = :cuota")
    , @NamedQuery(name = "SolicitudCredito.findByIvaCuota", query = "SELECT s FROM SolicitudCredito s WHERE s.ivaCuota = :ivaCuota")
    , @NamedQuery(name = "SolicitudCredito.findByFormaPago", query = "SELECT s FROM SolicitudCredito s WHERE s.formaPago = :formaPago")
    , @NamedQuery(name = "SolicitudCredito.findByDestinoCredito", query = "SELECT s FROM SolicitudCredito s WHERE s.destinoCredito = :destinoCredito")
    , @NamedQuery(name = "SolicitudCredito.findByEstado", query = "SELECT s FROM SolicitudCredito s WHERE s.estado = :estado")
    , @NamedQuery(name = "SolicitudCredito.findByObservacion", query = "SELECT s FROM SolicitudCredito s WHERE s.observacion = :observacion")
    , @NamedQuery(name = "SolicitudCredito.findByVisita", query = "SELECT s FROM SolicitudCredito s WHERE s.visita = :visita")
    , @NamedQuery(name = "SolicitudCredito.findByEstadosFinancieros", query = "SELECT s FROM SolicitudCredito s WHERE s.estadosFinancieros = :estadosFinancieros")
    , @NamedQuery(name = "SolicitudCredito.findByFechaVisita", query = "SELECT s FROM SolicitudCredito s WHERE s.fechaVisita = :fechaVisita")
    , @NamedQuery(name = "SolicitudCredito.findByInfored", query = "SELECT s FROM SolicitudCredito s WHERE s.infored = :infored")
    , @NamedQuery(name = "SolicitudCredito.findByDesembolso", query = "SELECT s FROM SolicitudCredito s WHERE s.desembolso = :desembolso")})
public class SolicitudCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolicitudCreditoPK solicitudCreditoPK;
    @Basic(optional = false)
    @Column(name = "fecha_solicitud", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @Column(name = "tipo_credito", nullable = false)
    private short tipoCredito;
    @Basic(optional = false)
    @Column(name = "monto_requerido", nullable = false)
    private double montoRequerido;
    @Basic(optional = false)
    @Column(name = "plazo", nullable = false)
    private short plazo;
    @Basic(optional = false)
    @Column(name = "cuota", nullable = false)
    private double cuota;
    @Basic(optional = false)
    @Column(name = "iva_cuota", nullable = false)
    private double ivaCuota;
    @Basic(optional = false)
    @Column(name = "forma_pago", nullable = false)
    private short formaPago;
    @Column(name = "destino_credito", length = 300)
    private String destinoCredito;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private short estado;
    @Column(name = "observacion", length = 1000)
    private String observacion;
    @Column(name = "visita")
    private Boolean visita;
    @Column(name = "estados_financieros")
    private Boolean estadosFinancieros;
    @Column(name = "fecha_visita")
    @Temporal(TemporalType.DATE)
    private Date fechaVisita;
    @Column(name = "infored")
    private Short infored;
    @Basic(optional = false)
    @Column(name = "desembolso", nullable = false)
    private boolean desembolso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudCredito")
    private List<Mora> moraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudCredito")
    private List<Pagos> pagosList;
    @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DatosPersonales datosPersonales;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "solicitudCredito")
    private EvaluacionCredito evaluacionCredito;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "solicitudCredito")
    private Creditos creditos;

    public SolicitudCredito() {
    }

    public SolicitudCredito(SolicitudCreditoPK solicitudCreditoPK) {
        this.solicitudCreditoPK = solicitudCreditoPK;
    }

    public SolicitudCredito(SolicitudCreditoPK solicitudCreditoPK, Date fechaSolicitud, short tipoCredito, double montoRequerido, short plazo, double cuota, double ivaCuota, short formaPago, short estado, boolean desembolso) {
        this.solicitudCreditoPK = solicitudCreditoPK;
        this.fechaSolicitud = fechaSolicitud;
        this.tipoCredito = tipoCredito;
        this.montoRequerido = montoRequerido;
        this.plazo = plazo;
        this.cuota = cuota;
        this.ivaCuota = ivaCuota;
        this.formaPago = formaPago;
        this.estado = estado;
        this.desembolso = desembolso;
    }

    public SolicitudCredito(int idSolicitudCredito, String dui) {
        this.solicitudCreditoPK = new SolicitudCreditoPK(idSolicitudCredito, dui);
    }

    public SolicitudCreditoPK getSolicitudCreditoPK() {
        return solicitudCreditoPK;
    }

    public void setSolicitudCreditoPK(SolicitudCreditoPK solicitudCreditoPK) {
        this.solicitudCreditoPK = solicitudCreditoPK;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public short getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(short tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public double getMontoRequerido() {
        return montoRequerido;
    }

    public void setMontoRequerido(double montoRequerido) {
        this.montoRequerido = montoRequerido;
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

    public double getIvaCuota() {
        return ivaCuota;
    }

    public void setIvaCuota(double ivaCuota) {
        this.ivaCuota = ivaCuota;
    }

    public short getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(short formaPago) {
        this.formaPago = formaPago;
    }

    public String getDestinoCredito() {
        return destinoCredito;
    }

    public void setDestinoCredito(String destinoCredito) {
        this.destinoCredito = destinoCredito;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getVisita() {
        return visita;
    }

    public void setVisita(Boolean visita) {
        this.visita = visita;
    }

    public Boolean getEstadosFinancieros() {
        return estadosFinancieros;
    }

    public void setEstadosFinancieros(Boolean estadosFinancieros) {
        this.estadosFinancieros = estadosFinancieros;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Short getInfored() {
        return infored;
    }

    public void setInfored(Short infored) {
        this.infored = infored;
    }

    public boolean getDesembolso() {
        return desembolso;
    }

    public void setDesembolso(boolean desembolso) {
        this.desembolso = desembolso;
    }

    public List<Mora> getMoraList() {
        return moraList;
    }

    public void setMoraList(List<Mora> moraList) {
        this.moraList = moraList;
    }

    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public EvaluacionCredito getEvaluacionCredito() {
        return evaluacionCredito;
    }

    public void setEvaluacionCredito(EvaluacionCredito evaluacionCredito) {
        this.evaluacionCredito = evaluacionCredito;
    }

    public Creditos getCreditos() {
        return creditos;
    }

    public void setCreditos(Creditos creditos) {
        this.creditos = creditos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudCreditoPK != null ? solicitudCreditoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCredito)) {
            return false;
        }
        SolicitudCredito other = (SolicitudCredito) object;
        if ((this.solicitudCreditoPK == null && other.solicitudCreditoPK != null) || (this.solicitudCreditoPK != null && !this.solicitudCreditoPK.equals(other.solicitudCreditoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SolicitudCredito[ solicitudCreditoPK=" + solicitudCreditoPK + " ]";
    }
    
}
