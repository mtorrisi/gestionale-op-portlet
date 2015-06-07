create table Articoli (
	RanCodart VARCHAR(75) not null primary key,
	RanCatmer VARCHAR(75) null,
	RanDescri VARCHAR(75) null,
	RanDesdoc VARCHAR(75) null,
	RanDesfis VARCHAR(75) null,
	RanLibDbl1 DOUBLE
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