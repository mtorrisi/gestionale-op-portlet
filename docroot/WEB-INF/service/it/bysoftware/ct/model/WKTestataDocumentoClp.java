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
import it.bysoftware.ct.service.WKTestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.persistence.WKTestataDocumentoPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class WKTestataDocumentoClp extends BaseModelImpl<WKTestataDocumento>
	implements WKTestataDocumento {
	public WKTestataDocumentoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return WKTestataDocumento.class;
	}

	@Override
	public String getModelClassName() {
		return WKTestataDocumento.class.getName();
	}

	@Override
	public WKTestataDocumentoPK getPrimaryKey() {
		return new WKTestataDocumentoPK(_anno, _numeroOrdine, _tipoDocumento,
			_idAssociato);
	}

	@Override
	public void setPrimaryKey(WKTestataDocumentoPK primaryKey) {
		setAnno(primaryKey.anno);
		setNumeroOrdine(primaryKey.numeroOrdine);
		setTipoDocumento(primaryKey.tipoDocumento);
		setIdAssociato(primaryKey.idAssociato);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new WKTestataDocumentoPK(_anno, _numeroOrdine, _tipoDocumento,
			_idAssociato);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((WKTestataDocumentoPK)primaryKeyObj);
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
		attributes.put("tipoDocumento", getTipoDocumento());
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
		attributes.put("idAssociato", getIdAssociato());
		attributes.put("verificato", getVerificato());

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

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
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

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		Boolean verificato = (Boolean)attributes.get("verificato");

		if (verificato != null) {
			setVerificato(verificato);
		}
	}

	@Override
	public int getAnno() {
		return _anno;
	}

	@Override
	public void setAnno(int anno) {
		_anno = anno;

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setAnno", int.class);

				method.invoke(_wkTestataDocumentoRemoteModel, anno);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroOrdine", long.class);

				method.invoke(_wkTestataDocumentoRemoteModel, numeroOrdine);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceSoggetto",
						String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, codiceSoggetto);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setDataOrdine", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, dataOrdine);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setDataConsegna", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, dataConsegna);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setDestinazione", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, destinazione);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceDestinazione",
						String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, codiceDestinazione);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setRagioneSociale",
						String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, ragioneSociale);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompleto", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, completo);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setOperatore", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, operatore);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setVisto", int.class);

				method.invoke(_wkTestataDocumentoRemoteModel, visto);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setInviato", int.class);

				method.invoke(_wkTestataDocumentoRemoteModel, inviato);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setLotto", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, lotto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTipoDocumento() {
		return _tipoDocumento;
	}

	@Override
	public void setTipoDocumento(String tipoDocumento) {
		_tipoDocumento = tipoDocumento;

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoDocumento", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, tipoDocumento);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setVettore", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, vettore);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setAutista", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, autista);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTelefono", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, telefono);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCentro", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, centro);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setPalletCaricati", int.class);

				method.invoke(_wkTestataDocumentoRemoteModel, palletCaricati);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setPalletScaricati", int.class);

				method.invoke(_wkTestataDocumentoRemoteModel, palletScaricati);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceVettore", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, codiceVettore);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setDestinazioneVettore",
						String.class);

				method.invoke(_wkTestataDocumentoRemoteModel,
					destinazioneVettore);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNota1", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, nota1);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNota2", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, nota2);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setRigoDescrittivo",
						String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, rigoDescrittivo);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setVettore2", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, vettore2);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCuraTrasporto", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, curaTrasporto);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setAspettoEsteriore",
						String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, aspettoEsteriore);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCausaleTrasporto",
						String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, causaleTrasporto);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setPorto", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, porto);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setOrigine", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, origine);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroPedaneEuro", int.class);

				method.invoke(_wkTestataDocumentoRemoteModel, numeroPedaneEuro);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroPedaneNormali",
						int.class);

				method.invoke(_wkTestataDocumentoRemoteModel,
					numeroPedaneNormali);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCostoTrasporto",
						double.class);

				method.invoke(_wkTestataDocumentoRemoteModel, costoTrasporto);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalePedaneOrdine",
						int.class);

				method.invoke(_wkTestataDocumentoRemoteModel, totalePedaneOrdine);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTargaCamion", String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, targaCamion);
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

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTargaRimorchio",
						String.class);

				method.invoke(_wkTestataDocumentoRemoteModel, targaRimorchio);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdAssociato() {
		return _idAssociato;
	}

	@Override
	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setIdAssociato", long.class);

				method.invoke(_wkTestataDocumentoRemoteModel, idAssociato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getVerificato() {
		return _verificato;
	}

	@Override
	public boolean isVerificato() {
		return _verificato;
	}

	@Override
	public void setVerificato(boolean verificato) {
		_verificato = verificato;

		if (_wkTestataDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkTestataDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setVerificato", boolean.class);

				method.invoke(_wkTestataDocumentoRemoteModel, verificato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWKTestataDocumentoRemoteModel() {
		return _wkTestataDocumentoRemoteModel;
	}

	public void setWKTestataDocumentoRemoteModel(
		BaseModel<?> wkTestataDocumentoRemoteModel) {
		_wkTestataDocumentoRemoteModel = wkTestataDocumentoRemoteModel;
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

		Class<?> remoteModelClass = _wkTestataDocumentoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_wkTestataDocumentoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WKTestataDocumentoLocalServiceUtil.addWKTestataDocumento(this);
		}
		else {
			WKTestataDocumentoLocalServiceUtil.updateWKTestataDocumento(this);
		}
	}

	@Override
	public WKTestataDocumento toEscapedModel() {
		return (WKTestataDocumento)ProxyUtil.newProxyInstance(WKTestataDocumento.class.getClassLoader(),
			new Class[] { WKTestataDocumento.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WKTestataDocumentoClp clone = new WKTestataDocumentoClp();

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
		clone.setTipoDocumento(getTipoDocumento());
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
		clone.setIdAssociato(getIdAssociato());
		clone.setVerificato(getVerificato());

		return clone;
	}

	@Override
	public int compareTo(WKTestataDocumento wkTestataDocumento) {
		int value = 0;

		if (getNumeroOrdine() < wkTestataDocumento.getNumeroOrdine()) {
			value = -1;
		}
		else if (getNumeroOrdine() > wkTestataDocumento.getNumeroOrdine()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WKTestataDocumentoClp)) {
			return false;
		}

		WKTestataDocumentoClp wkTestataDocumento = (WKTestataDocumentoClp)obj;

		WKTestataDocumentoPK primaryKey = wkTestataDocumento.getPrimaryKey();

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
		StringBundler sb = new StringBundler(79);

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
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
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
		sb.append(", idAssociato=");
		sb.append(getIdAssociato());
		sb.append(", verificato=");
		sb.append(getVerificato());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(121);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.WKTestataDocumento");
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
			"<column><column-name>tipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumento());
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
		sb.append(
			"<column><column-name>idAssociato</column-name><column-value><![CDATA[");
		sb.append(getIdAssociato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>verificato</column-name><column-value><![CDATA[");
		sb.append(getVerificato());
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
	private String _tipoDocumento;
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
	private long _idAssociato;
	private boolean _verificato;
	private BaseModel<?> _wkTestataDocumentoRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}