package it.its.ct.gestionaleOP.pojos;

import it.bysoftware.ct.model.WKRigoDocumento;
import it.bysoftware.ct.model.WKTestataDocumento;

import java.util.List;

public class Documento {

	private WKTestataDocumento testata;
	private List<WKRigoDocumento> righe;

	public Documento() {
		super();
	}

	public Documento(WKTestataDocumento testata, List<WKRigoDocumento> righe) {
		super();
		this.testata = testata;
		this.righe = righe;
	}

	public WKTestataDocumento getTestata() {
		return testata;
	}

	public void setTestata(WKTestataDocumento testata) {
		this.testata = testata;
	}

	public List<WKRigoDocumento> getRighe() {
		return righe;
	}

	public void setRighe(List<WKRigoDocumento> righe) {
		this.righe = righe;
	}

}
