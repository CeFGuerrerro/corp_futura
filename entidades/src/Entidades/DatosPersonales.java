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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DFUENTES
 */
@Entity
@Table(name = "datos_personales", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "DatosPersonales.findAll", query = "SELECT d FROM DatosPersonales d")
    , @NamedQuery(name = "DatosPersonales.findByDui", query = "SELECT d FROM DatosPersonales d WHERE d.dui = :dui")
    , @NamedQuery(name = "DatosPersonales.findByNombre", query = "SELECT d FROM DatosPersonales d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DatosPersonales.findByNit", query = "SELECT d FROM DatosPersonales d WHERE d.nit = :nit")
    , @NamedQuery(name = "DatosPersonales.findByEstadoCivil", query = "SELECT d FROM DatosPersonales d WHERE d.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "DatosPersonales.findByFechaNacimiento", query = "SELECT d FROM DatosPersonales d WHERE d.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "DatosPersonales.findByCelular", query = "SELECT d FROM DatosPersonales d WHERE d.celular = :celular")
    , @NamedQuery(name = "DatosPersonales.findByTelefono", query = "SELECT d FROM DatosPersonales d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "DatosPersonales.findByFechaExpedicion", query = "SELECT d FROM DatosPersonales d WHERE d.fechaExpedicion = :fechaExpedicion")
    , @NamedQuery(name = "DatosPersonales.findByProfesion", query = "SELECT d FROM DatosPersonales d WHERE d.profesion = :profesion")
    , @NamedQuery(name = "DatosPersonales.findByOcupacion", query = "SELECT d FROM DatosPersonales d WHERE d.ocupacion = :ocupacion")
    , @NamedQuery(name = "DatosPersonales.findByNivelEstudio", query = "SELECT d FROM DatosPersonales d WHERE d.nivelEstudio = :nivelEstudio")
    , @NamedQuery(name = "DatosPersonales.findByCantidadHijos", query = "SELECT d FROM DatosPersonales d WHERE d.cantidadHijos = :cantidadHijos")
    , @NamedQuery(name = "DatosPersonales.findByDependen", query = "SELECT d FROM DatosPersonales d WHERE d.dependen = :dependen")})
public class DatosPersonales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dui", nullable = false, length = 10)
    private String dui;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "nit", nullable = false, length = 17)
    private String nit;
    @Basic(optional = false)
    @Column(name = "estado_civil", nullable = false)
    private short estadoCivil;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "celular", length = 10)
    private String celular;
    @Column(name = "telefono", length = 10)
    private String telefono;
    @Basic(optional = false)
    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;
    @Basic(optional = false)
    @Column(name = "profesion", nullable = false, length = 200)
    private String profesion;
    @Column(name = "ocupacion", length = 200)
    private String ocupacion;
    @Basic(optional = false)
    @Column(name = "nivel_estudio", nullable = false)
    private short nivelEstudio;
    @Basic(optional = false)
    @Column(name = "cantidad_hijos", nullable = false, length = 10)
    private String cantidadHijos;
    @Column(name = "dependen", length = 10)
    private String dependen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datosPersonales")
    private List<Referencias> referenciasList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "datosPersonales")
    private DatosConyugue datosConyugue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datosPersonales")
    private List<SolicitudCredito> solicitudCreditoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "datosPersonales")
    private Domicilio domicilio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datosPersonales")
    private List<Familiares> familiaresList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "datosPersonales")
    private InformacionNegocio informacionNegocio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duiCodeudor")
    private List<Codeudores> codeudoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datosPersonales")
    private List<Codeudores> codeudoresList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datosPersonales")
    private List<DeclaracionBienes> declaracionBienesList;

    public DatosPersonales() {
    }

    public DatosPersonales(String dui) {
        this.dui = dui;
    }

    public DatosPersonales(String dui, String nombre, String nit, short estadoCivil, Date fechaNacimiento, Date fechaExpedicion, String profesion, short nivelEstudio, String cantidadHijos) {
        this.dui = dui;
        this.nombre = nombre;
        this.nit = nit;
        this.estadoCivil = estadoCivil;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaExpedicion = fechaExpedicion;
        this.profesion = profesion;
        this.nivelEstudio = nivelEstudio;
        this.cantidadHijos = cantidadHijos;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public short getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(short estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public short getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(short nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public String getCantidadHijos() {
        return cantidadHijos;
    }

    public void setCantidadHijos(String cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

    public String getDependen() {
        return dependen;
    }

    public void setDependen(String dependen) {
        this.dependen = dependen;
    }

    public List<Referencias> getReferenciasList() {
        return referenciasList;
    }

    public void setReferenciasList(List<Referencias> referenciasList) {
        this.referenciasList = referenciasList;
    }

    public DatosConyugue getDatosConyugue() {
        return datosConyugue;
    }

    public void setDatosConyugue(DatosConyugue datosConyugue) {
        this.datosConyugue = datosConyugue;
    }

    public List<SolicitudCredito> getSolicitudCreditoList() {
        return solicitudCreditoList;
    }

    public void setSolicitudCreditoList(List<SolicitudCredito> solicitudCreditoList) {
        this.solicitudCreditoList = solicitudCreditoList;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public List<Familiares> getFamiliaresList() {
        return familiaresList;
    }

    public void setFamiliaresList(List<Familiares> familiaresList) {
        this.familiaresList = familiaresList;
    }

    public InformacionNegocio getInformacionNegocio() {
        return informacionNegocio;
    }

    public void setInformacionNegocio(InformacionNegocio informacionNegocio) {
        this.informacionNegocio = informacionNegocio;
    }

    public List<Codeudores> getCodeudoresList() {
        return codeudoresList;
    }

    public void setCodeudoresList(List<Codeudores> codeudoresList) {
        this.codeudoresList = codeudoresList;
    }

    public List<Codeudores> getCodeudoresList1() {
        return codeudoresList1;
    }

    public void setCodeudoresList1(List<Codeudores> codeudoresList1) {
        this.codeudoresList1 = codeudoresList1;
    }

    public List<DeclaracionBienes> getDeclaracionBienesList() {
        return declaracionBienesList;
    }

    public void setDeclaracionBienesList(List<DeclaracionBienes> declaracionBienesList) {
        this.declaracionBienesList = declaracionBienesList;
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
        if (!(object instanceof DatosPersonales)) {
            return false;
        }
        DatosPersonales other = (DatosPersonales) object;
        if ((this.dui == null && other.dui != null) || (this.dui != null && !this.dui.equals(other.dui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DatosPersonales[ dui=" + dui + " ]";
    }
    
}
