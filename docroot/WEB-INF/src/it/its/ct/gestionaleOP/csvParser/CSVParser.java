package it.its.ct.gestionaleOP.csvParser;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.model.WKRigoDocumento;
import it.bysoftware.ct.model.WKTestataDocumento;
import it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.WKRigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.WKTestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.persistence.RigoDocumentoPK;
import it.bysoftware.ct.service.persistence.TestataDocumentoPK;
import it.bysoftware.ct.service.persistence.WKRigoDocumentoPK;
import it.bysoftware.ct.service.persistence.WKTestataDocumentoPK;

public class CSVParser {
	
	public static WKTestataDocumento getTestata(String[] st, long idAssociato){
		String anno = st[11].split("/")[2];
		String numeroDocumento = (st[9].equals("") || st[9].equals("0") ) ? st[10] : st[9];
		String tipoDocumento = st[0];
		WKTestataDocumento t = WKTestataDocumentoLocalServiceUtil.createWKTestataDocumento(new WKTestataDocumentoPK(Integer.parseInt(anno), Long.parseLong(numeroDocumento), tipoDocumento, idAssociato));
		//Tipdoc;Codcen;Datreg;Codsog;Codspe;Codpor;Codase;Codve1;Codve2;Numdoc;Protoc;Datdoc;Datann
		t.setCentro(st[1]);
		t.setCodiceSoggetto(st[3]);
		t.setPorto(st[5]);
		t.setAspettoEsteriore(st[6]);
		t.setVettore(st[7]);
		t.setVettore2(st[8]);
		t.setDataOrdine(st[11]);
		
		return t;
	}


	public static WKRigoDocumento getRigo(String[] st, WKTestataDocumento testataDocumento, int rigoDocumento, long idAssociato) {
//		String tipoDocumento = st[0];
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.ITALY);
		WKRigoDocumento r = WKRigoDocumentoLocalServiceUtil.createWKRigoDocumento(new WKRigoDocumentoPK(testataDocumento.getAnno(), testataDocumento.getNumeroOrdine(), rigoDocumento, testataDocumento.getTipoDocumento(), idAssociato));
//		Tiprig;Codart;Codvar;Descri;Quanet;Qm2net;Prezzo;Scont1;Scont2;Scont3;Libstr1;Libstr2;Libstr3;Libdbl1;Libdbl2;Libdbl3;Liblng1;Liblng2;Liblng3;Libdat1;Libdat2;Libdat3;Codlot;Numbol;Numrigbol;Unimis
		r.setCodiceArticolo(st[1]);
		r.setCodiceVariante(st[2]);
		r.setDescrizione(st[3]);
		try {
			r.setPesoNetto(nf.parse(st[4]).doubleValue());
			r.setColli(Integer.parseInt(st[5]));
			r.setPrezzo(Math.round(nf.parse(st[6]).doubleValue() * 100.00)/100.00);
			r.setSconto1((float) (Math.round(nf.parse(st[7]).floatValue() * 100.00)/100.00));
			r.setSconto2((float) (Math.round(nf.parse(st[8]).floatValue() * 100.00)/100.00));
			r.setSconto3((float) (Math.round(nf.parse(st[9]).floatValue() * 100.00)/100.00));
			r.setPesoLordo(Math.round(nf.parse(st[13]).floatValue() * 100.00)/100.00);
			r.setTara(Math.round(nf.parse(st[14]).floatValue() * 100.00)/100.00);
			r.setLotto(st[22]);
			if(st[1].equals("0"))
				r.setUnitaMisura(st[25]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	
}
