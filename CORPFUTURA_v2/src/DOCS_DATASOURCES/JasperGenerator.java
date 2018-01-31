/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCS_DATASOURCES;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleDocxExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author o-a19
 */
public class JasperGenerator {

    String dir = null;
    String path = null;
    FileInputStream is;
    File fichero;

    public void crearReporte(String nombreDoc, String nombreCli, JRDataSource dataSource) throws JRException {
        path = System.getProperty("user.home") + "\\Desktop\\CORP_FUTURA\\PERFILES_SOLICITUDES\\" + nombreCli;
        crearDirectorio(path);
        JasperDesign jasperDesign = JRXmlLoader.load(getClass().getResourceAsStream("/DOCS_PLANTILLAS/" + nombreDoc + ".jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        
        JRPdfExporter pdfEx = new JRPdfExporter();
        pdfEx.setExporterInput(new SimpleExporterInput(jasperPrint));
        pdfEx.setExporterOutput(new SimpleOutputStreamExporterOutput(path + "\\" + nombreDoc + ".pdf"));
        
        SimplePdfExporterConfiguration config = new SimplePdfExporterConfiguration();
        pdfEx.setConfiguration(config);
        pdfEx.exportReport();        
        
        File pdf = new File(path + "\\" + nombreDoc + ".pdf");
        try {
            Desktop.getDesktop().open(pdf);
        } catch (IOException ex) {
            Logger.getLogger(JasperGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void crearDirectorio(String path) {
        fichero = new File(path);

        if (!fichero.exists()) {
            fichero.mkdir();
        }
    }

    public void crearReporteConParam(String nombreDoc, String nombreCli, Map parametros, JRDataSource dataSource) throws JRException {
        path =System.getProperty("user.home") + "\\Desktop\\CORP_FUTURA\\PERFILES_SOLICITUDES\\"+ nombreCli;
        crearDirectorio(path);
        JasperDesign jasperDesign = JRXmlLoader.load(getClass().getResourceAsStream("/DOCS_PLANTILLAS/" + nombreDoc + ".jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);
        
        JRPdfExporter pdfEx = new JRPdfExporter();
        pdfEx.setExporterInput(new SimpleExporterInput(jasperPrint));
        pdfEx.setExporterOutput(new SimpleOutputStreamExporterOutput(path + "\\" + nombreDoc + ".pdf"));
        
        SimplePdfExporterConfiguration config = new SimplePdfExporterConfiguration();
        pdfEx.setConfiguration(config);
        pdfEx.exportReport();  
        
        
        
        File pdf = new File(path + "\\" + nombreDoc + ".pdf");
        try {
            Desktop.getDesktop().open(pdf);
        } catch (IOException ex) {
            Logger.getLogger(JasperGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void crearReporteDocx(String nombreDoc, String nombreCli, JRDataSource dataSource) throws JRException {
        path = System.getProperty("user.home") + "\\Desktop\\CORP_FUTURA\\PERFILES_SOLICITUDES\\" + nombreCli;
        crearDirectorio(path);
        JasperDesign jasperDesign = JRXmlLoader.load(getClass().getResourceAsStream("/DOCS_PLANTILLAS/" + nombreDoc + ".jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        
        JRDocxExporter docEx = new JRDocxExporter();
        docEx.setExporterInput(new SimpleExporterInput(jasperPrint));
        docEx.setExporterOutput(new SimpleOutputStreamExporterOutput(path + "\\" + nombreDoc +".docx"));
        
        SimpleDocxExporterConfiguration config = new SimpleDocxExporterConfiguration();
        
        docEx.setConfiguration(config);
        docEx.exportReport();
        
        
        File docx = new File(path + "\\" + nombreDoc + ".docx");
        try {
            Desktop.getDesktop().open(docx);
        } catch (IOException ex) {
            Logger.getLogger(JasperGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
