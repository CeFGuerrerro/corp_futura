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
public class DS_ResolucionComite implements JRDataSource {

    private List<SolicitudCredito> listaSolicitudes = new ArrayList<SolicitudCredito>();
    private int indice = -1;

    @Override
    public boolean next() throws JRException {
        return ++indice < listaSolicitudes.size();
    }

    public void addResolucion(SolicitudCredito solicitud) {
        this.listaSolicitudes.add(solicitud);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        switch (jrf.getName()) {
            case "clinuevo":
                if (listaSolicitudes.get(indice).getTipoCredito() == 1) {
                    valor = "X";

                }
                return valor;
            case "recu":
                if (listaSolicitudes.get(indice).getTipoCredito() == 2) {
                    valor = "X";

                }
                return valor;
            case "refi":
                if (listaSolicitudes.get(indice).getTipoCredito() == 4) {
                    valor = "X";

                }
                return valor;
            case "exp":
                if (listaSolicitudes.get(indice).getTipoCredito() == 5) {
                    valor = "X";

                }
                return valor;
            case "nombrecliente":
                valor = listaSolicitudes.get(indice).getDatosPersonales().getNombre();
                return valor;
            case "fecha":
                valor = formatearFecha(listaSolicitudes.get(indice).getCreditos().getFechaInicio());
                return valor;
            case "resolucion":
                if (listaSolicitudes.get(indice).getEstado() == 4) {
                    valor = "APROBAR";
                } else if (listaSolicitudes.get(indice).getEstado() == 5) {
                    valor = "DENEGAR";
                }
                return valor;
            case "monto":
                valor = listaSolicitudes.get(indice).getCreditos().getMonto();
                return valor;
            case "tipocredito":
                if (listaSolicitudes.get(indice).getTipo() == 0) {
                    valor = "COMERCIAL";
                } else if (listaSolicitudes.get(indice).getTipo() == 1) {
                    valor = "EMPLEADO";
                }

            case "destino":
                valor = listaSolicitudes.get(indice).getDestinoCredito();
                return valor;
            case "plazo":
                if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 1) {
                    valor = "1 MES / 4 SEMANAS";
                } else if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 2) {
                    valor = "2 MESES / 8 SEMANAS";
                } else if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 3) {
                    valor = "3 MESES / 12 SEMANAS";
                } else if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 4) {
                    valor = "4 MESES / 16 SEMANAS";
                } else if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 5) {
                    valor = "5 MESES / 20 SEMANAS";
                } else if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 6) {
                    valor = "6 MESES / 24 SEMANAS";
                } else if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 7) {
                    valor = "7 MESES / 28 SEMANAS";
                } else if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 8) {
                    valor = "8 MESES / 32 SEMANAS";
                } else if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 9) {
                    valor = "9 MESES / 36 SEMANAS";
                } else if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 10) {
                    valor = "10 MESES / 40 SEMANAS";
                } else if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 11) {
                    valor = "11 MESES / 44 SEMANAS";
                } else if (listaSolicitudes.get(indice).getCreditos().getPlazo() == 12) {
                    valor = "12 MESES / 48 SEMANAS";
                }
                return valor;
            case "tasa":
                valor = "9%";
                return valor;
            case "tipogarantia":
                if (listaSolicitudes.get(indice).getEvaluacionCredito().getTipoGarantia() == 1) {
                    valor = "CODEUDORES/PRENDARIA";
                } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getTipoGarantia() == 2) {
                    valor = "CODEUDORES";
                } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getTipoGarantia() == 3) {
                    valor = "PRENDARIA";
                }
                return valor;
            case "descripciongarantia":
                if (listaSolicitudes.get(indice).getEvaluacionCredito().getTipoGarantia() == 1) {
                    valor = "CODEUDORES SOLIDARIOS Y DECLARACION JURADA DE BIENES MUEBLES";
                } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getTipoGarantia() == 2) {
                    valor = "CODEUDORES SOLIDARIOS";
                } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getTipoGarantia() == 3) {
                    valor = "DECLARACION JURADA DE BIENES MUEBLES";
                }
                return valor;
            case "fuentefondos":
                if (listaSolicitudes.get(indice).getEvaluacionCredito().getFuentesFondos() == 1) {
                    valor = "PROPIOS";
                } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getFuentesFondos() == 2) {
                    valor = "SALARIO";
                }
                return valor;
            case "cuota":
                valor = listaSolicitudes.get(indice).getCreditos().getCuota();
                return valor;
            case "formapago":
                if (listaSolicitudes.get(indice).getCreditos().getFormaPago() == 1) {
                    valor = "SEMANAL";
                } else if (listaSolicitudes.get(indice).getCreditos().getFormaPago() == 2) {
                    valor = "CATORCENAL";
                } else if (listaSolicitudes.get(indice).getCreditos().getFormaPago() == 3) {
                    valor = "MENSUAL";
                }
                return valor;
            case "otrascondiciones":
                if (listaSolicitudes.get(indice).getCreditos().getCuotaFinal() != null) {
                    valor = "DESCUENTO DE LA ULTIMA CUOTA";
                }
                return valor;
            case "cantidadaprobada":
                valor = listaSolicitudes.get(indice).getCreditos().getMonto();
                return valor;
            case "asesoria":
                valor = listaSolicitudes.get(indice).getCreditos().getAsesoria();
                return valor;
            case "ivaase":
                valor = listaSolicitudes.get(indice).getCreditos().getIvaAsesoria();
                return valor;
            case "cuotafinal":
                valor = listaSolicitudes.get(indice).getCreditos().getCuotaFinal();
                return valor;
            case "ivacuota":
                valor = listaSolicitudes.get(indice).getCreditos().getIvaCuotaFinal();
                return valor;
            case "capital":
                valor = listaSolicitudes.get(indice).getCapitalDes();
                return valor;
            case "intereses":
                valor = listaSolicitudes.get(indice).getInteresesDes();
                return valor;
            case "mora":
        }

        return valor;
    }
}
