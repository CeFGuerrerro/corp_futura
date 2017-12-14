
package MODELOSTBL;
import Entidades.DatosPersonales;
import Entidades.Familiares;
import Entidades.FamiliaresPK;
import Entidades.Referencias;
import Entidades.ReferenciasPK;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author DFUENTES
 */
public class modeloReferencias  implements TableModel{
    
    
    private LinkedList<Referencias> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();

    public modeloReferencias() {
    }

    public LinkedList<Referencias> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Referencias> datos) {
        this.datos = datos;
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
            case 0:      columna="parentesco"; 
                         break;
            case 1:      columna="nombre"; 
                         break;
            case 2:      columna="empresa"; 
                         break;
            case 3:      columna="dirección"; 
                         break;
            case 4:      columna="teléfono"; 
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
    
    public void agregarReferencia (Referencias ref)
    {
        // Añade la persona al modelo 
        datos.add (ref);
        // Avisa a los suscriptores creando un TableModelEvent...
        TableModelEvent evento;
        evento = new TableModelEvent (this, this.getRowCount()-1,
            this.getRowCount()-1, TableModelEvent.ALL_COLUMNS,
            TableModelEvent.INSERT);
        // ... y avisando a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public void borrarReferencia (int fila)
    {
        // Se borra la fila 
        datos.remove(fila);
        // Y se avisa a los suscriptores, creando un TableModelEvent...
        TableModelEvent evento = new TableModelEvent (this, fila, fila, 
            TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        // ... y pasándoselo a los suscriptores
        avisaSuscriptores (evento);
    }
    
    public Referencias obtenerReferencias(int index)
    {
        return datos.get(index);
    }
    
    private void avisaSuscriptores (TableModelEvent evento)
    {
        int i;
        for (i=0; i<listeners.size(); i++)
            ((TableModelListener)listeners.get(i)).tableChanged(evento);
    }
     
    public void nuevaFila(){
        Referencias ref = new Referencias();
        datos.add(ref);
    }
    
    public void borrartodos(){
        datos.clear();
    }
    
    public boolean validar(){
        
        boolean validacion = true;
        
        if(datos.isEmpty()){validacion=false;}
        else{
              for(Referencias ref:datos){
                  if(ref.getNombre() == null || ref.getParentesco() == null)
                  {validacion=false;}
              }
        }
        
        return validacion;
    }
    
    public List<Referencias> llenarlista(int contador, DatosPersonales dt,boolean tipoRef){
        
        List<Referencias> refs = new LinkedList();
        int cont=contador;
        for (Referencias ref : this.getDatos()) {
                    ReferenciasPK refpk = new ReferenciasPK();
                        refpk.setDui(dt.getDui());
                        refpk.setId(cont);
                        ref.setReferenciasPK(refpk);
                        ref.setDatosPersonales(dt);
                        ref.setTipoReferencia(tipoRef);
                        refs.add(ref);
                        cont++;   
                    }
        return refs;
    }
    
    
    public int llenarModelo(DatosPersonales dp, boolean tipo){
        int contador=0;
        this.borrartodos();
        if (!dp.getReferenciasList().isEmpty()) {
            for (Referencias ref : dp.getReferenciasList()) {
                if (ref.getTipoReferencia() == tipo) {
                   this.agregarReferencia(ref);
                   contador++;
                } 
            }
        }
        return contador;
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Referencias aux;
        // Se obtiene la persona de la fila indicada
        aux = (datos.get(rowIndex));
        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return aux.getParentesco();
            case 1:
                return aux.getNombre();
            case 2:
                return aux.getEmpresa();
            case 3:
                return aux.getDireccion();
            case 4:
                return aux.getTelefono();
            
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Obtiene la persona de la fila indicada
        Referencias aux;
        aux = (datos.get(rowIndex));
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
                aux.setEmpresa((String)aValue);
                break;
            case 3:
                aux.setDireccion((String)aValue);
                break;
            case 4:
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
    
      listeners.remove(l);
    }
    
    
        
}
