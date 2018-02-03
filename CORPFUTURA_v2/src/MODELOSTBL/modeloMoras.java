
package MODELOSTBL;


import Entidades.Creditos;
import Entidades.Mora;
import UTILIDADES.monto;
import java.util.LinkedList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author DFUENTES
 */
public class modeloMoras implements TableModel {
    private LinkedList<Mora> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();
    
    final Class[] tipoColumnas = {
        java.lang.Integer.class,
        java.lang.String.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
       
    };

    public modeloMoras(){
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
            case 1:      columna="Cliente"; 
                         break;
            case 2:      columna="Monto"; 
                         break;
            case 3:      columna="Mora Pendiente"; 
                         break;
            case 4:      columna="Mora Pagada"; 
                         break;
            case 5:      columna="Mora Total"; 
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
       return true;
    }
    
    public void agregarMora (Mora mora){
        // Añade la persona al modelo 
        datos.add (mora);
        // Avisa a los suscriptores creando un TableModelEvent...
        TableModelEvent evento;
        evento = new TableModelEvent (this, this.getRowCount()-1,
            this.getRowCount()-1, TableModelEvent.ALL_COLUMNS,
            TableModelEvent.INSERT);
        // ... y avisando a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void borrarMora(int fila){
        // Se borra la fila 
        datos.remove(fila);
        // Y se avisa a los suscriptores, creando un TableModelEvent...
        TableModelEvent evento = new TableModelEvent (this, fila, fila, 
            TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        // ... y pasándoselo a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void nuevaFila(){

        Mora mora = new Mora();
        datos.add(mora);
        
    }
    
    public Mora obtenerMora(int index){
        return (Mora)datos.get(index);
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
        Mora aux;
        
        aux = (Mora)(datos.get(rowIndex));
        switch (columnIndex)
        {
            case 0:
                return aux.getSolicitudCredito().getCreditos().getCreditosPK().getIdSolicitudCredito();
            case 1:
                return aux.getSolicitudCredito().getDatosPersonales().getNombre();
            case 2:
                return aux.getSolicitudCredito().getCreditos().getMonto();
            case 3:
                return monto.redondear(aux.getMoraTotal()-aux.getMoraCancelada(), 2);
            case 4:
                return aux.getMoraCancelada();
            case 5:
                return aux.getMoraTotal();

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
