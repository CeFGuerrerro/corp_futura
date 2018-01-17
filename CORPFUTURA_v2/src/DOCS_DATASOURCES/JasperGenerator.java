/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOCS_DATASOURCES;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
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

    public void crearReporte(String nombreDoc, String nombreCli, JRDataSource dataSource) throws JRException {
        path = System.getProperty("user.home") + "\\Desktop\\CORP_FUTURA\\PERFILES_SOLICITUDES\\" + nombreCli;
        crearDirectorio(path);
        JasperDesign jasperDesign = JRXmlLoader.load(getClass().getResourceAsStream("/DOCS_PLANTILLAS/" + nombreDoc + ".jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\" + nombreDoc + ".pdf");
        JasperViewer.viewReport(jasperPrint, false);

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
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\" + nombreDoc + ".pdf");
        JasperViewer.viewReport(jasperPrint, false);

    }
}
