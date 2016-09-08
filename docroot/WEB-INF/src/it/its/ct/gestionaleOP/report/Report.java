/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.its.ct.gestionaleOP.report;

import it.its.ct.gestionaleOP.utils.DocumentType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
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

	public static String JASPER_REPORT_FOLDER = "/home/mario/ITS/";
	public static String JASPER_FILENAME = "ddt";
	public static String DRIVER = "com.mysql.jdbc.Driver";
	public static String DB_URL = "jdbc:mysql://localhost/gestionaleop";
	public static String DB_NAME = "gestionaleop";
	public static String DB_USERNAME = "op_user";
	public static String DB_PASSWORD = "op_user";

	public String print(int year, int nDoc, int idAssociato, long idOp)
			throws JRException, ClassNotFoundException, SQLException {
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
			String tipoDocumento, long idOp, boolean toOp, String logo)
			throws JRException, ClassNotFoundException, SQLException {
		String reportFile = !toOp ? tipoDocumento : tipoDocumento + "2op";
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("WkNOrd", nDoc);
		parametersMap.put("idAssociato", idAssociato);
		parametersMap.put("tipoDocumento", tipoDocumento.toUpperCase());
		parametersMap.put("year", year);
		if (!logo.equals(""))
			parametersMap.put("logo", logo);
		// caricamento file JRXML
		JasperDesign jasperDesign = JRXmlLoader.load(JASPER_REPORT_FOLDER
				+ idOp + "/" + reportFile + ".jrxml");
		// compilazione del file e generazione del file JASPER
		JasperCompileManager.compileReportToFile(jasperDesign,
				JASPER_REPORT_FOLDER + idOp + "/" + reportFile + ".jasper");
		// inizializzazione connessione al database
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME,
				DB_PASSWORD);

		// rendering e generazione del file PDF
		JasperPrint jp = JasperFillManager.fillReport(JASPER_REPORT_FOLDER
				+ idOp + "/" + reportFile + ".jasper", parametersMap, conn);
		JasperExportManager.exportReportToPdfFile(jp, "/tmp/" + tipoDocumento
				+ "_" + idAssociato + ".pdf");
		conn.close();
		return "/tmp/" + tipoDocumento + "_" + idAssociato + ".pdf";
	}

	public String print(int year, int nDoc, int idAssociato,
			String tipoDocumento, long idOp) throws JRException,
			ClassNotFoundException, SQLException {

		return print(year, nDoc, idAssociato, tipoDocumento, idOp, false, "");

	}

	public String printTrace(int anno, int nDoc, int idAssociato,
			String tipoDocumento, long idOp) throws JRException,
			ClassNotFoundException, SQLException {
		Map<String, Object> parametersMap = new HashMap<String, Object>();

		parametersMap.put("ANNO", anno);
		parametersMap.put("N_DOC", nDoc);
		parametersMap.put("ID_ASSOCIATO", idAssociato);
		// parametersMap.put("tipoDocumento", tipoDocumento.toUpperCase());

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
		for (int i = 0; i < cmrHeader.length; i++) {
			for(int j = 0; j < cmrHeader[i].length; j++)
				System.out.println(cmrHeader[i][j]);
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
		 FileOutputStream output = new FileOutputStream(new File("/tmp/CMR_" + idAssociato
					+ ".pdf"));
		pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(output));
		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
		configuration.setCreatingBatchModeBookmarks(true);
		pdfExporter.setConfiguration(configuration);
		pdfExporter.exportReport();
		conn.close();
		return "/tmp/CMR_" + idAssociato + ".pdf";
	}
}
