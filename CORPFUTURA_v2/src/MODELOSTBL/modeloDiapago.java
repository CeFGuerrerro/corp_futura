
package MODELOSTBL;


import CONTROLADORES.MoraJpaController;
import Entidades.Creditos;
import UTILIDADES.monto;
import java.util.LinkedList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author DFUENTES
 */
public class modeloDiapago implements TableModel {
    
    private LinkedList<Creditos> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();
    
    private MoraJpaController mjc = new MoraJpaController();
    
    final Class[] tipoColumnas = {
        java.lang.String.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class
    };

    public modeloDiapago(){
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
            case 0:      columna="Nombre"; 
                         break;
            case 1:      columna="Cuota"; 
                         break;             
            case 2:      columna="Capital"; 
                         break;
            case 3:      columna="Interes"; 
                         break;
            case 4:      columna="Iva"; 
                         break;
            case 5:      columna="Saldo Mora"; 
                         break;
            case 6:      columna="Total"; 
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
    
    public void agregarPago (Creditos credito){
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

        Creditos credito = new Creditos();
        datos.add(credito);
        
    }
    
    public Creditos obtenerPago(int index){
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
                return aux.getSolicitudCredito().getDatosPersonales().getNombre();
            case 1:
                return aux.getCuota();
            case 2:
                return monto.valorXCuota(aux.getMonto(), aux.getPlazo(), aux.getFormaPago());
            case 3:
                return monto.valorXCuota(aux.getTotalIntereses(), aux.getPlazo(), aux.getFormaPago());
            case 4:
                return monto.valorXCuota(aux.getTotalIva(), aux.getPlazo(), aux.getFormaPago());
            case 5:
                return mjc.getMontoenMora(aux);
            case 6:
                return monto.redondear((aux.getCuota()+mjc.getMontoenMora(aux)), 2);
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
