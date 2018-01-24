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
import static UTILIDADES.fechas.formatearFecha;

/**
 *
 * @author o-a19
 */
public class DS_PerfilCliente implements JRDataSource {

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
                case "nombre":
                    valor = listaSolicitudes.get(indice).getDatosPersonales().getNombre();
                    return valor;
                case "monto":
                    valor = String.valueOf(listaSolicitudes.get(indice).getEvaluacionCredito().getMonto());
                    return valor;
                case "cuota":
                    valor = String.valueOf(listaSolicitudes.get(indice).getEvaluacionCredito().getCuota());
                    return valor;
                case "fpago":
                    if (listaSolicitudes.get(indice).getEvaluacionCredito().getFormaPago() == 1) {
                        valor = "SEMANAL";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getFormaPago() == 2) {
                        valor = "CATORCENAL";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getFormaPago() == 3) {
                        valor = "MENSUAL";
                    }
                    return valor;
                case "plazo":
                    if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 1) {
                        valor = "1 MES / 4 SEMANAS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 2) {
                        valor = "2 MESES / 8 SEMANAS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 3) {
                        valor = "3 MESES / 12 SEMANAS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 4) {
                        valor = "4 MESES / 16 SEMANAS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 5) {
                        valor = "5 MESES / 20 SEMANAS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 6) {
                        valor = "6 MESES / 24 SEMANAS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 7) {
                        valor = "7 MESES / 28 SEMANAS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 8) {
                        valor = "8 MESES / 32 SEMANAS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 9) {
                        valor = "9 MESES / 36 SEMANAS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 10) {
                        valor = "10 MESES / 40 SEMANAS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 11) {
                        valor = "11 MESES / 44 SEMANAS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getPlazo() == 12) {
                        valor = "12 MESES / 48 SEMANAS";
                    }
                    return valor;
                case "tasa":
                    valor = listaSolicitudes.get(indice).getTasaInteres() + " %";
                    return valor;
                case "destino":
                    if (listaSolicitudes.get(indice).getEvaluacionCredito().getSolicitudCredito().getDestinoCredito() != null) {
                        valor = listaSolicitudes.get(indice).getEvaluacionCredito().getSolicitudCredito().getDestinoCredito();
                    }
                    return valor;
                case "fondo":
                    if (listaSolicitudes.get(indice).getEvaluacionCredito().getFuentesFondos() == 1) {
                        valor = "PROPIOS";
                    } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getFuentesFondos() == 2) {
                        valor = "SALARIO";
                    }
                    return valor;
                case "justificacion":
                    if (listaSolicitudes.get(indice).getEvaluacionCredito().getJustificacion() != null) {
                        valor = listaSolicitudes.get(indice).getEvaluacionCredito().getJustificacion();
                    }
                    return valor;
                case "garantia":
                    if ((listaSolicitudes.get(indice).getEvaluacionCredito().getTipoGarantia() == 1)
                            || (listaSolicitudes.get(indice).getEvaluacionCredito().getTipoGarantia() == 3)) {
                        valor = "DECALARACION JURADA DE BIENES MUEBLES";
                    }
                    return valor;
                case "fecha":
                    valor = formatearFecha(listaSolicitudes.get(indice).getEvaluacionCredito().getFechaEvaluacion());
                    return valor;
                case "cantidadcre":
                    int cuenta = 0;
                    for (SolicitudCredito sc : listaSolicitudes.get(indice).getDatosPersonales().getSolicitudCreditoList()) {
                        if (sc.getCreditos() != null) {
                            cuenta++;
                        }
                    }
                    valor = cuenta;
                    return valor;
            }
        }
        return valor;
    }
}
