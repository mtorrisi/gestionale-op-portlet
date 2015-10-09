create table Articoli (
	RanCodart VARCHAR(75) not null primary key,
	RanCatmer VARCHAR(75) null,
	RanDescri VARCHAR(75) null,
	RanDesdoc VARCHAR(75) null,
	RanDesfis VARCHAR(75) null,
	RanLibDbl1 DOUBLE
);

create table AspettoEsterioreBeni (
	RdeCoddes VARCHAR(75) not null primary key,
	RdeDescri VARCHAR(75) null,
	RdeCodiaz VARCHAR(75) null
);

create table CausaleTrasporto (
	RdeCoddes VARCHAR(75) not null primary key,
	RdeDescri VARCHAR(75) null,
	RdeCodiaz VARCHAR(75) null
);

create table ClientiFornitoriDatiAgg (
	RveCodclf VARCHAR(75) not null primary key,
	RveLibStr1 VARCHAR(75) null
);

create table CuraTrasporto (
	RdeCoddes VARCHAR(75) not null primary key,
	RdeDescri VARCHAR(75) null,
	RdeCodiaz VARCHAR(75) null
);

create table DescrizioniDocumenti (
	Re1Coddes VARCHAR(75) not null primary key,
	Re1Codiva VARCHAR(75) null,
	Re1Descri VARCHAR(75) null,
	Re1Desfis VARCHAR(75) null,
	Re1Codiaz VARCHAR(75) null
);

create table DescrizioniVarianti (
	CvdCodvar VARCHAR(75) not null primary key,
	CvdDescri VARCHAR(75) null,
	CvdOrdine INTEGER,
	CvdTipvar VARCHAR(75) null,
	CvdCodiaz VARCHAR(75) null
);

create table DestinatariDiversi (
	RavCodana VARCHAR(75) not null primary key,
	RavCodrif VARCHAR(75) null,
	RavCap VARCHAR(75) null,
	RavComune VARCHAR(75) null,
	RavIndiri VARCHAR(75) null,
	RavSigpro VARCHAR(75) null,
	RavSigsta VARCHAR(75) null,
	RavTipana VARCHAR(75) null
);

create table Porto (
	RdeCdinco VARCHAR(75) null,
	RdeCoddes VARCHAR(75) not null primary key,
	RdeDescri VARCHAR(75) null,
	RdeIncoterm VARCHAR(75) null,
	RdeCodiaz VARCHAR(75) null
);

create table ProgAnnFor (
	Re4Anno INTEGER not null,
	Re4Codatt LONG not null,
	Re4Codcen VARCHAR(75) null,
	Re4Coddep VARCHAR(75) null,
	Re4Datreg VARCHAR(75) null,
	Re4Nuboll LONG,
	Re4Numcon INTEGER not null,
	Re4Prgcon INTEGER not null,
	Re4Tipcon INTEGER,
	Re4Codiaz VARCHAR(75) null,
	primary key (Re4Anno, Re4Codatt, Re4Numcon, Re4Prgcon)
);

create table SSRIGORD (
	WKAnno INTEGER not null,
	WkNOrd LONG not null,
	WkRigord INTEGER not null,
	WkDesvar VARCHAR(75) null,
	WkCodart VARCHAR(75) null,
	WkDescri VARCHAR(75) null,
	WkUnimis VARCHAR(75) null,
	WkColli INTEGER,
	WkPeslor DOUBLE,
	WkTara DOUBLE,
	WkPesnet DOUBLE,
	WkPrezzo DOUBLE,
	WkPedane DOUBLE,
	WkNote VARCHAR(75) null,
	WkTotpes DOUBLE,
	WKImballo VARCHAR(75) null,
	WkGesRetine BOOLEAN,
	WkRtxCl DOUBLE,
	WkKgRetine DOUBLE,
	WkLotto VARCHAR(75) null,
	CodPassaportoAlfa VARCHAR(75) null,
	CodPassaportoNum INTEGER,
	sconto1 DOUBLE,
	sconto2 DOUBLE,
	sconto3 DOUBLE,
	WKTipdoc VARCHAR(75) not null,
	id_associato LONG not null,
	primary key (WKAnno, WkNOrd, WkRigord, WKTipdoc, id_associato)
);

create table SSTESORD (
	WKAnno INTEGER not null,
	WKNOrd LONG not null,
	WkCodsog VARCHAR(75) null,
	WkDatord VARCHAR(75) null,
	WkDatcon VARCHAR(75) null,
	WkDesti2 VARCHAR(75) null,
	WkDesdiv VARCHAR(75) null,
	WkRagsoc VARCHAR(75) null,
	WKCompleto VARCHAR(75) null,
	WkOperatore VARCHAR(75) null,
	WKVisto INTEGER,
	WKInviato INTEGER,
	WKLotto VARCHAR(75) null,
	WKTipdoc VARCHAR(75) not null,
	WkVettore VARCHAR(75) null,
	WkAutista VARCHAR(75) null,
	WkTelefono VARCHAR(75) null,
	WKCentro VARCHAR(75) null,
	EpalCaricati INTEGER,
	EpalScaricati INTEGER,
	CodDestiVett1 VARCHAR(75) null,
	DestiVett1 VARCHAR(75) null,
	Nota1 VARCHAR(75) null,
	Nota2 VARCHAR(75) null,
	Rigodescrittivo VARCHAR(75) null,
	WkVettore2 VARCHAR(75) null,
	TraspCura VARCHAR(75) null,
	AspEst VARCHAR(75) null,
	CauTrasp VARCHAR(75) null,
	porto VARCHAR(75) null,
	Origine VARCHAR(75) null,
	NpedEpal INTEGER,
	NpedNormali INTEGER,
	CostoTrasp DOUBLE,
	TotPedOrd INTEGER,
	TargaCamion VARCHAR(75) null,
	TargaRimorchio VARCHAR(75) null,
	id_associato LONG not null,
	primary key (WKAnno, WKNOrd, WKTipdoc, id_associato)
);

create table Vettori (
	RavAlbo VARCHAR(75) null,
	RavCap VARCHAR(75) null,
	RavCodana VARCHAR(75) not null primary key,
	RavCodfis VARCHAR(75) null,
	RavCodrif VARCHAR(75) null,
	RavComune VARCHAR(75) null,
	RavIndiri VARCHAR(75) null,
	RavNote VARCHAR(75) null,
	RavPariva VARCHAR(75) null,
	RavRagso1 VARCHAR(75) null,
	RavRagso2 VARCHAR(75) null,
	RavSigpro VARCHAR(75) null,
	RavSigsta VARCHAR(75) null,
	RavTipana VARCHAR(75) null,
	RavCodiaz VARCHAR(75) null
);

create table associato (
	id LONG not null primary key,
	centro VARCHAR(75) null,
	ragione_sociale VARCHAR(75) null,
	partita_iva VARCHAR(75) null,
	indirizzo VARCHAR(75) null,
	telefono VARCHAR(75) null,
	fax VARCHAR(75) null,
	email VARCHAR(75) null,
	password VARCHAR(75) null,
	id_liferay LONG,
	id_op LONG,
	attivo BOOLEAN
);

create table associato_cliente (
	id_associato LONG not null,
	id_cliente VARCHAR(75) not null,
	primary key (id_associato, id_cliente)
);

create table gestionaleOP_Testata_Righe (
	WKAnno INTEGER not null,
	WkNOrd INTEGER not null,
	WkRigord INTEGER not null,
	WKAnno INTEGER not null,
	WKNOrd INTEGER not null,
	primary key (WKAnno, WkNOrd, WkRigord, WKAnno, WKNOrd)
);

create table op (
	id LONG not null primary key,
	ragione_sociale VARCHAR(75) null,
	partita_iva VARCHAR(75) null,
	indirizzo VARCHAR(75) null,
	telefono VARCHAR(75) null,
	fax VARCHAR(75) null,
	sito_web VARCHAR(75) null,
	email VARCHAR(75) null,
	password VARCHAR(75) null,
	id_liferay LONG
);