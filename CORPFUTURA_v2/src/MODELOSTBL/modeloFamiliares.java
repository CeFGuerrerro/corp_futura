
package MODELOSTBL;

import Entidades.DatosPersonales;
import Entidades.Familiares;
import Entidades.FamiliaresPK;
import Entidades.Referencias;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author DFUENTES
 */
public class modeloFamiliares  implements TableModel{
    
    
    private LinkedList<Familiares> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();

    public modeloFamiliares() {
    }

    public LinkedList<Familiares> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Familiares> datos) {
        this.datos = datos;
    }
    
    

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int i) {
        String columna="";
        switch(i){
            case 0:      columna="parentesco"; 
                         break;
            case 1:      columna="nombre"; 
                         break;
            case 2:      columna="lugar de Trabajo"; 
                         break;
            case 3:      columna="teléfono"; 
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
       return true;
    }
    
    public void agregarFamiliar (Familiares familiar)
    {
        // Añade la persona al modelo 
        datos.add(familiar);
        // Avisa a los suscriptores creando un TableModelEvent...
        TableModelEvent evento;
        evento = new TableModelEvent (this, this.getRowCount()-1,
            this.getRowCount()-1, TableModelEvent.ALL_COLUMNS,
            TableModelEvent.INSERT);
        // ... y avisando a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void borraFamiliar (int fila)
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
        
        Familiares fam = new Familiares();
        datos.add(fam);

    }
    
    public Familiares obtenerFamiliar(int index)
    {
        return datos.get(index);
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
     
    public boolean validar(){
        boolean validacion = true;
        
        if(datos.isEmpty()){validacion=false;}
        else{
              for(Familiares fam:datos){
                  if(fam.getNombre()==null || fam.getParentesco() == null)
                  {validacion=false;}
              }
        }
        
        return validacion;
    }
    
    public List<Familiares> llenarLista(DatosPersonales dt){
   
       int i = 1;
       LinkedList<Familiares> lista = new LinkedList();
 
       for (Familiares fam : this.getDatos()) {
            FamiliaresPK fampk = new FamiliaresPK();
                        fampk.setDui(dt.getDui());
                        fampk.setId(i);
                        fam.setFamiliaresPK(fampk);
                        fam.setDatosPersonales(dt);
                        lista.add(fam);
                        i++;  
                    }
       return lista;   
    }
    
    public void llenarModelo(DatosPersonales dp){
        
        this.borrartodos();
        if (!dp.getFamiliaresList().isEmpty()) {
            for (Familiares fam : dp.getFamiliaresList()) {
                this.agregarFamiliar(fam);
            }
        }
       
    }
      
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Familiares aux;
        
        // Se obtiene la persona de la fila indicada
        aux = datos.get(rowIndex);
        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return aux.getParentesco();
            case 1:
                return aux.getNombre();
            case 2:
                return aux.getLugarTrabajo();
            case 3:
                return aux.getTelefono();
            
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Obtiene la persona de la fila indicada
        Familiares aux;
        aux = datos.get(rowIndex);
        // Cambia el campo de Persona que indica columnIndex, poniendole el 
        // aValue que se nos pasa.
        switch (columnIndex)
        {
            case 0:
                aux.setParentesco((String)aValue);
                break;
            case 1:
                aux.setNombre((String)aValue);
                break;
            case 2:
                aux.setLugarTrabajo(((String)aValue));
                break;
            case 3:
                aux.setTelefono(((String)aValue));
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
