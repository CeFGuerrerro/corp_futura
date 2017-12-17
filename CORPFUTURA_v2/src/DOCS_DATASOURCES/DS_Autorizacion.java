/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCS_DATASOURCES;

import Entidades.DatosPersonales;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author o-a19
 */
public class DS_Autorizacion implements JRDataSource {
    
    private final List<DatosPersonales> listaDatos = new ArrayList<DatosPersonales>();
    private int indice = -1;
    
     public void addDatosPersonales(DatosPersonales datos){
        this.listaDatos.add(datos);
    }

    @Override
    public boolean next() throws JRException {
        return ++indice < listaDatos.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        if(null != jrf.getName()) switch (jrf.getName()){
            case "nombre":
                valor = listaDatos.get(indice).getNombre();
                return valor;
            case "dui":
                valor = listaDatos.get(indice).getDui();
                return valor;
        }
        return valor;
    }
    
    
}
