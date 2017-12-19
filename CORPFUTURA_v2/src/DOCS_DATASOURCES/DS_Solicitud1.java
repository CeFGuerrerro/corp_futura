/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCS_DATASOURCES;

import Entidades.SolicitudCredito;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author o-a19
 */
public class DS_Solicitud1 implements JRDataSource {

    private List<SolicitudCredito> listaSolicitudes = new ArrayList<SolicitudCredito>();
    private int indice = -1;

    public void addSolicitud(SolicitudCredito solicitud) {
        this.listaSolicitudes.add(solicitud);
    }

    @Override
    public boolean next() throws JRException {
        return ++indice < listaSolicitudes.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        if (null != jrf.getName()) {
            switch (jrf.getName()) {
                case "fecha":
                    valor = listaSolicitudes.get(indice).getFechaSolicitud().toString();
                    return valor;
                case "nombre":
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getNombre();
                    return valor;
                case "domicilio":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDomicilio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getDomicilio().getDomicilio();
                    }
                    return valor;
                case "preferencia":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDomicilio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getDomicilio().getPuntoReferencia();
                    }
                    return valor;
                case "cllegar":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDomicilio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getDomicilio().getComoLlegar();
                    }
                    return valor;
                case "anios":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDomicilio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getDomicilio().getTiempoVivienda();
                    }
                    return valor;
                case "dui":
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getDui();
                    return valor;
                case "fechaexp":
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getFechaExpedicion().toString();
                    return valor;
                case "nit":
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getNit();
                    return valor;
                case "ecivil":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getEstadoCivil() == 1) {
                        valor = "SOLTERO/A";
                    } else if (listaSolicitudes.get(indice).getDatosPersonales().getEstadoCivil() == 2) {
                        valor = "CASADO/A";
                    } else if (listaSolicitudes.get(indice).getDatosPersonales().getEstadoCivil() == 3) {
                        valor = "DIVORCIADO/A";
                    } else if (listaSolicitudes.get(indice).getDatosPersonales().getEstadoCivil() == 4) {
                        valor = "VIUDO/A";
                    }
                    return valor;
                case "tel":
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getTelefono();
                    return valor;
                case "cel":
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getCelular();
                    return valor;
                case "nhijo":
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getCantidadHijos();
                    return valor;
                case "dependen":
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getDependen();
                    return valor;
                case "nstudio":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getNivelEstudio() == 1) {
                        valor = "PRIMARIA";
                    }
                    if (listaSolicitudes.get(indice).getDatosPersonales().getNivelEstudio() == 2) {
                        valor = "EDUCACION BASICA";
                    }
                    if (listaSolicitudes.get(indice).getDatosPersonales().getNivelEstudio() == 3) {
                        valor = "BACHILLERATO";
                    }
                    if (listaSolicitudes.get(indice).getDatosPersonales().getNivelEstudio() == 4) {
                        valor = "TECNICO";
                    }
                    if (listaSolicitudes.get(indice).getDatosPersonales().getNivelEstudio() == 5) {
                        valor = "UNIVERSITARIO";
                    }
                    return valor;
                case "oficio":
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getProfesion();
                    return valor;
                case "ocupacion":
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getOcupacion();
                    return valor;
                case "conyugue":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDatosConyugue() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getDatosConyugue().getNombre();
                    }
                    return valor;
                case "dirconyugue":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDatosConyugue() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getDatosConyugue().getDireccion();
                    }
                    return valor;
                case "trabconyugue":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDatosConyugue() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getDatosConyugue().getLugarTrabajo();
                    }
                    return valor;
                case "cargoconyugue":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDatosConyugue() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getDatosConyugue().getCargo();
                    }
                    return valor;
                case "telconyugue":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDatosConyugue() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getDatosConyugue().getTelefono();
                    }
                    return valor;
                case "propia":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDomicilio().getSituacionVivienta() == 1) {
                        valor = "X";
                    }
                    return valor;
                case "alqui":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDomicilio().getSituacionVivienta() == 2) {
                        valor = "X";
                    }
                    return valor;
                case "familiar":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getDomicilio().getSituacionVivienta() == 3) {
                        valor = "X";
                    }
                    return valor;
                case "nneg":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getNombre();
                        return valor;
                    }
                case "giro":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getGiro();
                        return valor;
                    }
                case "dirneg":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getDireccion();
                        return valor;
                    }
                case "llegarneg":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getComoLlegar();
                        return valor;
                    }
                case "tneg":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getTiempoFuncion();
                        return valor;
                    }
                case "telneg":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getTelefono();
                        return valor;
                    }
                case "hventa":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getHorarios();
                        return valor;
                    }
                case "rutas":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getRutasVenta();
                        return valor;
                    }
                case "utilidad":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getUtilidadMensual();
                        return valor;
                    }
                case "empleados":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                        valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getNumeroEmpleados();
                        return valor;
                    }
                case "local":
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                        if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getTipoLocal() == 1) {
                            valor = "PROPIO";
                        } else if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getTipoLocal() == 2) {
                            valor = "ALQUILADO";
                        }
                        return valor;
                    }
            }
        }
        return valor;

    }

}
