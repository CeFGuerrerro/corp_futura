
package MODELOSTBL;


import Entidades.Creditos;
import java.util.LinkedList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author DFUENTES
 */
public class modeloCreditoxCliente implements TableModel {
    private LinkedList<Creditos> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();
    
    final Class[] tipoColumnas = {
        java.lang.Integer.class,
        java.lang.String.class,
        java.lang.Long.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.String.class,

    };

    public modeloCreditoxCliente(){
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int i) {
        String columna="";
        switch(i){
            case 0:      columna="Crédito"; 
                         break;
            case 1:      columna="Tipo"; 
                         break;
            case 2:      columna="Monto Aprobado"; 
                         break;
            case 3:      columna="Tasa Interes"; 
                         break;
            case 4:      columna="Plazo(Meses)"; 
                         break;   
            case 5:      columna="Forma Pago"; 
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
    
    public void agregarCredito (Creditos credito){
        // Añade la persona al modelo 
        datos.add (credito);
        // Avisa a los suscriptores creando un TableModelEvent...
        TableModelEvent evento;
        evento = new TableModelEvent (this, this.getRowCount()-1,
            this.getRowCount()-1, TableModelEvent.ALL_COLUMNS,
            TableModelEvent.INSERT);
        // ... y avisando a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void borrarCredito(int fila){
        // Se borra la fila 
        datos.remove(fila);
        // Y se avisa a los suscriptores, creando un TableModelEvent...
        TableModelEvent evento = new TableModelEvent (this, fila, fila, 
            TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        // ... y pasándoselo a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void nuevaFila(){

        Creditos credito = new Creditos();
        datos.add(credito);
        
    }
    
    public Creditos obtenerCredito(int index){
        return (Creditos)datos.get(index);
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
        Creditos aux;
        
        aux = (Creditos)(datos.get(rowIndex));
        switch (columnIndex)
        {
            case 0:
                return aux.getCreditosPK().getIdSolicitudCredito();
            case 1:
                return cargarTipoCredito(aux.getSolicitudCredito().getTipoCredito());
            case 2:
                return aux.getMonto();
            case 3:
                return aux.getSolicitudCredito().getTasaInteres();
            case 4:
                return cargarPlazo(aux.getPlazo());
            case 5:
                return cargarFormaPago(aux.getFormaPago());
            case 6:
                return aux.getIvaPagado();
            case 7:
                return aux.getMoraPagada();
            case 8:
                return aux.getCuotasPagadas();
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      
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
    
    private String cargarTipoCredito(int tipo){
        
        String cadena="";
        
        switch(tipo){
            case 1:     cadena="Cliente Nuevo";
                        break;
            case 2:     cadena="Recurrente";
                        break;
            case 3:     cadena="Refinanciamiento";
                        break;
            case 4:     cadena="Gestion";
                        break;
            case 5:     cadena="Express";
                        break;
        }
        
        return cadena;
    }
    
    private String cargarPlazo(int plazo){
        
        String cadena= String.valueOf(plazo);
        return cadena;
    }
    
    private String cargarFormaPago(int formaPago){
        String cadena="";
        
        switch(formaPago){
            case 1:     cadena="Semanal";
                        break;
            case 2:     cadena="Catorcenal";
                        break;
            case 3:     cadena="Mensual";
                        break;
        }
        
        
        return cadena;    
    }
    
    
}
