/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCS_DATASOURCES;

import Entidades.SolicitudCredito;
import UTILIDADES.fechas;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author o-a19
 */
public class DS_CheckList implements JRDataSource {

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
            case "nombre":
                valor = listaSolicitudes.get(indice).getDatosPersonales().getNombre();
                return valor;
            case "fecha":
                valor = fechas.formatearFecha(Calendar.getInstance().getTime());
                return valor;
            case "cantidadSol":
                valor = listaSolicitudes.get(indice).getMontoRequerido();
                return valor;
            case "plazoSol":
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
            case "cuotaSol":
                valor = listaSolicitudes.get(indice).getCuota();
                return valor;
            case "pagoSol":
                if (listaSolicitudes.get(indice).getFormaPago() == 1) {
                    valor = "SEMANAL";
                } else if (listaSolicitudes.get(indice).getFormaPago() == 2) {
                    valor = "CATORCENAL";
                } else if (listaSolicitudes.get(indice).getFormaPago() == 3) {
                    valor = "MENSUAL";
                }
                return valor;
            case "cantidadAp":
                valor = listaSolicitudes.get(indice).getEvaluacionCredito().getMonto();
                return valor;
            case "cuotaAp":
                valor = listaSolicitudes.get(indice).getEvaluacionCredito().getCuota();
                return valor;
            case "pagoAp":
                if (listaSolicitudes.get(indice).getEvaluacionCredito().getFormaPago() == 1) {
                    valor = "SEMANAL";
                } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getFormaPago() == 2) {
                    valor = "CATORCENAL";
                } else if (listaSolicitudes.get(indice).getEvaluacionCredito().getFormaPago() == 3) {
                    valor = "MENSUAL";
                }
                return valor;
            case "plazoAp":
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
        }
        return valor;
    }

}
