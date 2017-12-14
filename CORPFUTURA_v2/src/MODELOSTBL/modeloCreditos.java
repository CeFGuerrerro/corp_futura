
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
public class modeloCreditos implements TableModel {
    private LinkedList<Creditos> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();
    
    final Class[] tipoColumnas = {
        java.lang.Integer.class,
        java.lang.String.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Integer.class
    };

    public modeloCreditos(){
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int i) {
        String columna="";
        switch(i){
            case 0:      columna="Crédito"; 
                         break;
            case 1:      columna="Cliente"; 
                         break;
            case 2:      columna="Monto Aprobado"; 
                         break;
            case 3:      columna="Capital Pagado"; 
                         break;
            case 4:      columna="Capital Pendiente"; 
                         break;
            case 5:      columna="Intereses Pagados"; 
                         break;
            case 6:      columna="Mora Pagada"; 
                         break;
            case 7:      columna="Cuotas Pagadas"; 
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
                return aux.getSolicitudCredito().getDatosPersonales().getNombre();
            case 2:
                return aux.getMonto();
            case 3:
                return aux.getSaldoPagado();
            case 4:
                return aux.getSaldoRestante();
            case 5:
                return aux.getInteresPagados();
            case 6:
                return aux.getMoraPagada();
            case 7:
                return 0;
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
