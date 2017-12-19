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
            switch(jrf.getName()){
                case "observaciones":
                    if(listaSolicitudes.get(indice).getObservacion() != null){
                    valor = listaSolicitudes.get(indice).getObservacion();
                    return valor;}
            }
        return valor;
        
    }
    
}
