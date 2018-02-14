package UTILIDADES;

import Entidades.Creditos;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author o-a19
 */
public class fechas {

    public static Date fechaActual() {
        Date fechaAct = new Date();
        return fechaAct;
    }

    public static boolean verificarPrimerPago(Date fechaInicio, Date fechaActual1) {

        boolean verificar = false;

        Date nuevaPrimerpago = normalizarFecha(fechaInicio);
        Date nuevaActual = normalizarFecha(fechaActual1);

        if (!nuevaPrimerpago.equals(nuevaActual)) {
            if (nuevaActual.after(nuevaPrimerpago)) {
                verificar = true;
            }
        }

        return verificar;

    }
    
    public static int numerodepagos(int formaPago, Date fechaInicio, Date fechasistema) {

        int pagos = 0;

        Date nuevaPrimerpago = normalizarFecha(fechaInicio);
        Date nuevaActual = normalizarFecha(fechasistema);

        int dias = (int) ((nuevaActual.getTime() - nuevaPrimerpago.getTime()) / 86400000);

        switch (formaPago) {
            case 1:
                pagos = dias / (7);
                break;
            case 2:
                pagos = dias / (14);
                break;
            case 3:
                pagos = dias / (28);
                break;
        }
        
        return pagos + 1;

    }
    
    public static ArrayList<String> fechasdeCuotas(Creditos credito){
    
        ArrayList cuotas = new ArrayList();
        int contador =1;
        Date fecha = new Date();
             fecha = normalizarFecha(credito.getFechaPrimerPago());
        
        while(contador<=credito.getCuotasPorPagar()){
        
            String cadena = "Cuota "+contador;
            if(contador==1){
                cadena = formatearFecha(fecha)+" \t"+cadena;
                cuotas.add(cadena);
            }else{
            
                switch (credito.getFormaPago()) {
                    case 1:
                        fecha.setTime(fecha.getTime()+(86400000*7));
                        break;
                    case 2:
                        fecha.setTime(fecha.getTime()+(86400000*14));
                        break;
                    case 3:
                        fecha.setTime(fecha.getTime()+(86400000*14));
                        fecha.setTime(fecha.getTime()+(86400000*14));
                        break;
                }
                
                cadena = formatearFecha(fecha)+" \t"+cadena;
                cuotas.add(cadena);
            
            }
            contador++;  
        }
        
        return cuotas;
    }
     
    public static ArrayList<Date> fechasxCreditos(Creditos credito){
    
        ArrayList<Date> fechas = new ArrayList();
        int contador =1;
        
        Date fecha = new Date(); 
             fecha.setTime(credito.getFechaPrimerPago().getTime());
        
        while(contador<=credito.getCuotasPorPagar()){
        
             Date fecha2 = new Date();
            
            if(contador==1){
                fecha2.setTime(fecha.getTime());
                fechas.add(fecha2);
            }else{
            
                switch (credito.getFormaPago()) {
                    case 1:
                        fecha.setTime(fecha.getTime()+(86400000*7));
                        break;
                    case 2:
                        fecha.setTime(fecha.getTime()+(86400000*14));
                        break;
                    case 3:
                        fecha.setTime(fecha.getTime()+(86400000*14));
                        fecha.setTime(fecha.getTime()+(86400000*14));
                        break;
                }
                
                fecha2.setTime(fecha.getTime());
                fechas.add(fecha2);
            
            }
            contador++;  
        }
          
        return fechas;
    }
    
    public static Date fechaVencimiento(Date fechaInicio, int formaPago, int numeroCuotas){
    
        Date fecha= normalizarFecha(fechaInicio);
        int contador = 1;
         
        while(contador<=numeroCuotas){
        
            if(contador>1){
            
                switch (formaPago) {
                    case 1:
                        fecha.setTime(fecha.getTime()+(86400000*7));
                        break;
                    case 2:
                        fecha.setTime(fecha.getTime()+(86400000*14));
                        break;
                    case 3:
                        fecha.setTime(fecha.getTime()+(86400000*14));
                        fecha.setTime(fecha.getTime()+(86400000*14));
                        break;
                }
            }
            contador++;  
        }
        
        return fecha;
    }
    
    public static Date normalizarFecha(Date fecha) {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = formato.format(fecha);

        Date nuevaFecha = null;

        try {
            nuevaFecha = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFormateada);
        } catch (Exception ex) {
        }

        return nuevaFecha;

    }

    public static boolean esLunes(Date fecha) {

        boolean verificar = false;
        Date nfecha = normalizarFecha(fecha);
        Calendar cal = Calendar.getInstance();
        cal.setTime(nfecha);
        if (cal.get(Calendar.DAY_OF_WEEK) == 2) {
            verificar = true;
        }

        return verificar;
    }

    public static boolean esLunes_miercoles(Date fecha) {

        boolean verificar = false;
        Date nfecha = normalizarFecha(fecha);
        Calendar cal = Calendar.getInstance();
        cal.setTime(nfecha);
        if (cal.get(Calendar.DAY_OF_WEEK) > 1 && cal.get(Calendar.DAY_OF_WEEK) < 5) {
            verificar = true;
        }

        return verificar;

    }

    public static String formatearFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(fecha);
    }

    public static String calcularEdad(Date birth) {
        int edad;
        Date hoy = Calendar.getInstance().getTime();
        Calendar calend = new GregorianCalendar();
        calend.set(Calendar.HOUR_OF_DAY, 0);
        calend.set(Calendar.MINUTE, 0);
        calend.set(Calendar.SECOND, 0);
        calend.set(Calendar.MILLISECOND, 0);

        calend.setTimeInMillis(hoy.getTime() - birth.getTime());

        float result = 0;
        result = calend.get(Calendar.YEAR) - 1970;
        result += (int) calend.get(Calendar.MONTH) / (float) 12;
        edad = (int) result;
        return String.valueOf(edad);
    }

}
