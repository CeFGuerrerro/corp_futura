
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
    
    private  void copiarPlantilla(String nombre) throws FileNotFoundException, IOException{
        
        File destino = new File(ruta+nombre+"\\AnalisisCredito1.xlsx");
        
        if(!destino.exists()){
        
            InputStream in = getClass().getResourceAsStream("AnalisisCreditos.xlsx");
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
    
    public void crearCarpetaPerfil(String nombre) throws IOException{
        
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
   
    public static void abrirCarpetaCliente(String nombre){
        
        String cadena = "cmd /c explorer "+ruta+"\""+nombre+"\"";
       
        try {
            Runtime.getRuntime().exec(cadena);
        } catch (IOException ex) {
            Logger.getLogger(LISTA_SOLICITUDES_PNL.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
}
