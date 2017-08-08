/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.its.ct.gestionaleOP.report;

import it.bysoftware.ct.model.CessioneCredito;
import it.its.ct.gestionaleOP.utils.DocumentType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author mario
 */
public class Report {

    public static String DB_PASSWORD = "sistemi";

    public static String DB_URL = "jdbc:sqlserver://192.168.196.1\\sqlexpress:1433;DatabaseName=FRUTTAPIU";

    public static String DB_USERNAME = "sa";

    public static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static String JASPER_FILENAME = "ddt";

    public static String JASPER_REPORT_FOLDER = "/home/mario/ITS/";

    public String print(int year, int nDoc, int idAssociato, long idOp)
            throws ClassNotFoundException, JRException, SQLException {
        Map<String, Object> parametersMap = new HashMap<String, Object>();
        parametersMap.put("WkNOrd", nDoc);
        parametersMap.put("idAssociato", idAssociato);
        parametersMap.put("tipoDocumento", DocumentType.DDT.name());
        parametersMap.put("year", year);

        // caricamento file JRXML

        JasperDesign jasperDesign = JRXmlLoader.load(JASPER_REPORT_FOLDER
                + idOp + "/" + JASPER_FILENAME + ".jrxml");

        // compilazione del file e generazione del file JASPER

        JasperCompileManager
                .compileReportToFile(jasperDesign, JASPER_REPORT_FOLDER + idOp
                        + "/" + JASPER_FILENAME + ".jasper");

        // inizializzazione connessione al database

        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME,
                DB_PASSWORD);

        // rendering e generazione del file PDF

        JasperPrint jp = JasperFillManager
                .fillReport(JASPER_REPORT_FOLDER + idOp + "/" + JASPER_FILENAME
                        + ".jasper", parametersMap, conn);
        JasperExportManager.exportReportToPdfFile(jp, "/tmp/" + "ddt_"
                + idAssociato + ".pdf");

        conn.close();
        return "/tmp/ddt_" + idAssociato + ".pdf";
    }

    public String print(int year, int nDoc, int idAssociato,
            String tipoDocumento, long idOp) throws JRException,
            ClassNotFoundException, SQLException {

        return print(year, nDoc, idAssociato, tipoDocumento, idOp, false, "");
    }

    public String print(int year, int nDoc, int idAssociato,
            String tipoDocumento, long idOp, boolean toOp, String logo)
            throws ClassNotFoundException, JRException, SQLException {
        String reportFile = !toOp ? tipoDocumento : tipoDocumento + "2op";
        Map<String, Object> parametersMap = new HashMap<String, Object>();
        parametersMap.put("WkNOrd", nDoc);
        parametersMap.put("idAssociato", idAssociato);
        String nomePDF = tipoDocumento;

        if ((tipoDocumento.equals("ddt") && toOp)
                || tipoDocumento.equals("dda")) {
            reportFile = "ddt2op";
            nomePDF = DocumentType.DDA.name();
            parametersMap.put("tipoDocumento", DocumentType.DDA.name()); // I

            // DDT
            // per
            // vendita
            // diretta
            // a OP
            // sono
            // di
            // tipo
            // DDA

        } else if ((tipoDocumento.equals("fac") && toOp)) {
            reportFile = "fav2op";
            parametersMap.put("tipoDocumento", tipoDocumento.toUpperCase());
        } else {
            parametersMap.put("tipoDocumento", tipoDocumento.toUpperCase());
        }

        parametersMap.put("year", year);

        if (!logo.equals(""))
            parametersMap.put("logo", logo);

        // caricamento file JRXML

        JasperDesign jasperDesign = JRXmlLoader.load(JASPER_REPORT_FOLDER
                + idOp + "/" + reportFile + ".jrxml");

        // compilazione del file e generazione del file JASPER

        JasperCompileManager.compileReportToFile(jasperDesign,
                JASPER_REPORT_FOLDER + idOp + "/" + reportFile + ".jasper");

        if (reportFile.equals("fav")) {
            jasperDesign = JRXmlLoader.load(JASPER_REPORT_FOLDER + idOp
                    + "/castelletto_iva.jrxml");
            JasperCompileManager.compileReportToFile(jasperDesign,
                    JASPER_REPORT_FOLDER + idOp + "/castelletto_iva.jasper");
        }

        // inizializzazione connessione al database

        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME,
                DB_PASSWORD);

        // rendering e generazione del file PDF

        JasperPrint jp = JasperFillManager.fillReport(JASPER_REPORT_FOLDER
                + idOp + "/" + reportFile + ".jasper", parametersMap, conn);
        JasperExportManager.exportReportToPdfFile(jp, "/tmp/" + nomePDF + "_"
                + idAssociato + ".pdf");
        conn.close();
        return "/tmp/" + nomePDF + "_" + idAssociato + ".pdf";
    }

    public String printTrace(int anno, int nDoc, int idAssociato,
            String tipoDocumento, long idOp) throws JRException,
            ClassNotFoundException, SQLException {
        Map<String, Object> parametersMap = new HashMap<String, Object>();

        parametersMap.put("ANNO", anno);
        parametersMap.put("N_DOC", nDoc);
        parametersMap.put("ID_ASSOCIATO", idAssociato);

        // caricamento file JRXML
        JasperDesign jasperDesign = JRXmlLoader.load(JASPER_REPORT_FOLDER
                + idOp + "/" + "tracciabilita.jrxml");
        // compilazione del file e generazione del file JASPER
        JasperCompileManager.compileReportToFile(jasperDesign,
                JASPER_REPORT_FOLDER + idOp + "/" + "tracciabilita.jasper");
        // caricamento file JRXML subreport
        jasperDesign = JRXmlLoader.load(JASPER_REPORT_FOLDER + idOp + "/"
                + "tracciabilita_subreport.jrxml");
        // compilazione del file e generazione del file JASPER
        JasperCompileManager.compileReportToFile(jasperDesign,
                JASPER_REPORT_FOLDER + idOp + "/"
                        + "tracciabilita_subreport.jasper");
        // inizializzazione connessione al database
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME,
                DB_PASSWORD);
        // rendering e generazione del file PDF
        JasperPrint jp = JasperFillManager.fillReport(JASPER_REPORT_FOLDER
                + idOp + "/" + "tracciabilita.jasper", parametersMap, conn);
        JasperExportManager.exportReportToPdfFile(jp, "/tmp/" + tipoDocumento
                + "_" + idAssociato + ".pdf");
        conn.close();
        return "/tmp/" + tipoDocumento + "_" + idAssociato + ".pdf";
    }

    public String printCMR(String[][] cmrHeader, int year, int nDoc,
            int idAssociato, String cmr, long idOp) throws JRException,
            ClassNotFoundException, SQLException, FileNotFoundException {
        Map<String, Object> parametersMap = new HashMap<String, Object>();

        // inizializzazione connessione al database

        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME,
                DB_PASSWORD);

        List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();

        for (int i = 0; i < 5; i++) {

            parametersMap.put("header", cmrHeader[i]);
            parametersMap.put("copies", i + 1);
            parametersMap.put("year", year);
            parametersMap.put("WkNOrd", nDoc);
            parametersMap.put("idAssociato", idAssociato);
            parametersMap.put("tipoDocumento", "DDT");

            // caricamento file JRXML

            JasperDesign jasperDesign = JRXmlLoader.load(JASPER_REPORT_FOLDER
                    + idOp + "/" + "cmr.jrxml");

            // compilazione del file e generazione del file JASPER

            JasperCompileManager.compileReportToFile(jasperDesign,
                    JASPER_REPORT_FOLDER + idOp + "/" + "cmr.jasper");

            // caricamento file JRXML subreport

            jasperDesign = JRXmlLoader.load(JASPER_REPORT_FOLDER + idOp + "/"
                    + "cmr_details.jrxml");

            // compilazione del file e generazione del file JASPER

            JasperCompileManager.compileReportToFile(jasperDesign,
                    JASPER_REPORT_FOLDER + idOp + "/" + "cmr_details.jasper");

            // rendering e generazione del file PDF

            JasperPrint jp = JasperFillManager.fillReport(JASPER_REPORT_FOLDER
                    + idOp + "/" + "cmr.jasper", parametersMap, conn);

            jasperPrintList.add(jp);
        }

        JRPdfExporter pdfExporter = new JRPdfExporter();
        pdfExporter.setExporterInput(SimpleExporterInput
                .getInstance(jasperPrintList));
        FileOutputStream output = new FileOutputStream(new File("/tmp/CMR_"
                + idAssociato + ".pdf"));
        pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(
                output));
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCreatingBatchModeBookmarks(true);
        pdfExporter.setConfiguration(configuration);
        pdfExporter.exportReport();
        conn.close();
        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/tmp/CMR_" + idAssociato + ".pdf";
    }

    public String printCessioneCredito(CessioneCredito cessioneCredito,
            long idOp, String body) throws JRException,
            ClassNotFoundException, SQLException {

        Map<String, Object> parametersMap = new HashMap<String, Object>();
        parametersMap.put("idAssociato", cessioneCredito.getIdAssociato());
        parametersMap.put("anno", cessioneCredito.getAnno());
        parametersMap.put("body", body);
        parametersMap.put("numeroFattura", cessioneCredito.getNumeroFattura());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        parametersMap.put("dataFattura", sdf.format(cessioneCredito.getData()));

        // caricamento file JRXML
        JasperDesign jasperDesign = JRXmlLoader.load(JASPER_REPORT_FOLDER
                + idOp + "/" + "cessione_credito.jrxml");
        // compilazione del file e generazione del file JASPER
        JasperCompileManager.compileReportToFile(jasperDesign,
                JASPER_REPORT_FOLDER + idOp + "/" + "cessione_credito.jasper");
        
        // inizializzazione connessione al database
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME,
                DB_PASSWORD);
        // rendering e generazione del file PDF
        JasperPrint jp = JasperFillManager.fillReport(JASPER_REPORT_FOLDER
                + idOp + "/" + "cessione_credito.jasper", parametersMap, conn);
        JasperExportManager.exportReportToPdfFile(jp, "/tmp/cessione_credito" 
                + "_" + cessioneCredito.getIdAssociato() + ".pdf");
        conn.close();
        return "/tmp/cessione_credito" 
                + "_" + cessioneCredito.getIdAssociato() + ".pdf";
    }
}