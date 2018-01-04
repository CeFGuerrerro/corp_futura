
package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author o-a19
 */
public class fechas {
    
    public static Date fechaActual(){
         Date fechaAct = new Date();
         return fechaAct;
    }
    
    public static boolean verificarPrimerPago(Date fechaInicio, Date fechaActual1){
    
        boolean verificar=false;
        Calendar fechaActual = Calendar.getInstance();  fechaActual.setTime(fechaActual1);
        Calendar PrimerPago = Calendar.getInstance(); PrimerPago.setTime(fechaInicio);

        if(PrimerPago.after(fechaActual) || PrimerPago==fechaActual){
            verificar=true;
        }
       
        return verificar;

    }
    
    public static String formatearFecha(Date fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

}
