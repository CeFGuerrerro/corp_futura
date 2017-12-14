
package MODELOSTBL;


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
public class modeloBienes implements TableModel {
    private LinkedList datos = new LinkedList();
    private LinkedList listeners = new LinkedList();
    
    final Class[] tipoColumnas = {
        java.lang.Integer.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.Long.class,
        JButton.class};

    public modeloBienes(){
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
            case 5:      columna=""; 
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
       return !(this.getColumnClass(i1).equals(JButton.class));
    }
    
    public void agregarBien (Bien bien)
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

        Bien bien = new Bien();
        datos.add(bien);
        
    }
    
    public Bien obtenerBien(int index)
    {
        return (Bien)datos.get(index);
    }
    
     public void obtenerFoto(int row){
         
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            Bien bien; 
            bien = (Bien)(datos.get(row));
            bien.getDeclaracion().setFotoBien(String.valueOf(file));
            bien.getBoton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/check.png")));
        }
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
        Bien aux;
        
        // Se obtiene la persona de la fila indicada
        aux = (Bien)(datos.get(rowIndex));
        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return aux.getDeclaracion().getCantidad();
            case 1:
                return aux.getDeclaracion().getNombre();
            case 2:
                return aux.getDeclaracion().getDescripcion();
            case 3:
                return aux.getDeclaracion().getUbicacion();
            case 4:
                return aux.getDeclaracion().getValuo();
            case 5:
                return aux.getBoton();
            
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Obtiene la persona de la fila indicada
        Bien aux;
        aux = (Bien)(datos.get(rowIndex));
        // Cambia el campo de Persona que indica columnIndex, poniendole el 
        // aValue que se nos pasa.
        switch (columnIndex)
        {
            case 0:
                aux.getDeclaracion().setCantidad(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                aux.getDeclaracion().setNombre((String)aValue);
                break;
            case 2:
                aux.getDeclaracion().setDescripcion(((String)aValue));
                break;
            case 3:
                aux.getDeclaracion().setUbicacion((String)aValue);
                break; 
            case 4:
                aux.getDeclaracion().setValuo(Double.valueOf(aValue.toString()));
                break;
            case 5:
                aux.setBoton((JButton)aValue);
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
    
}
