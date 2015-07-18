/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.bysoftware.ct.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.bysoftware.ct.service.ClpSerializer;
import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.persistence.TestataDocumentoPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TestataDocumentoClp extends BaseModelImpl<TestataDocumento>
	implements TestataDocumento {
	public TestataDocumentoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TestataDocumento.class;
	}

	@Override
	public String getModelClassName() {
		return TestataDocumento.class.getName();
	}

	@Override
	public TestataDocumentoPK getPrimaryKey() {
		return new TestataDocumentoPK(_anno, _numeroOrdine);
	}

	@Override
	public void setPrimaryKey(TestataDocumentoPK primaryKey) {
		setAnno(primaryKey.anno);
		setNumeroOrdine(primaryKey.numeroOrdine);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new TestataDocumentoPK(_anno, _numeroOrdine);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((TestataDocumentoPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("anno", getAnno());
		attributes.put("numeroOrdine", getNumeroOrdine());
		attributes.put("codiceSoggetto", getCodiceSoggetto());
		attributes.put("dataOrdine", getDataOrdine());
		attributes.put("dataConsegna", getDataConsegna());
		attributes.put("destinazione", getDestinazione());
		attributes.put("codiceDestinazione", getCodiceDestinazione());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("completo", getCompleto());
		attributes.put("operatore", getOperatore());
		attributes.put("visto", getVisto());
		attributes.put("inviato", getInviato());
		attributes.put("lotto", getLotto());
		attributes.put("tipoDocumeto", getTipoDocumeto());
		attributes.put("vettore", getVettore());
		attributes.put("autista", getAutista());
		attributes.put("telefono", getTelefono());
		attributes.put("centro", getCentro());
		attributes.put("palletCaricati", getPalletCaricati());
		attributes.put("palletScaricati", getPalletScaricati());
		attributes.put("codiceVettore", getCodiceVettore());
		attributes.put("destinazioneVettore", getDestinazioneVettore());
		attributes.put("nota1", getNota1());
		attributes.put("nota2", getNota2());
		attributes.put("rigoDescrittivo", getRigoDescrittivo());
		attributes.put("vettore2", getVettore2());
		attributes.put("curaTrasporto", getCuraTrasporto());
		attributes.put("aspettoEsteriore", getAspettoEsteriore());
		attributes.put("causaleTrasporto", getCausaleTrasporto());
		attributes.put("porto", getPorto());
		attributes.put("origine", getOrigine());
		attributes.put("numeroPedaneEuro", getNumeroPedaneEuro());
		attributes.put("numeroPedaneNormali", getNumeroPedaneNormali());
		attributes.put("costoTrasporto", getCostoTrasporto());
		attributes.put("totalePedaneOrdine", getTotalePedaneOrdine());
		attributes.put("targaCamion", getTargaCamion());
		attributes.put("targaRimorchio", getTargaRimorchio());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Long numeroOrdine = (Long)attributes.get("numeroOrdine");

		if (numeroOrdine != null) {
			setNumeroOrdine(numeroOrdine);
		}

		String codiceSoggetto = (String)attributes.get("codiceSoggetto");

		if (codiceSoggetto != null) {
			setCodiceSoggetto(codiceSoggetto);
		}

		String dataOrdine = (String)attributes.get("dataOrdine");

		if (dataOrdine != null) {
			setDataOrdine(dataOrdine);
		}

		String dataConsegna = (String)attributes.get("dataConsegna");

		if (dataConsegna != null) {
			setDataConsegna(dataConsegna);
		}

		String destinazione = (String)attributes.get("destinazione");

		if (destinazione != null) {
			setDestinazione(destinazione);
		}

		String codiceDestinazione = (String)attributes.get("codiceDestinazione");

		if (codiceDestinazione != null) {
			setCodiceDestinazione(codiceDestinazione);
		}

		String ragioneSociale = (String)attributes.get("ragioneSociale");

		if (ragioneSociale != null) {
			setRagioneSociale(ragioneSociale);
		}

		String completo = (String)attributes.get("completo");

		if (completo != null) {
			setCompleto(completo);
		}

		String operatore = (String)attributes.get("operatore");

		if (operatore != null) {
			setOperatore(operatore);
		}

		Integer visto = (Integer)attributes.get("visto");

		if (visto != null) {
			setVisto(visto);
		}

		Integer inviato = (Integer)attributes.get("inviato");

		if (inviato != null) {
			setInviato(inviato);
		}

		String lotto = (String)attributes.get("lotto");

		if (lotto != null) {
			setLotto(lotto);
		}

		String tipoDocumeto = (String)attributes.get("tipoDocumeto");

		if (tipoDocumeto != null) {
			setTipoDocumeto(tipoDocumeto);
		}

		String vettore = (String)attributes.get("vettore");

		if (vettore != null) {
			setVettore(vettore);
		}

		String autista = (String)attributes.get("autista");

		if (autista != null) {
			setAutista(autista);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		String centro = (String)attributes.get("centro");

		if (centro != null) {
			setCentro(centro);
		}

		Integer palletCaricati = (Integer)attributes.get("palletCaricati");

		if (palletCaricati != null) {
			setPalletCaricati(palletCaricati);
		}

		Integer palletScaricati = (Integer)attributes.get("palletScaricati");

		if (palletScaricati != null) {
			setPalletScaricati(palletScaricati);
		}

		String codiceVettore = (String)attributes.get("codiceVettore");

		if (codiceVettore != null) {
			setCodiceVettore(codiceVettore);
		}

		String destinazioneVettore = (String)attributes.get(
				"destinazioneVettore");

		if (destinazioneVettore != null) {
			setDestinazioneVettore(destinazioneVettore);
		}

		String nota1 = (String)attributes.get("nota1");

		if (nota1 != null) {
			setNota1(nota1);
		}

		String nota2 = (String)attributes.get("nota2");

		if (nota2 != null) {
			setNota2(nota2);
		}

		String rigoDescrittivo = (String)attributes.get("rigoDescrittivo");

		if (rigoDescrittivo != null) {
			setRigoDescrittivo(rigoDescrittivo);
		}

		String vettore2 = (String)attributes.get("vettore2");

		if (vettore2 != null) {
			setVettore2(vettore2);
		}

		String curaTrasporto = (String)attributes.get("curaTrasporto");

		if (curaTrasporto != null) {
			setCuraTrasporto(curaTrasporto);
		}

		String aspettoEsteriore = (String)attributes.get("aspettoEsteriore");

		if (aspettoEsteriore != null) {
			setAspettoEsteriore(aspettoEsteriore);
		}

		String causaleTrasporto = (String)attributes.get("causaleTrasporto");

		if (causaleTrasporto != null) {
			setCausaleTrasporto(causaleTrasporto);
		}

		String porto = (String)attributes.get("porto");

		if (porto != null) {
			setPorto(porto);
		}

		String origine = (String)attributes.get("origine");

		if (origine != null) {
			setOrigine(origine);
		}

		Integer numeroPedaneEuro = (Integer)attributes.get("numeroPedaneEuro");

		if (numeroPedaneEuro != null) {
			setNumeroPedaneEuro(numeroPedaneEuro);
		}

		Integer numeroPedaneNormali = (Integer)attributes.get(
				"numeroPedaneNormali");

		if (numeroPedaneNormali != null) {
			setNumeroPedaneNormali(numeroPedaneNormali);
		}

		Double costoTrasporto = (Double)attributes.get("costoTrasporto");

		if (costoTrasporto != null) {
			setCostoTrasporto(costoTrasporto);
		}

		Integer totalePedaneOrdine = (Integer)attributes.get(
				"totalePedaneOrdine");

		if (totalePedaneOrdine != null) {
			setTotalePedaneOrdine(totalePedaneOrdine);
		}

		String targaCamion = (String)attributes.get("targaCamion");

		if (targaCamion != null) {
			setTargaCamion(targaCamion);
		}

		String targaRimorchio = (String)attributes.get("targaRimorchio");

		if (targaRimorchio != null) {
			setTargaRimorchio(targaRimorchio);
		}
	}

	@Override
	public int getAnno() {
		return _anno;
	}

	@Override
	public void setAnno(int anno) {
		_anno = anno;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setAnno", int.class);

				method.invoke(_testataDocumentoRemoteModel, anno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNumeroOrdine() {
		return _numeroOrdine;
	}

	@Override
	public void setNumeroOrdine(long numeroOrdine) {
		_numeroOrdine = numeroOrdine;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroOrdine", long.class);

				method.invoke(_testataDocumentoRemoteModel, numeroOrdine);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceSoggetto() {
		return _codiceSoggetto;
	}

	@Override
	public void setCodiceSoggetto(String codiceSoggetto) {
		_codiceSoggetto = codiceSoggetto;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceSoggetto",
						String.class);

				method.invoke(_testataDocumentoRemoteModel, codiceSoggetto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDataOrdine() {
		return _dataOrdine;
	}

	@Override
	public void setDataOrdine(String dataOrdine) {
		_dataOrdine = dataOrdine;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setDataOrdine", String.class);

				method.invoke(_testataDocumentoRemoteModel, dataOrdine);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDataConsegna() {
		return _dataConsegna;
	}

	@Override
	public void setDataConsegna(String dataConsegna) {
		_dataConsegna = dataConsegna;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setDataConsegna", String.class);

				method.invoke(_testataDocumentoRemoteModel, dataConsegna);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDestinazione() {
		return _destinazione;
	}

	@Override
	public void setDestinazione(String destinazione) {
		_destinazione = destinazione;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setDestinazione", String.class);

				method.invoke(_testataDocumentoRemoteModel, destinazione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceDestinazione() {
		return _codiceDestinazione;
	}

	@Override
	public void setCodiceDestinazione(String codiceDestinazione) {
		_codiceDestinazione = codiceDestinazione;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceDestinazione",
						String.class);

				method.invoke(_testataDocumentoRemoteModel, codiceDestinazione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRagioneSociale() {
		return _ragioneSociale;
	}

	@Override
	public void setRagioneSociale(String ragioneSociale) {
		_ragioneSociale = ragioneSociale;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setRagioneSociale",
						String.class);

				method.invoke(_testataDocumentoRemoteModel, ragioneSociale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompleto() {
		return _completo;
	}

	@Override
	public void setCompleto(String completo) {
		_completo = completo;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompleto", String.class);

				method.invoke(_testataDocumentoRemoteModel, completo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOperatore() {
		return _operatore;
	}

	@Override
	public void setOperatore(String operatore) {
		_operatore = operatore;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setOperatore", String.class);

				method.invoke(_testataDocumentoRemoteModel, operatore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getVisto() {
		return _visto;
	}

	@Override
	public void setVisto(int visto) {
		_visto = visto;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setVisto", int.class);

				method.invoke(_testataDocumentoRemoteModel, visto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getInviato() {
		return _inviato;
	}

	@Override
	public void setInviato(int inviato) {
		_inviato = inviato;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setInviato", int.class);

				method.invoke(_testataDocumentoRemoteModel, inviato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLotto() {
		return _lotto;
	}

	@Override
	public void setLotto(String lotto) {
		_lotto = lotto;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setLotto", String.class);

				method.invoke(_testataDocumentoRemoteModel, lotto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTipoDocumeto() {
		return _tipoDocumeto;
	}

	@Override
	public void setTipoDocumeto(String tipoDocumeto) {
		_tipoDocumeto = tipoDocumeto;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoDocumeto", String.class);

				method.invoke(_testataDocumentoRemoteModel, tipoDocumeto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVettore() {
		return _vettore;
	}

	@Override
	public void setVettore(String vettore) {
		_vettore = vettore;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setVettore", String.class);

				method.invoke(_testataDocumentoRemoteModel, vettore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAutista() {
		return _autista;
	}

	@Override
	public void setAutista(String autista) {
		_autista = autista;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setAutista", String.class);

				method.invoke(_testataDocumentoRemoteModel, autista);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelefono() {
		return _telefono;
	}

	@Override
	public void setTelefono(String telefono) {
		_telefono = telefono;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTelefono", String.class);

				method.invoke(_testataDocumentoRemoteModel, telefono);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCentro() {
		return _centro;
	}

	@Override
	public void setCentro(String centro) {
		_centro = centro;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCentro", String.class);

				method.invoke(_testataDocumentoRemoteModel, centro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPalletCaricati() {
		return _palletCaricati;
	}

	@Override
	public void setPalletCaricati(int palletCaricati) {
		_palletCaricati = palletCaricati;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setPalletCaricati", int.class);

				method.invoke(_testataDocumentoRemoteModel, palletCaricati);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPalletScaricati() {
		return _palletScaricati;
	}

	@Override
	public void setPalletScaricati(int palletScaricati) {
		_palletScaricati = palletScaricati;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setPalletScaricati", int.class);

				method.invoke(_testataDocumentoRemoteModel, palletScaricati);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceVettore() {
		return _codiceVettore;
	}

	@Override
	public void setCodiceVettore(String codiceVettore) {
		_codiceVettore = codiceVettore;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceVettore", String.class);

				method.invoke(_testataDocumentoRemoteModel, codiceVettore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDestinazioneVettore() {
		return _destinazioneVettore;
	}

	@Override
	public void setDestinazioneVettore(String destinazioneVettore) {
		_destinazioneVettore = destinazioneVettore;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setDestinazioneVettore",
						String.class);

				method.invoke(_testataDocumentoRemoteModel, destinazioneVettore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNota1() {
		return _nota1;
	}

	@Override
	public void setNota1(String nota1) {
		_nota1 = nota1;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNota1", String.class);

				method.invoke(_testataDocumentoRemoteModel, nota1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNota2() {
		return _nota2;
	}

	@Override
	public void setNota2(String nota2) {
		_nota2 = nota2;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNota2", String.class);

				method.invoke(_testataDocumentoRemoteModel, nota2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRigoDescrittivo() {
		return _rigoDescrittivo;
	}

	@Override
	public void setRigoDescrittivo(String rigoDescrittivo) {
		_rigoDescrittivo = rigoDescrittivo;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setRigoDescrittivo",
						String.class);

				method.invoke(_testataDocumentoRemoteModel, rigoDescrittivo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVettore2() {
		return _vettore2;
	}

	@Override
	public void setVettore2(String vettore2) {
		_vettore2 = vettore2;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setVettore2", String.class);

				method.invoke(_testataDocumentoRemoteModel, vettore2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCuraTrasporto() {
		return _curaTrasporto;
	}

	@Override
	public void setCuraTrasporto(String curaTrasporto) {
		_curaTrasporto = curaTrasporto;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCuraTrasporto", String.class);

				method.invoke(_testataDocumentoRemoteModel, curaTrasporto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAspettoEsteriore() {
		return _aspettoEsteriore;
	}

	@Override
	public void setAspettoEsteriore(String aspettoEsteriore) {
		_aspettoEsteriore = aspettoEsteriore;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setAspettoEsteriore",
						String.class);

				method.invoke(_testataDocumentoRemoteModel, aspettoEsteriore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCausaleTrasporto() {
		return _causaleTrasporto;
	}

	@Override
	public void setCausaleTrasporto(String causaleTrasporto) {
		_causaleTrasporto = causaleTrasporto;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCausaleTrasporto",
						String.class);

				method.invoke(_testataDocumentoRemoteModel, causaleTrasporto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPorto() {
		return _porto;
	}

	@Override
	public void setPorto(String porto) {
		_porto = porto;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setPorto", String.class);

				method.invoke(_testataDocumentoRemoteModel, porto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrigine() {
		return _origine;
	}

	@Override
	public void setOrigine(String origine) {
		_origine = origine;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setOrigine", String.class);

				method.invoke(_testataDocumentoRemoteModel, origine);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumeroPedaneEuro() {
		return _numeroPedaneEuro;
	}

	@Override
	public void setNumeroPedaneEuro(int numeroPedaneEuro) {
		_numeroPedaneEuro = numeroPedaneEuro;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroPedaneEuro", int.class);

				method.invoke(_testataDocumentoRemoteModel, numeroPedaneEuro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumeroPedaneNormali() {
		return _numeroPedaneNormali;
	}

	@Override
	public void setNumeroPedaneNormali(int numeroPedaneNormali) {
		_numeroPedaneNormali = numeroPedaneNormali;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroPedaneNormali",
						int.class);

				method.invoke(_testataDocumentoRemoteModel, numeroPedaneNormali);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCostoTrasporto() {
		return _costoTrasporto;
	}

	@Override
	public void setCostoTrasporto(double costoTrasporto) {
		_costoTrasporto = costoTrasporto;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCostoTrasporto",
						double.class);

				method.invoke(_testataDocumentoRemoteModel, costoTrasporto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTotalePedaneOrdine() {
		return _totalePedaneOrdine;
	}

	@Override
	public void setTotalePedaneOrdine(int totalePedaneOrdine) {
		_totalePedaneOrdine = totalePedaneOrdine;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalePedaneOrdine",
						int.class);

				method.invoke(_testataDocumentoRemoteModel, totalePedaneOrdine);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTargaCamion() {
		return _targaCamion;
	}

	@Override
	public void setTargaCamion(String targaCamion) {
		_targaCamion = targaCamion;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTargaCamion", String.class);

				method.invoke(_testataDocumentoRemoteModel, targaCamion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTargaRimorchio() {
		return _targaRimorchio;
	}

	@Override
	public void setTargaRimorchio(String targaRimorchio) {
		_targaRimorchio = targaRimorchio;

		if (_testataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _testataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTargaRimorchio",
						String.class);

				method.invoke(_testataDocumentoRemoteModel, targaRimorchio);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTestataDocumentoRemoteModel() {
		return _testataDocumentoRemoteModel;
	}

	public void setTestataDocumentoRemoteModel(
		BaseModel<?> testataDocumentoRemoteModel) {
		_testataDocumentoRemoteModel = testataDocumentoRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _testataDocumentoRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_testataDocumentoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TestataDocumentoLocalServiceUtil.addTestataDocumento(this);
		}
		else {
			TestataDocumentoLocalServiceUtil.updateTestataDocumento(this);
		}
	}

	@Override
	public TestataDocumento toEscapedModel() {
		return (TestataDocumento)ProxyUtil.newProxyInstance(TestataDocumento.class.getClassLoader(),
			new Class[] { TestataDocumento.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TestataDocumentoClp clone = new TestataDocumentoClp();

		clone.setAnno(getAnno());
		clone.setNumeroOrdine(getNumeroOrdine());
		clone.setCodiceSoggetto(getCodiceSoggetto());
		clone.setDataOrdine(getDataOrdine());
		clone.setDataConsegna(getDataConsegna());
		clone.setDestinazione(getDestinazione());
		clone.setCodiceDestinazione(getCodiceDestinazione());
		clone.setRagioneSociale(getRagioneSociale());
		clone.setCompleto(getCompleto());
		clone.setOperatore(getOperatore());
		clone.setVisto(getVisto());
		clone.setInviato(getInviato());
		clone.setLotto(getLotto());
		clone.setTipoDocumeto(getTipoDocumeto());
		clone.setVettore(getVettore());
		clone.setAutista(getAutista());
		clone.setTelefono(getTelefono());
		clone.setCentro(getCentro());
		clone.setPalletCaricati(getPalletCaricati());
		clone.setPalletScaricati(getPalletScaricati());
		clone.setCodiceVettore(getCodiceVettore());
		clone.setDestinazioneVettore(getDestinazioneVettore());
		clone.setNota1(getNota1());
		clone.setNota2(getNota2());
		clone.setRigoDescrittivo(getRigoDescrittivo());
		clone.setVettore2(getVettore2());
		clone.setCuraTrasporto(getCuraTrasporto());
		clone.setAspettoEsteriore(getAspettoEsteriore());
		clone.setCausaleTrasporto(getCausaleTrasporto());
		clone.setPorto(getPorto());
		clone.setOrigine(getOrigine());
		clone.setNumeroPedaneEuro(getNumeroPedaneEuro());
		clone.setNumeroPedaneNormali(getNumeroPedaneNormali());
		clone.setCostoTrasporto(getCostoTrasporto());
		clone.setTotalePedaneOrdine(getTotalePedaneOrdine());
		clone.setTargaCamion(getTargaCamion());
		clone.setTargaRimorchio(getTargaRimorchio());

		return clone;
	}

	@Override
	public int compareTo(TestataDocumento testataDocumento) {
		TestataDocumentoPK primaryKey = testataDocumento.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestataDocumentoClp)) {
			return false;
		}

		TestataDocumentoClp testataDocumento = (TestataDocumentoClp)obj;

		TestataDocumentoPK primaryKey = testataDocumento.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{anno=");
		sb.append(getAnno());
		sb.append(", numeroOrdine=");
		sb.append(getNumeroOrdine());
		sb.append(", codiceSoggetto=");
		sb.append(getCodiceSoggetto());
		sb.append(", dataOrdine=");
		sb.append(getDataOrdine());
		sb.append(", dataConsegna=");
		sb.append(getDataConsegna());
		sb.append(", destinazione=");
		sb.append(getDestinazione());
		sb.append(", codiceDestinazione=");
		sb.append(getCodiceDestinazione());
		sb.append(", ragioneSociale=");
		sb.append(getRagioneSociale());
		sb.append(", completo=");
		sb.append(getCompleto());
		sb.append(", operatore=");
		sb.append(getOperatore());
		sb.append(", visto=");
		sb.append(getVisto());
		sb.append(", inviato=");
		sb.append(getInviato());
		sb.append(", lotto=");
		sb.append(getLotto());
		sb.append(", tipoDocumeto=");
		sb.append(getTipoDocumeto());
		sb.append(", vettore=");
		sb.append(getVettore());
		sb.append(", autista=");
		sb.append(getAutista());
		sb.append(", telefono=");
		sb.append(getTelefono());
		sb.append(", centro=");
		sb.append(getCentro());
		sb.append(", palletCaricati=");
		sb.append(getPalletCaricati());
		sb.append(", palletScaricati=");
		sb.append(getPalletScaricati());
		sb.append(", codiceVettore=");
		sb.append(getCodiceVettore());
		sb.append(", destinazioneVettore=");
		sb.append(getDestinazioneVettore());
		sb.append(", nota1=");
		sb.append(getNota1());
		sb.append(", nota2=");
		sb.append(getNota2());
		sb.append(", rigoDescrittivo=");
		sb.append(getRigoDescrittivo());
		sb.append(", vettore2=");
		sb.append(getVettore2());
		sb.append(", curaTrasporto=");
		sb.append(getCuraTrasporto());
		sb.append(", aspettoEsteriore=");
		sb.append(getAspettoEsteriore());
		sb.append(", causaleTrasporto=");
		sb.append(getCausaleTrasporto());
		sb.append(", porto=");
		sb.append(getPorto());
		sb.append(", origine=");
		sb.append(getOrigine());
		sb.append(", numeroPedaneEuro=");
		sb.append(getNumeroPedaneEuro());
		sb.append(", numeroPedaneNormali=");
		sb.append(getNumeroPedaneNormali());
		sb.append(", costoTrasporto=");
		sb.append(getCostoTrasporto());
		sb.append(", totalePedaneOrdine=");
		sb.append(getTotalePedaneOrdine());
		sb.append(", targaCamion=");
		sb.append(getTargaCamion());
		sb.append(", targaRimorchio=");
		sb.append(getTargaRimorchio());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(115);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.TestataDocumento");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>anno</column-name><column-value><![CDATA[");
		sb.append(getAnno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroOrdine</column-name><column-value><![CDATA[");
		sb.append(getNumeroOrdine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceSoggetto</column-name><column-value><![CDATA[");
		sb.append(getCodiceSoggetto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataOrdine</column-name><column-value><![CDATA[");
		sb.append(getDataOrdine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataConsegna</column-name><column-value><![CDATA[");
		sb.append(getDataConsegna());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>destinazione</column-name><column-value><![CDATA[");
		sb.append(getDestinazione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceDestinazione</column-name><column-value><![CDATA[");
		sb.append(getCodiceDestinazione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ragioneSociale</column-name><column-value><![CDATA[");
		sb.append(getRagioneSociale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completo</column-name><column-value><![CDATA[");
		sb.append(getCompleto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>operatore</column-name><column-value><![CDATA[");
		sb.append(getOperatore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visto</column-name><column-value><![CDATA[");
		sb.append(getVisto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inviato</column-name><column-value><![CDATA[");
		sb.append(getInviato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lotto</column-name><column-value><![CDATA[");
		sb.append(getLotto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoDocumeto</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumeto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vettore</column-name><column-value><![CDATA[");
		sb.append(getVettore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>autista</column-name><column-value><![CDATA[");
		sb.append(getAutista());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefono</column-name><column-value><![CDATA[");
		sb.append(getTelefono());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>centro</column-name><column-value><![CDATA[");
		sb.append(getCentro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>palletCaricati</column-name><column-value><![CDATA[");
		sb.append(getPalletCaricati());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>palletScaricati</column-name><column-value><![CDATA[");
		sb.append(getPalletScaricati());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceVettore</column-name><column-value><![CDATA[");
		sb.append(getCodiceVettore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>destinazioneVettore</column-name><column-value><![CDATA[");
		sb.append(getDestinazioneVettore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nota1</column-name><column-value><![CDATA[");
		sb.append(getNota1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nota2</column-name><column-value><![CDATA[");
		sb.append(getNota2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rigoDescrittivo</column-name><column-value><![CDATA[");
		sb.append(getRigoDescrittivo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vettore2</column-name><column-value><![CDATA[");
		sb.append(getVettore2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>curaTrasporto</column-name><column-value><![CDATA[");
		sb.append(getCuraTrasporto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aspettoEsteriore</column-name><column-value><![CDATA[");
		sb.append(getAspettoEsteriore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>causaleTrasporto</column-name><column-value><![CDATA[");
		sb.append(getCausaleTrasporto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>porto</column-name><column-value><![CDATA[");
		sb.append(getPorto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>origine</column-name><column-value><![CDATA[");
		sb.append(getOrigine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroPedaneEuro</column-name><column-value><![CDATA[");
		sb.append(getNumeroPedaneEuro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroPedaneNormali</column-name><column-value><![CDATA[");
		sb.append(getNumeroPedaneNormali());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costoTrasporto</column-name><column-value><![CDATA[");
		sb.append(getCostoTrasporto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalePedaneOrdine</column-name><column-value><![CDATA[");
		sb.append(getTotalePedaneOrdine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targaCamion</column-name><column-value><![CDATA[");
		sb.append(getTargaCamion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targaRimorchio</column-name><column-value><![CDATA[");
		sb.append(getTargaRimorchio());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _anno;
	private long _numeroOrdine;
	private String _codiceSoggetto;
	private String _dataOrdine;
	private String _dataConsegna;
	private String _destinazione;
	private String _codiceDestinazione;
	private String _ragioneSociale;
	private String _completo;
	private String _operatore;
	private int _visto;
	private int _inviato;
	private String _lotto;
	private String _tipoDocumeto;
	private String _vettore;
	private String _autista;
	private String _telefono;
	private String _centro;
	private int _palletCaricati;
	private int _palletScaricati;
	private String _codiceVettore;
	private String _destinazioneVettore;
	private String _nota1;
	private String _nota2;
	private String _rigoDescrittivo;
	private String _vettore2;
	private String _curaTrasporto;
	private String _aspettoEsteriore;
	private String _causaleTrasporto;
	private String _porto;
	private String _origine;
	private int _numeroPedaneEuro;
	private int _numeroPedaneNormali;
	private double _costoTrasporto;
	private int _totalePedaneOrdine;
	private String _targaCamion;
	private String _targaRimorchio;
	private BaseModel<?> _testataDocumentoRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}