/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCS_DATASOURCES;

import Entidades.Creditos;
import static UTILIDADES.fechas.formatearFecha;
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
public class DS_HistorialPagos implements JRDataSource {

    private List<Creditos> listaCreditos = new ArrayList<Creditos>();
    private int indice = -1;

    public void addCredito(Creditos credito) {
        this.listaCreditos.add(credito);
    }

    @Override
    public boolean next() throws JRException {
        return ++indice < listaCreditos.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        if (null != jrf.getName()) {
            switch (jrf.getName()) {
                case "idCredito":
                    valor = listaCreditos.get(indice).getCreditosPK().getIdSolicitudCredito();
                    return valor;
                case "dui":
                    valor = listaCreditos.get(indice).getSolicitudCredito().getDatosPersonales().getDui();
                    return valor;
                case "nombre":
                    valor = listaCreditos.get(indice).getSolicitudCredito().getDatosPersonales().getNombre();
                    return valor;
                case "fecha":
                    valor = formatearFecha(Calendar.getInstance().getTime());
                    return valor;
                case "monto":
                    valor = listaCreditos.get(indice).getMonto();
                    return valor;
                case "cuota":
                    valor = listaCreditos.get(indice).getCuota();
                    return valor;
                case "capitalPag":
                    valor = listaCreditos.get(indice).getSaldoPagado();
                    return valor;
                case "interesesPag":
                    valor = listaCreditos.get(indice).getInteresPagados();
                    return valor;
                case "ivaPagado":
                    valor = listaCreditos.get(indice).getIvaPagado();
                    return valor;
                case "moraPag":
                    valor = listaCreditos.get(indice).getMoraPagada();
                    return valor;
                case "cuotasCanc":
                    valor = listaCreditos.get(indice).getCuotasPagadas();
                    return valor;
                case "cuotasRes":
                    valor = listaCreditos.get(indice).getCuotasPorPagar();

            }

        }
        return valor;
    }

}
