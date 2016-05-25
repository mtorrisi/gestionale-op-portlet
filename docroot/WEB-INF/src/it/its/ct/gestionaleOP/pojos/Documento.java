package it.its.ct.gestionaleOP.pojos;

import java.util.List;

import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.TestataDocumento;

public class Documento {

	private TestataDocumento testata;
	private List<RigoDocumento> righe;

	public Documento() {
		super();
	}

	public Documento(TestataDocumento testata, List<RigoDocumento> righe) {
		super();
		this.testata = testata;
		this.righe = righe;
	}

	public TestataDocumento getTestata() {
		return testata;
	}

	public void setTestata(TestataDocumento testata) {
		this.testata = testata;
	}

	public List<RigoDocumento> getRighe() {
		return righe;
	}

	public void setRighe(List<RigoDocumento> righe) {
		this.righe = righe;
	}

}
