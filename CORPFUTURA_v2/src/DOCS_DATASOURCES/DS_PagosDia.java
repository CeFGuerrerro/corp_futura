/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCS_DATASOURCES;

import CONTROLADORES.MoraJpaController;
import Entidades.Creditos;
import static UTILIDADES.monto.valorXCuota;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author o-a19
 */
public class DS_PagosDia implements JRDataSource {

    private int indice = -1;
    private List<Creditos> listaCreditos = new ArrayList<Creditos>();
    private MoraJpaController mjc = new MoraJpaController();

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
                case "nombre":
                    valor = listaCreditos.get(indice).getSolicitudCredito().getDatosPersonales().getNombre();
                    return valor;
                case "cuota":
                    valor = listaCreditos.get(indice).getCuota();
                    return valor;
                case "capital":
                    valor = valorXCuota(listaCreditos.get(indice).getMonto(), listaCreditos.get(indice).getPlazo(), listaCreditos.get(indice).getFormaPago());
                    return valor;
                case "intereses":
                    valor = valorXCuota(listaCreditos.get(indice).getTotalIntereses(), listaCreditos.get(indice).getPlazo(), listaCreditos.get(indice).getFormaPago());
                    return valor;
                case "iva":
                    valor = valorXCuota(listaCreditos.get(indice).getTotalIva(), listaCreditos.get(indice).getPlazo(), listaCreditos.get(indice).getFormaPago());
                    return valor;
                case "saldoMora":
                    valor = mjc.getMontoenMora(listaCreditos.get(indice));
                    return valor;
                case "total":
                    valor = mjc.getMontoenMora(listaCreditos.get(indice)) + listaCreditos.get(indice).getCuota();
                    return valor;
            }
        }
        return valor;
    }

}
