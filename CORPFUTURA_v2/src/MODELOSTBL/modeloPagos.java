
package MODELOSTBL;


import Entidades.Creditos;
import Entidades.Pagos;
import UTILIDADES.fechas;
import UTILIDADES.monto;
import java.util.LinkedList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author DFUENTES
 */
public class modeloPagos implements TableModel {
    private LinkedList<Pagos> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();
    
    final Class[] tipoColumnas = {
        java.lang.String.class,
        java.lang.String.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
    };

    public modeloPagos(){
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int i) {
        String columna="";
        switch(i){
            case 0:      columna="Fecha"; 
                         break;
            case 1:      columna="Factura"; 
                         break;
            case 2:      columna="Capital"; 
                         break;
            case 3:      columna="Intereses"; 
                         break;
            case 4:      columna="IVA Intereses"; 
                         break;
            case 5:      columna="Mora"; 
                         break;
            case 6:      columna="IVA Mora"; 
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
    
    public void agregarPago (Pagos pago){
        // Añade la persona al modelo 
        datos.add (pago);
        // Avisa a los suscriptores creando un TableModelEvent...
        TableModelEvent evento;
        evento = new TableModelEvent (this, this.getRowCount()-1,
            this.getRowCount()-1, TableModelEvent.ALL_COLUMNS,
            TableModelEvent.INSERT);
        // ... y avisando a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void borrarPago(int fila){
        // Se borra la fila 
        datos.remove(fila);
        // Y se avisa a los suscriptores, creando un TableModelEvent...
        TableModelEvent evento = new TableModelEvent (this, fila, fila, 
            TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        // ... y pasándoselo a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void nuevaFila(){

        Pagos pago = new Pagos();
        datos.add(pago);
        
    }
    
    public Pagos obtenerPago(int index){
        return (Pagos)datos.get(index);
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
        Pagos aux;
        
        aux = (Pagos)(datos.get(rowIndex));
        switch (columnIndex)
        {
            case 0:
                return fechas.formatearFecha(aux.getFechaPago());
            case 1:
                return aux.getNumFactura();
            case 2:
                return aux.getCapitalAbonado();
            case 3:
                return aux.getInteres();
            case 4:
                return aux.getIvaIntereses();
            case 5:
                return aux.getMora();
            case 6:
                return aux.getIvaMora();
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
    
    
}
