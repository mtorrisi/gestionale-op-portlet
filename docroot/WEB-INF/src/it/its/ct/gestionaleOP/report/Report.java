/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.its.ct.gestionaleOP.report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author mario
 */
public class Report {

    public static String JASPER_REPORT_FOLDER = "/home/mario/test/";
    public static String JASPER_FILENAME = "report1";
    public static String DRIVER = "com.mysql.jdbc.Driver";
    public static String DB_URL = "jdbc:mysql://localhost/test";
    public static String DB_NAME = "test";
    public static String DB_USERNAME = "op_user";
    public static String DB_PASSWORD = "op_user";

    public void print() throws JRException, ClassNotFoundException, SQLException {
        Map parametersMap = new HashMap();
        parametersMap.put("WkNOrd", 5);
        //caricamento file JRXML
        JasperDesign jasperDesign = JRXmlLoader.load(JASPER_REPORT_FOLDER + JASPER_FILENAME + ".jrxml");
        //compilazione del file e generazione del file JASPER
        JasperCompileManager.compileReportToFile(jasperDesign, JASPER_REPORT_FOLDER + JASPER_FILENAME + ".jasper");
        //inizializzazione connessione al database
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        //rendering e generazione del file PDF
        JasperPrint jp = JasperFillManager.fillReport(JASPER_REPORT_FOLDER + JASPER_FILENAME + ".jasper", parametersMap, conn);
        JasperExportManager.exportReportToPdfFile(jp, JASPER_REPORT_FOLDER + "report.pdf");

    }
}
