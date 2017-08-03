package it.its.ct.gestionaleOP.pojos;

import it.bysoftware.ct.model.WKRigoDocumento;
import it.bysoftware.ct.model.WKTestataDocumento;

import java.util.List;
public class Documento {

	public Documento() {
		super();
	}

	public Documento(WKTestataDocumento testata, List<WKRigoDocumento> righe) {
		super();
		this.testata = testata;
		this.righe = righe;
	}

	public List<WKRigoDocumento> getRighe() {
		return righe;
	}

	public WKTestataDocumento getTestata() {
		return testata;
	}

	public void setRighe(List<WKRigoDocumento> righe) {
		this.righe = righe;
	}

	public void setTestata(WKTestataDocumento testata) {
		this.testata = testata;
	}

	private List<WKRigoDocumento> righe;
	private WKTestataDocumento testata;

}