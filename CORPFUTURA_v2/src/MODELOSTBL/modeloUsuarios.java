
package MODELOSTBL;

import Entidades.Codeudores;
import Entidades.CodeudoresPK;
import Entidades.DatosPersonales;
import Entidades.Usuarios;
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
public class modeloUsuarios implements TableModel{
    
    private LinkedList<Usuarios> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();

    final Class[] tipoColumnas = {
        java.lang.Integer.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.String.class,
    };
    
    public LinkedList<Usuarios> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Usuarios> datos) {
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
            case 0:      columna="ID"; 
                         break;
            case 1:      columna="Usuario"; 
                         break;
            case 2:      columna="Nombre"; 
                         break;
            case 3:      columna="Rol";
                         break;
            case 4:      columna="Nº de Cartera";
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

    @Override
    public Object getValueAt(int i, int j) {
        
        Usuarios aux;
        aux = (Usuarios)(datos.get(i));

        switch (j)
        {
            case 0: 
                return aux.getIdUsuario();
            case 1: 
                return aux.getUsuario();
            case 2:
                return aux.getNombre();
            case 3:
                return obtenerrol(aux);
            case 4:
                return obtenercartera(aux);
            
      
            default:
                return null;
           
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
          // Obtiene la persona de la fila indicada
        
    }
    
     private void avisaSuscriptores (TableModelEvent evento)
    {
        int i;
        for (i=0; i<listeners.size(); i++)
            ((TableModelListener)listeners.get(i)).tableChanged(evento);
    }
     
     public void agregarCodeudor (Usuarios dp)
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
    
    public String obtenerrol(Usuarios usuario){
       String cadena="";
        
       if(usuario.getRol()==0){
            cadena="Root";
        }else if(usuario.getRol()==1){
            cadena="Administrativo";
        }else if(usuario.getRol()==2){
            cadena="Asesor de Credito";
        }
        return cadena;
    } 
    
    public String obtenercartera(Usuarios usuario){
        String cadena="";
        if(usuario.getChkCartera()){
            if(usuario.getCartera()<10){
                cadena = "0"+usuario.getCartera();
            }else{
                cadena = String.valueOf(usuario.getCartera());
            }
        }
        return cadena;
    } 
    
}
