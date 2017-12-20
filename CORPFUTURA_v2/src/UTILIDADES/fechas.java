
package utilidades;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author o-a19
 */
public class fechas {

    public static Integer calcularEdad(Date fecha) {
        
        Calendar fechaNacimiento = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();
        fechaNacimiento.setTime(fecha);
        int año = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        int mes = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE) - fechaNacimiento.get(Calendar.DATE);
        if (mes < 0 || (mes == 0 && dia < 0)) {
            año--;
        }
        return año;
    }
    
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
        
        
}
