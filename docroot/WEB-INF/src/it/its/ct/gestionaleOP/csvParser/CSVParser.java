package it.its.ct.gestionaleOP.csvParser;

import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.persistence.RigoDocumentoPK;
import it.bysoftware.ct.service.persistence.TestataDocumentoPK;

public class CSVParser {
	
	public static TestataDocumento getTestata(String[] st, long idAssociato){
		String anno = st[11].split("/")[2];
		String numeroDocumento = (st[9].equals("") || st[9].equals("0") ) ? st[10] : st[9];
		String tipoDocumento = st[0];
		TestataDocumento t = TestataDocumentoLocalServiceUtil.createTestataDocumento(new TestataDocumentoPK(Integer.parseInt(anno), Long.parseLong(numeroDocumento), tipoDocumento, idAssociato));
		//Tipdoc;Codcen;Datreg;Codsog;Codspe;Codpor;Codase;Codve1;Codve2;Numdoc;Protoc;Datdoc;Datann
		t.setCentro(st[1]);
		t.setCodiceSoggetto(st[3]);
		t.setPorto(st[5]);
		t.setAspettoEsteriore(st[6]);
		t.setVettore(st[7]);
		t.setVettore2(st[8]);
		t.setDataOrdine(st[9]);
		
		return t;
	}


	public static RigoDocumento getRigo(String[] st, TestataDocumento testataDocumento, int rigoDocumento, long idAssociato) {
//		String tipoDocumento = st[0];
		
		RigoDocumento r = RigoDocumentoLocalServiceUtil.createRigoDocumento(new RigoDocumentoPK(testataDocumento.getAnno(), testataDocumento.getNumeroOrdine(), rigoDocumento, testataDocumento.getTipoDocumento(), idAssociato));
//		Tiprig;Codart;Codvar;Descri;Quanet;Qm2net;Prezzo;Scont1;Scont2;Scont3;Libstr1;Libstr2;Libstr3;Libdbl1;Libdbl2;Libdbl3;Liblng1;Liblng2;Liblng3;Libdat1;Libdat2;Libdat3;Codlot;Numbol;Numrigbol
		r.setCodiceArticolo(st[1]);
		r.setCodiceVariante(st[2]);
		r.setDescrizione(st[3]);
		r.setPesoNetto(Double.parseDouble(st[4]));
		r.setColli(Integer.parseInt(st[5]));
		r.setPrezzo(Double.parseDouble(st[6]));
		r.setSconto1(Float.parseFloat(st[7]));
		r.setSconto2(Float.parseFloat(st[8]));
		r.setSconto3(Float.parseFloat(st[9]));
		r.setLotto(st[22]);
		return r;
	}
	
}
