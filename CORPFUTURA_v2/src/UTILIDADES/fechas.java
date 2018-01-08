package UTILIDADES;

import java.text.SimpleDateFormat;
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

    public static int numerodepagos(int formaPago, Date fechaInicio, boolean primercuota, Date fechasistema) {

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

    public static int numeroSemanas(Date actual, Date inicio) {

        int semanas = 0;

        Date nuevaActual = normalizarFecha(actual);
        Date nuevainicio = normalizarFecha(inicio);

        int dias = (int) ((nuevaActual.getTime() - nuevainicio.getTime()) / 86400000);
        semanas = (dias / 7) + 1;

        return semanas;
    }

    public static boolean mismaSemana(Date actual, Date cancelacion) {

        boolean misma = true;

        Date nuevaActual = normalizarFecha(actual);
        Date nuevacancelacion = normalizarFecha(cancelacion);

        Calendar factual = Calendar.getInstance();
        Calendar fcancelacion = Calendar.getInstance();

        factual.setTime(nuevaActual);
        fcancelacion.setTime(nuevacancelacion);

        if (factual.get(Calendar.WEEK_OF_YEAR) != fcancelacion.get(Calendar.WEEK_OF_YEAR)) {
            misma = false;
        }

        return misma;
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

    public static boolean esLunes() {

        boolean verificar = false;

        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaActual());
        if (cal.get(Calendar.DAY_OF_WEEK) == 2) {
            verificar = true;
        }

        return verificar;
    }

    public static boolean esLunes_Jueves() {

        boolean verificar = false;

        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaActual());
        if (cal.get(Calendar.DAY_OF_WEEK) > 1 && cal.get(Calendar.DAY_OF_WEEK) < 6) {
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
