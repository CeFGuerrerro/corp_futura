/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCS_DATASOURCES;

import Entidades.Referencias;
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
public class DS_Solicitud2 implements JRDataSource {

    private List<SolicitudCredito> listaSolicitudes = new ArrayList<SolicitudCredito>();
    private int indice = -1;

    public void addSolicitud(SolicitudCredito sol) {
        this.listaSolicitudes.add(sol);
    }

    @Override
    public boolean next() throws JRException {
        return ++indice < listaSolicitudes.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        switch (jrf.getName()) {
            case "observaciones":
                if (listaSolicitudes.get(indice).getObservacion() != null) {
                    valor = listaSolicitudes.get(indice).getObservacion();
                    return valor;
                }
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
            case "nneg":
                if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getNombre();
                }
                return valor;
            case "giro":
                if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getGiro();

                }
                return valor;
            case "dirneg":
                if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getDireccion();

                }
                return valor;
            case "llegarneg":
                if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getComoLlegar();
                }
                return valor;
            case "tneg":
                if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getTiempoFuncion();
                }
                return valor;
            case "telneg":
                if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getTelefono();

                }
                return valor;
            case "hventa":
                if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getHorarios();

                }
                return valor;
            case "rutas":
                if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getRutasVenta();

                }
                return valor;
            case "utilidad":
                if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getUtilidadMensual();

                }
                return valor;
            case "empleados":
                if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getNumeroEmpleados();

                }
                return valor;
            case "local":
                if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio() != null) {
                    if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getTipoLocal() == 1) {
                        valor = "PROPIO";
                    } else if (listaSolicitudes.get(indice).getDatosPersonales().getInformacionNegocio().getTipoLocal() == 2) {
                        valor = "ALQUILADO";
                    }
                }
                return valor;
            case "capital":
                valor = listaSolicitudes.get(indice).getCapitalDes();
                return valor;
            case "intereses":
                valor = listaSolicitudes.get(indice).getInteresesDes();
                return valor;
            case "papeleria":
                valor = listaSolicitudes.get(indice).getAsesoria();
                return valor;
            case "ivapapeleria":
                valor = listaSolicitudes.get(indice).getIvaAsesoria();
                return valor;
            case "cuota":
                if (listaSolicitudes.get(indice).getDescuentoCf()) {
                    valor = listaSolicitudes.get(indice).getCuota();
                } else {
                    valor = 0.0;
                }
                return valor;

        }
        return valor;

    }

}
