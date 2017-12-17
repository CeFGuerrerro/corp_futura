/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCS_DATASOURCES;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author o-a19
 */
public class JasperGenerator {
    
    String dir = null;
    String path = null;
    FileInputStream is;
    File fichero;
    
    public void crearReporte(String nombreDoc, String nombreCli, JRDataSource dataSource) throws JRException{
        try{
            path = System.getProperty("user.home") + "\\Desktop\\" + nombreCli;
            fichero = new File(path);
            dir = System.getProperty("user.dir") + "\\src\\DOCS_PLANTILLAS\\" + nombreDoc+".jrxml";
            is = new FileInputStream(dir);
            
            if(!fichero.exists()){
                fichero.mkdir();
            }
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\"+nombreDoc+".pdf");
            JasperViewer.viewReport(jasperPrint,false);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el fichero de carga: " + ex.getMessage());
        }
        
    }
}
