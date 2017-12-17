
package MODELOSTBL;


import Entidades.Codeudores;
import Entidades.CodeudoresPK;
import Entidades.DatosPersonales;
import Entidades.DeclaracionBienes;
import Entidades.DeclaracionBienesPK;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author DFUENTES
 */
public class modeloBienes implements TableModel {
    private LinkedList<DeclaracionBienes> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();
    
    final Class[] tipoColumnas = {
        java.lang.Integer.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.Double.class,
        java.lang.Double.class,};

    public modeloBienes(){
    }
    
    public LinkedList<DeclaracionBienes> getDatos() {
        return datos;
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
            case 0:      columna="Cantidad"; 
                         break;
            case 1:      columna="Bien mueble en Garantia"; 
                         break;
            case 2:      columna="Descripción"; 
                         break;
            case 3:      columna="Ubicación"; 
                         break;
            case 4:      columna="Valuo"; 
                         break;
            case 5:      columna="Total"; 
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
       return !(i1==5);
    }
    
    public void agregarBien (DeclaracionBienes bien)
    {
        // Añade la persona al modelo 
        datos.add (bien);
        // Avisa a los suscriptores creando un TableModelEvent...
        TableModelEvent evento;
        evento = new TableModelEvent (this, this.getRowCount()-1,
            this.getRowCount()-1, TableModelEvent.ALL_COLUMNS,
            TableModelEvent.INSERT);
        // ... y avisando a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void borraBien(int fila)
    {
        // Se borra la fila 
        datos.remove(fila);
        // Y se avisa a los suscriptores, creando un TableModelEvent...
        TableModelEvent evento = new TableModelEvent (this, fila, fila, 
            TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        // ... y pasándoselo a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void nuevaFila(){

        DeclaracionBienes bien = new DeclaracionBienes();
        datos.add(bien);
        
    }
    
    public DeclaracionBienes obtenerBien(int index)
    {
        return (DeclaracionBienes)datos.get(index);
    }
    
    public void borrartodos(){
        datos.clear();
    }
     
     private void avisaSuscriptores (TableModelEvent evento)
    {
        int i;
        for (i=0; i<listeners.size(); i++)
            ((TableModelListener)listeners.get(i)).tableChanged(evento);
    }
     
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DeclaracionBienes aux;
        
        // Se obtiene la persona de la fila indicada
        aux = (DeclaracionBienes)(datos.get(rowIndex));
        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return aux.getCantidad();
            case 1:
                return aux.getNombre();
            case 2:
                return aux.getDescripcion();
            case 3:
                return aux.getUbicacion();
            case 4:
                return aux.getValuo();
            case 5:
                return aux.getTotalGarantia();
            
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Obtiene la persona de la fila indicada
        DeclaracionBienes aux;
        aux = (DeclaracionBienes)(datos.get(rowIndex));
        // Cambia el campo de Persona que indica columnIndex, poniendole el 
        // aValue que se nos pasa.
        switch (columnIndex)
        {
            case 0:
                aux.setCantidad(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                aux.setNombre((String)aValue);
                break;
            case 2:
                aux.setDescripcion(((String)aValue));
                break;
            case 3:
                aux.setUbicacion((String)aValue);
                break; 
            case 4:
                aux.setValuo(Double.valueOf(aValue.toString()));
                break;
            case 5:
                aux.setTotalGarantia(Double.valueOf(aValue.toString()));
                break;
            default:
                break;
        }  
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
    
    public List<DeclaracionBienes> llenarLista(DatosPersonales dt){
   
       int i = 1;
       LinkedList<DeclaracionBienes> lista = new LinkedList();
 
        for (DeclaracionBienes bien : this.getDatos()) {
            
            bien.setTotalGarantia(bien.getValuo()*bien.getCantidad());
            
            DeclaracionBienesPK bienpk = new DeclaracionBienesPK();
            bienpk.setDui(dt.getDui());
            bienpk.setIdBien(i);
            bien.setDeclaracionBienesPK(bienpk);
            bien.setDatosPersonales(dt);

            lista.add(bien);
            i=i+1;  
        }
       return lista;   
    }
    
    public String cargarTotales(){
        
        double total=0;
        for(DeclaracionBienes bien:datos){ 
            if(bien.getCantidad()!=null && bien.getValuo()!=null){
                bien.setTotalGarantia(bien.getValuo()*bien.getCantidad());
                total+=bien.getTotalGarantia();
            }
        }
        return String.valueOf(total);
    }
    
    
    
    
}
