
package MODELOSTBL;


import Entidades.Creditos;
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
public class modeloListaCreditos implements TableModel {
    
    private LinkedList<Creditos> datos = new LinkedList();
    private LinkedList listeners = new LinkedList();
    
    
    final Class[] tipoColumnas = {
        java.lang.Integer.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.String.class,
        java.lang.Integer.class,
        java.lang.Integer.class,
        java.lang.Long.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.Long.class,
        java.lang.Long.class,
        java.lang.Long.class
    };

    public modeloListaCreditos(){
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 17;
    }

    @Override
    public String getColumnName(int i) {
        String columna="";
        switch(i){
            case 0:      columna="Crédito"; 
                         break;
            case 1:      columna="Fecha Aprobación"; 
                         break;
            case 2:      columna="Nombre"; 
                         break;
            case 3:      columna="Monto Aprobado"; 
                         break;
            case 4:      columna="Descuento Asesoria"; 
                         break;
            case 5:      columna="Descuento Ref."; 
                         break;
            case 6:      columna="Descuento U.C."; 
                         break;
            case 7:      columna="Desembolso"; 
                         break;             
            case 8:      columna="Forma de Pago"; 
                         break;
            case 9:      columna="Plazo (meses)"; 
                         break;
            case 10:      columna="Cuotas"; 
                         break;
            case 11:     columna="Cuota"; 
                         break;
            case 12:    columna="tipo Crédito"; 
                         break; 
            case 13:    columna="Fecha Vencimiento"; 
                         break;
            case 14:    columna="Pago Total"; 
                         break;   
            case 15:    columna="Ganancia"; 
                         break;
            case 16:    columna="Interes Cuota"; 
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
                return fechas.formatearFecha(aux.getFechaInicio());
            case 2:
                return aux.getSolicitudCredito().getDatosPersonales().getNombre();
            case 3:
                return aux.getMonto();
            case 4:
                return monto.redondear(aux.getAsesoria()+aux.getIvaAsesoria(), 2);
            case 5:
                return descuentoref(aux);
            case 6:
                return cuotafinal(aux);
            case 7:
                return aux.getDesembolso();
            case 8:
                return formaPago(aux.getFormaPago());
            case 9:
                return aux.getPlazo();
            case 10:
                return aux.getCuotasPorPagar();
            case 11:
                return aux.getCuota(); 
            case 12:
                return tipoCredito(aux.getSolicitudCredito().getTipoCredito()); 
            case 13:
                return fechas.formatearFecha(aux.getFechaVencimiento());  
            case 14:
                return pagoTotal(aux);
            case 15:
                return ganancia(aux);
            case 16:
                return gananciaxcuota(aux);
                
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
    
    public String formaPago(int forma){
        String formapago="";
    
            switch(forma){
                case 1: formapago="semanal"; break;
                case 2: formapago="Catorcenal"; break;
                case 3: formapago="Mensual"; break;
            }
        
        
        return formapago;
    }
    
    public String tipoCredito(int tipo){
        String tipocredito="";
    
            switch(tipo){
                case 1:  tipocredito="Nuevo"; break;
                case 2:  tipocredito="Recurrente"; break;
                case 3:  tipocredito="Gestion"; break;
                case 4:  tipocredito="Refinanciamiento"; break;
                case 5:  tipocredito="Express"; break;
            }

        return  tipocredito;
    }
    
    public double pagoTotal(Creditos credito){
    
        double pagototal = credito.getMonto()+credito.getTotalIva()+credito.getTotalIntereses();
        pagototal = monto.redondear(pagototal, 2);
    
        return pagototal;
    }
    
    public double ganancia(Creditos credito){
    
        double ganancia = pagoTotal(credito)-credito.getMonto();
        ganancia = monto.redondear(ganancia, 2);
    
        return ganancia;
    }
    
    public double descuentoref(Creditos credito){
    
        double descuento = credito.getSolicitudCredito().getCapitalDes()+credito.getSolicitudCredito().getMoraDes()+credito.getSolicitudCredito().getInteresesDes(); 
        descuento = monto.redondear(descuento, 2);
    
        return descuento;
    }
    
    public double cuotafinal(Creditos credito){
    
        double cuota =0.0;       
        if(credito.getDescuentoCf()){cuota=credito.getCuota();}
        
        return cuota;
    }
    
    public double gananciaxcuota(Creditos credito){
    
        double gananciaxc = ganancia(credito)/credito.getCuotasPorPagar();       
        gananciaxc = monto.redondear(gananciaxc, 2);

        return gananciaxc;
    }
    
}
