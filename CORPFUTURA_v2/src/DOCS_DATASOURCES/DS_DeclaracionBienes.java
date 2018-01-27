/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCS_DATASOURCES;

import Entidades.SolicitudCredito;
import UTILIDADES.fechas;
import static UTILIDADES.fechas.calcularEdad;
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
public class DS_DeclaracionBienes implements JRDataSource {
    private List<SolicitudCredito> listaSolicitudes = new ArrayList<SolicitudCredito>();
    private int indice = -1;

    @Override
    public boolean next() throws JRException {
        return ++indice < listaSolicitudes.size();
    }
    
    public void addSolicitud(SolicitudCredito solicitud){
        this.listaSolicitudes.add(solicitud);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        switch (jrf.getName()){
            case "nombre":
                valor = listaSolicitudes.get(indice).getDatosPersonales().getNombre();
                return valor;
            case "profesion":
                valor = listaSolicitudes.get(indice).getDatosPersonales().getProfesion();
                return valor;
            case "dui":
                valor = listaSolicitudes.get(indice).getDatosPersonales().getDui();
                return valor;
            case "edad":
                valor = calcularEdad(listaSolicitudes.get(indice).getDatosPersonales().getFechaNacimiento());
                return valor;
            case "fecha":
                valor = fechas.formatearFecha(Calendar.getInstance().getTime());
                return valor;
        }
        return valor;
    }
    
}
