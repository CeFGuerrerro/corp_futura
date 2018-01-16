
package MODELOSTBL;


import Entidades.SolicitudCredito;
import java.io.File;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author DFUENTES
 */
public class modeloSolicitudes implements TableModel {
    private LinkedList<SolicitudCredito> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();
    
    final Class[] tipoColumnas = {
        java.lang.Integer.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.Long.class,
        java.lang.String.class,
    };

    public modeloSolicitudes(){
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int i) {
        String columna="";
        switch(i){
            case 0:      columna="Código"; 
                         break;
            case 1:      columna="Cartera"; 
                         break;
            case 2:      columna="Cliente"; 
                         break;
            case 3:      columna="Monto"; 
                         break;
            case 4:      columna="Estado"; 
                         break;
        }
        return columna;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return tipoColumnas[i];
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
       return false;
    }
    
    public void agregarsolicitud (SolicitudCredito solicitud){
        // Añade la persona al modelo 
        datos.add (solicitud);
        // Avisa a los suscriptores creando un TableModelEvent...
        TableModelEvent evento;
        evento = new TableModelEvent (this, this.getRowCount()-1,
            this.getRowCount()-1, TableModelEvent.ALL_COLUMNS,
            TableModelEvent.INSERT);
        // ... y avisando a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void borrasolicitud(int fila){
        // Se borra la fila 
        datos.remove(fila);
        // Y se avisa a los suscriptores, creando un TableModelEvent...
        TableModelEvent evento = new TableModelEvent (this, fila, fila, 
            TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        // ... y pasándoselo a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void nuevaFila(){

        SolicitudCredito solicitud = new SolicitudCredito();
        datos.add(solicitud);
        
    }
    
    public SolicitudCredito obtenersolicitud(int index){
        return (SolicitudCredito)datos.get(index);
    }
    
    public void borrartodos(){
        datos.clear();
    }
     
    private void avisaSuscriptores (TableModelEvent evento){
        int i;
        for (i=0; i<listeners.size(); i++)
            ((TableModelListener)listeners.get(i)).tableChanged(evento);
    }
     
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SolicitudCredito aux;
        
        aux = (SolicitudCredito)(datos.get(rowIndex));
        switch (columnIndex)
        {
            case 0:
                return aux.getSolicitudCreditoPK().getIdSolicitudCredito();
            case 1:
                return getCartera(aux);
            case 2:
                return aux.getDatosPersonales().getNombre();
            case 3:
                return aux.getMontoRequerido();
            case 4:
                return getEstado(aux);
            
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Obtiene la persona de 
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
      listeners.add (l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
      // Elimina los suscriptores.
      listeners.remove(l);
    }
    
    public String getEstado(SolicitudCredito solicitud){
        String stado="";
        if(solicitud.getEstado()==1){stado="Visita Pendiente";}
        if(solicitud.getEstado()==2){stado="Evaluacion en Proceso";}
        if(solicitud.getEstado()==3){stado="Resolucion pendiente";}
        if(solicitud.getEstado()==4){stado="Aprobado";}
        
        return stado;
    
    }
    
    public String getCartera(SolicitudCredito solicitud){
     
        String cadena="";
        String[] nombre = solicitud.getIdUsuario().getNombre().split(" ");
        
            if(solicitud.getIdUsuario().getCartera()<10){
                cadena = "0"+solicitud.getIdUsuario().getCartera();
            }else{
                cadena = String.valueOf(solicitud.getIdUsuario().getCartera());
            }
        
        cadena = cadena+" - "+nombre[0]+" "+nombre[1];
           
        return cadena;
    
    }
    
}
