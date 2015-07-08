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

create table CuraTrasporto (
	RdeCoddes VARCHAR(75) not null primary key,
	RdeDescri VARCHAR(75) null,
	RdeCodiaz VARCHAR(75) null
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

create table SSRIGORD (
	WKAnno INTEGER not null,
	WkNOrd INTEGER not null,
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
	primary key (WKAnno, WkNOrd, WkRigord)
);

create table SSTESORD (
	WKAnno INTEGER not null,
	WKNOrd INTEGER not null,
	WkCodsog VARCHAR(75) null,
	WkDatord VARCHAR(75) null,
	WkDatcon VARCHAR(75) null,
	WkDesti2 VARCHAR(75) null,
	WkDesdiv INTEGER,
	WkRagsoc VARCHAR(75) null,
	WKCompleto VARCHAR(75) null,
	WkOperatore VARCHAR(75) null,
	WKVisto INTEGER,
	WKInviato INTEGER,
	WKLotto VARCHAR(75) null,
	WKTipdoc VARCHAR(75) null,
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
	primary key (WKAnno, WKNOrd)
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

create table gestionaleOP_Testata_Righe (
	WKAnno INTEGER not null,
	WkNOrd INTEGER not null,
	WkRigord INTEGER not null,
	WKAnno INTEGER not null,
	WKNOrd INTEGER not null,
	primary key (WKAnno, WkNOrd, WkRigord, WKAnno, WKNOrd)
);