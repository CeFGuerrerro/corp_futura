
package UTILIDADES;



/**
 *
 * @author DFUENTES
 */
public class monto {
    
    private double monto;
    private int plazo;
    private int formaPago;
    
    private double totalIntereses;
    private double totalIva;
    private double asesoria;
    private double cuota;
    
    private double totalPago;  
    private double totalDeducciones;
    

    public monto(String monto, int plazo, int formaPago, String tasa) {
        
        this.monto = Double.parseDouble(monto);
        this.plazo = plazo;
        this.formaPago = formaPago;
        setTotalIntereses(convertirtasa(tasa));
        setTotalIva();
        setAsesoria();
        setTotalPago();
        cuota = Double.valueOf(valorXCuota(getTotalPago()));
    }
    
    public monto(){}
    
    public static double redondear(double numero,int digitos){
        int cifras=(int) Math.pow(10,digitos);
        return Math.rint(numero*cifras)/cifras;
    }
    
    public static double convertirtasa(String tasa){
        
        double tasa1 = Double.parseDouble(tasa);
        tasa1 = tasa1/100.0;
        return tasa1;
    
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
     
    public String getTotalIntereses() {
        return String.valueOf(totalIntereses);
    }
    
    public void setTotalIntereses(double tasa){
        totalIntereses = redondear((monto*tasa*plazo),2);
           
    }
    
    public String getTotalIva(){
        return String.valueOf(totalIva);
      
    }
    
    public void setTotalIva(){
        totalIva = redondear((totalIntereses*0.13),2);
           
    }
    
    public String getAsesoria(){
        return String.valueOf(asesoria);
        
    }
    
    public void setAsesoria(){    
        asesoria=0.0;
        if(monto<350){ asesoria=5.65;}
        else if(monto<550){asesoria=11.30;}
        else{asesoria=16.95;}
           
    }
    
    public String getTotalPago() {
        return String.valueOf(totalPago);
    }

    public void setTotalPago() {
        this.totalPago = monto+totalIntereses+totalIva;
    }
          
    public String getCuota() {
        return String.valueOf(cuota);
    }

    public String valorXCuota(String monto1){
        String cuota ="";
            
           double monto = Double.valueOf(monto1);
           
           switch(formaPago){
               case 1:     monto = monto/(4*plazo);
                           monto = redondear(monto,2);
                           break;
               case 2:     monto = monto/(2*plazo);
                           monto = redondear(monto,2);
                           break;
               case 3:     monto = monto/plazo;
                           monto = redondear(monto,2);
                           break;
           }
        
           cuota = String.valueOf(monto);
           
        return cuota;
    }
    
    public static double valorXCuota(double monto,int plazo,int formaPago){
       
           switch(formaPago){
               case 1:     monto = monto/(4*plazo);
                           monto = redondear(monto,2);
                           break;
               case 2:     monto = monto/(2*plazo);
                           monto = redondear(monto,2);
                           break;
               case 3:     monto = monto/plazo;
                           monto = redondear(monto,2);
                           break;
           }
           
        return monto;
    }
    
    public int numeroCuotas(){
        int cuotas=0;
        switch(formaPago){
               case 1:     cuotas = (4*plazo);
                           break;
               case 2:     cuotas = (2*plazo);
                           break;
               case 3:     cuotas = plazo;
                           break;
        }
        return cuotas;
    }
    
    public String getTotalDeducciones() {
        return String.valueOf(totalDeducciones);
    }
   
    public void settotalDeducciones(boolean asesoria1, boolean cuota1, String intereses,String capital, String mora){
        totalDeducciones=0.0;
        Double intereses1,capital1,mora1;
        if(asesoria1){totalDeducciones+=asesoria;}
        if(cuota1){totalDeducciones+=cuota;}
        try{intereses1=Double.parseDouble(intereses);}catch(NumberFormatException ex){intereses1=0.0;}
        try{capital1=Double.parseDouble(capital);}catch(NumberFormatException ex){capital1=0.0;}
        try{mora1=Double.parseDouble(mora);}catch(NumberFormatException ex){mora1=0.0;}
        totalDeducciones=totalDeducciones+intereses1+capital1+mora1;
        totalDeducciones = redondear(totalDeducciones,2);         
    }

    public String getMontoRecibir(){
        Double monto=this.monto;
        monto= this.monto-totalDeducciones;
        monto= redondear(monto,2);
        return String.valueOf(monto);
    }
 
    public String getMontoaPagar(){
        Double total=totalPago;
        total = redondear(total,2);         
        return String.valueOf(total);
    }
    
    public static boolean validarDouble(String cadena){
    
        boolean cumple=true;
        try{
            double decimal = Double.parseDouble(cadena);
        }catch(Exception ex){cumple=false;}
        return cumple;
    }
    
    
    
    

}
