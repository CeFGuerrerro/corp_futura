/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCS_DATASOURCES;

import Entidades.SolicitudCredito;
import static UTILIDADES.fechas.calcularEdad;
import static UTILIDADES.fechas.formatearFecha;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author o-a19
 */
public class DS_SolicitudExpress implements JRDataSource {

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
        switch (jrf.getName()) {
            case "fecha":
                valor = formatearFecha(listaSolicitudes.get(indice).getFechaSolicitud());
                return valor;
            case "nombre":
                valor = listaSolicitudes.get(indice).getDatosPersonales().getNombre();
                return valor;
            case "domicilio":
                if (listaSolicitudes.get(indice).getDatosPersonales().getDomicilio() != null) {
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getDomicilio().getDomicilio();
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
                valor = formatearFecha(listaSolicitudes.get(indice).getDatosPersonales().getFechaExpedicion());
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
            case "edad":
                valor = calcularEdad(listaSolicitudes.get(indice).getDatosPersonales().getFechaNacimiento());
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
            case "vivienda":
                if (listaSolicitudes.get(indice).getDatosPersonales().getDomicilio().getSituacionVivienta() == 1) {
                    valor = "PROPIA";
                }else if (listaSolicitudes.get(indice).getDatosPersonales().getDomicilio().getSituacionVivienta() == 2) {
                    valor = "ALQUILADA";
                }else if (listaSolicitudes.get(indice).getDatosPersonales().getDomicilio().getSituacionVivienta() == 3) {
                    valor = "FAMILIAR";
                }
                return valor;
            case "montocli":
                valor = listaSolicitudes.get(indice).getMontoRequerido();
                return valor;
            case "plazocli":
                if (listaSolicitudes.get(indice).getPlazo() == 1) {
                    valor = "1 MES / 4 SEMANAS";
                } else if (listaSolicitudes.get(indice).getPlazo() == 2) {
                    valor = "2 MESES / 8 SEMANAS";
                } else if (listaSolicitudes.get(indice).getPlazo() == 3) {
                    valor = "3 MESES / 12 SEMANAS";
                } else if (listaSolicitudes.get(indice).getPlazo() == 4) {
                    valor = "4 MESES / 16 SEMANAS";
                } else if (listaSolicitudes.get(indice).getPlazo() == 5) {
                    valor = "5 MESES / 20 SEMANAS";
                } else if (listaSolicitudes.get(indice).getPlazo() == 6) {
                    valor = "6 MESES / 24 SEMANAS";
                } else if (listaSolicitudes.get(indice).getPlazo() == 7) {
                    valor = "7 MESES / 28 SEMANAS";
                } else if (listaSolicitudes.get(indice).getPlazo() == 8) {
                    valor = "8 MESES / 32 SEMANAS";
                } else if (listaSolicitudes.get(indice).getPlazo() == 9) {
                    valor = "9 MESES / 36 SEMANAS";
                } else if (listaSolicitudes.get(indice).getPlazo() == 10) {
                    valor = "10 MESES / 40 SEMANAS";
                } else if (listaSolicitudes.get(indice).getPlazo() == 11) {
                    valor = "11 MESES / 44 SEMANAS";
                } else if (listaSolicitudes.get(indice).getPlazo() == 12) {
                    valor = "12 MESES / 48 SEMANAS";
                }
                return valor;
            case "cuotacli":
                valor = listaSolicitudes.get(indice).getCuota();
                return valor;
            case "formacli":
                if (listaSolicitudes.get(indice).getFormaPago() == 1) {
                    valor = "SEMANAL";
                } else if (listaSolicitudes.get(indice).getFormaPago() == 2) {
                    valor = "CATORCENAL";
                } else if (listaSolicitudes.get(indice).getFormaPago() == 3) {
                    valor = "MENSUAL";
                }
                return valor;

        }

        return valor;
    }

}
