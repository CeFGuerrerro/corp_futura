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
@Table(name = "domicilio", catalog = "corpfutura", schema = "")
@NamedQueries({
    @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d")
    , @NamedQuery(name = "Domicilio.findByDui", query = "SELECT d FROM Domicilio d WHERE d.dui = :dui")
    , @NamedQuery(name = "Domicilio.findByDomicilio", query = "SELECT d FROM Domicilio d WHERE d.domicilio = :domicilio")
    , @NamedQuery(name = "Domicilio.findByPuntoReferencia", query = "SELECT d FROM Domicilio d WHERE d.puntoReferencia = :puntoReferencia")
    , @NamedQuery(name = "Domicilio.findByComoLlegar", query = "SELECT d FROM Domicilio d WHERE d.comoLlegar = :comoLlegar")
    , @NamedQuery(name = "Domicilio.findByTiempoVivienda", query = "SELECT d FROM Domicilio d WHERE d.tiempoVivienda = :tiempoVivienda")
    , @NamedQuery(name = "Domicilio.findBySituacionVivienta", query = "SELECT d FROM Domicilio d WHERE d.situacionVivienta = :situacionVivienta")})
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dui", nullable = false, length = 10)
    private String dui;
    @Basic(optional = false)
    @Column(name = "domicilio", nullable = false, length = 500)
    private String domicilio;
    @Column(name = "punto_referencia", length = 1000)
    private String puntoReferencia;
    @Column(name = "como_llegar", length = 1000)
    private String comoLlegar;
    @Basic(optional = false)
    @Column(name = "tiempo_vivienda", nullable = false, length = 100)
    private String tiempoVivienda;
    @Basic(optional = false)
    @Column(name = "situacion_vivienta", nullable = false)
    private short situacionVivienta;
    @JoinColumn(name = "dui", referencedColumnName = "dui", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DatosPersonales datosPersonales;

    public Domicilio() {
    }

    public Domicilio(String dui) {
        this.dui = dui;
    }

    public Domicilio(String dui, String domicilio, String tiempoVivienda, short situacionVivienta) {
        this.dui = dui;
        this.domicilio = domicilio;
        this.tiempoVivienda = tiempoVivienda;
        this.situacionVivienta = situacionVivienta;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getPuntoReferencia() {
        return puntoReferencia;
    }

    public void setPuntoReferencia(String puntoReferencia) {
        this.puntoReferencia = puntoReferencia;
    }

    public String getComoLlegar() {
        return comoLlegar;
    }

    public void setComoLlegar(String comoLlegar) {
        this.comoLlegar = comoLlegar;
    }

    public String getTiempoVivienda() {
        return tiempoVivienda;
    }

    public void setTiempoVivienda(String tiempoVivienda) {
        this.tiempoVivienda = tiempoVivienda;
    }

    public short getSituacionVivienta() {
        return situacionVivienta;
    }

    public void setSituacionVivienta(short situacionVivienta) {
        this.situacionVivienta = situacionVivienta;
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
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.dui == null && other.dui != null) || (this.dui != null && !this.dui.equals(other.dui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Domicilio[ dui=" + dui + " ]";
    }
    
}
