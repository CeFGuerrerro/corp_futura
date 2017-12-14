
package MODELOSTBL;

import Entidades.Codeudores;
import Entidades.CodeudoresPK;
import Entidades.DatosPersonales;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author DFUENTES
 */
public class modeloCodeudor implements TableModel{
    
    private LinkedList<DatosPersonales> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();

    public LinkedList<DatosPersonales> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<DatosPersonales> datos) {
        this.datos = datos;
    }


    public List<Codeudores> llenarLista(DatosPersonales dt){
   
       int i = 1;
       LinkedList<Codeudores> lista = new LinkedList();
 
        for (DatosPersonales dp : this.getDatos()) {
            CodeudoresPK copk = new CodeudoresPK();
            Codeudores codeudor = new Codeudores();
            codeudor.setDatosPersonales(dt);
            copk.setDui(dt.getDui());
            copk.setIdCodeudor(i);
            codeudor.setCodeudoresPK(copk);
            codeudor.setDuiCodeudor(dp);
            lista.add(codeudor);
            i++;  
        }
       return lista;   
    }
    
    
    @Override
    public int getRowCount() {
       return datos.size();
    }

    @Override
    public int getColumnCount() {
      return 3;
    }

    @Override
    public String getColumnName(int i) {
     
        String columna="";
        switch(i){
            case 0:      columna="DUI"; 
                         break;
            case 1:      columna="Nombre"; 
                         break;
            case 2:      columna="Teléfono"; 
                         break;
        }
        return columna;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return java.lang.String.class;         
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
         return false;
    }

    @Override
    public Object getValueAt(int i, int j) {
        
        DatosPersonales aux;
        aux = (DatosPersonales)(datos.get(i));

        switch (j)
        {
            case 0:
                return aux.getDui();
            case 1:
                return aux.getNombre();
            case 2:
                return aux.getTelefono();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
          // Obtiene la persona de la fila indicada
        DatosPersonales aux;
        aux = (DatosPersonales)(datos.get(rowIndex));
        // Cambia el campo de Persona que indica columnIndex, poniendole el 
        // aValue que se nos pasa.
        switch (columnIndex)
        {
            case 0:
                aux.setDui((String)aValue);
                break;
            case 1:
                aux.setNombre((String)aValue);
                break;
            case 2:
                aux.setTelefono((String)aValue);
                break;
            default:
                break;
        }  
    }
    
     private void avisaSuscriptores (TableModelEvent evento)
    {
        int i;
        for (i=0; i<listeners.size(); i++)
            ((TableModelListener)listeners.get(i)).tableChanged(evento);
    }
     
     public void agregarCodeudor (DatosPersonales dp)
    {
        // Añade la persona al modelo 
        datos.add (dp);
        // Avisa a los suscriptores creando un TableModelEvent...
        TableModelEvent evento;
        evento = new TableModelEvent (this, this.getRowCount()-1,
            this.getRowCount()-1, TableModelEvent.ALL_COLUMNS,
            TableModelEvent.INSERT);
        // ... y avisando a los suscriptores
        avisaSuscriptores (evento);
    }
     
    public void borraCodeudor(int fila)
    {
        // Se borra la fila 
        datos.remove(fila);
        // Y se avisa a los suscriptores, creando un TableModelEvent...
        TableModelEvent evento = new TableModelEvent (this, fila, fila, 
            TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        // ... y pasándoselo a los suscriptores
        avisaSuscriptores (evento);
    }
     
     
     public void borrartodos(){
        datos.clear();
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        listeners.add(tl);
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        listeners.remove(tl);
    }
    
}
