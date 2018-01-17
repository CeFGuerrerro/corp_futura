
package UTILIDADES;

import FORMS.PANELS.LISTA_SOLICITUDES_PNL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dvid1
 */
public class archivos {
    
   
    
    private static final String ruta = System.getProperty("user.home") + "\\Desktop\\CORP_FUTURA\\PERFILES_SOLICITUDES\\";
    private static final String rutaAnalisisCredito = "src/DOCS_PLANTILLAS/Analisis_de_Credito.xlsx"; 
    
    private static void crearCarpeta(String nombre){
        
        File directorioP=new File(ruta);
        if(!directorioP.exists()){
           directorioP.mkdirs();
        }
        
        File directorio = new File(ruta+nombre);
        if(!directorio.exists()){
           directorio.mkdir();
        }
        
    }
    
    private static void copiarPlantilla(String nombre) throws FileNotFoundException, IOException{
    
        File origen = new File(rutaAnalisisCredito);
        File destino = new File(ruta+nombre+"\\Analisis_de_Credito.xlsx");
        
        if(!destino.exists()){
        
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);
        
            byte[] buf = new byte[1024];
            int len;
     
            while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
            }
    
            in.close();
            out.close();
        }
        
    }
    
    public static void crearCarpetaPerfil(String nombre) throws IOException{
        
            crearCarpeta(nombre);
            copiarPlantilla(nombre);

    }
    
    public static void copiarArchivo(File file, String nombre) throws FileNotFoundException, IOException{
    
        File origen = file;
        File destino = new File(ruta+nombre+"\\"+file.getName());
        
        InputStream in = new FileInputStream(origen);
        OutputStream out = new FileOutputStream(destino);
        
        byte[] buf = new byte[1024];
        int len;
     
        while ((len = in.read(buf)) > 0) {
           out.write(buf, 0, len);
        }
    
        in.close();
        out.close();
    }
   
    public static void ejecutarDocExcel(String nombre){
        
        String cadena = "cmd /c start "+ruta+"\""+nombre+"\"\\Analisis_de_Credito.xlsx";
       
        try {
            Runtime.getRuntime().exec(cadena);
        } catch (IOException ex) {
            Logger.getLogger(LISTA_SOLICITUDES_PNL.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static File getRootPath(String nombre){
        File file = new File(ruta+nombre);
        return file;
    }
    
    
}
