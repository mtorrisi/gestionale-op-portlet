create index IX_B856D87E on Articoli (RanCatmer);

create index IX_2AD67D88 on CMR (anno, id_associato);
create index IX_A733D68D on CMR (anno, id_associato, numero_documento);

create index IX_39991B9 on ClientiFornitoriDatiAgg (RveCodclf);

create index IX_75890C32 on DestinatariDiversi (RavCodrif);

create index IX_A02FCE4A on ProgAnnFor (Re4Anno, Re4Codatt, Re4Numcon);

create index IX_AC8B1912 on SSRIGORD (WkNOrd);
create index IX_88FCE1A8 on SSRIGORD (WkNOrd, WKAnno);
create index IX_2A84F1A9 on SSRIGORD (WkNOrd, WKAnno, WKTipdoc, WkCodart, WkVarian, WKImballo, id_associato);
create index IX_BFC9C5A0 on SSRIGORD (WkNOrd, WKAnno, id_associato);
create index IX_CA243305 on SSRIGORD (WkNOrd, WKAnno, id_associato, WKTipdoc);

create index IX_8D0468E1 on SSTESORD (WKAnno, WKNOrd, WKTipdoc, id_associato, Nota2);
create index IX_2A5D7118 on SSTESORD (WKAnno, WKTipdoc, id_associato);
create index IX_AF1AAF7C on SSTESORD (WKAnno, WKTipdoc, id_associato, Nota2);
create index IX_5EF84E9D on SSTESORD (WkCodsog, WkOperatore);
create index IX_8C00B6D8 on SSTESORD (WkOperatore);
create index IX_67C73F9D on SSTESORD (WkOperatore, WKCompleto, WKInviato);
create index IX_986314C2 on SSTESORD (WkOperatore, WKCompleto, WKInviato, WKTipdoc);

create index IX_1E6332A on TracciabilitaGrezzi (id_scheda_tracciabilita);

create index IX_70DC6490 on WK_SSRIGORD (WKAnno, id_associato);
create index IX_482BCA50 on WK_SSRIGORD (WkNOrd, WKAnno, id_associato, WKTipdoc);

create index IX_16C2823E on WK_SSTESORD (WKAnno, id_associato);
create index IX_7618A674 on WK_SSTESORD (WKAnno, id_associato, verificato);

create index IX_E93AA8C3 on associato (attivo);
create index IX_320CDAD2 on associato (attivo, id_op);
create unique index IX_95DBA707 on associato (centro);
create unique index IX_DEA53A9E on associato (email);
create unique index IX_EF7BEC6C on associato (id_liferay);
create index IX_D8824E5A on associato (partita_iva);
create index IX_B149F450 on associato (ragione_sociale);

create index IX_D4174921 on associato_cliente (id_associato);
create index IX_57975933 on associato_cliente (id_cliente);

create index IX_1756E7F1 on cessioneCredito (anno, id_associato, numero_fattura);

create index IX_D2B09DD9 on gestionaleOP_Testata_Righe (WKAnno);
create index IX_E72C6D7E on gestionaleOP_Testata_Righe (WKNOrd);
create index IX_83F3D59E on gestionaleOP_Testata_Righe (WkNOrd);
create index IX_4333201C on gestionaleOP_Testata_Righe (WkRigord);

create unique index IX_D165BC05 on op (email);
create unique index IX_85A73365 on op (id_liferay);
create index IX_7BFE681 on op (partita_iva);
create index IX_5A2120F7 on op (ragione_sociale);

create index IX_AAF495AE on scheda_tracciabilita (id_scheda_tracciabilita);
create index IX_C3B3514C on scheda_tracciabilita (numero_ordine, anno, id_associato, tipo_documento);

create index IX_A19DDEBE on scheda_tracciabilita_rigo (id_scheda_tracciabilita);

create index IX_45E15C56 on tracciabilitaScheda (anno, id_associato);
create index IX_B3BD5E35 on tracciabilitaScheda (anno, id_associato, numero_documento, codice_prodotto, tipo_documento);
create index IX_F16F0278 on tracciabilitaScheda (anno, id_associato, numero_documento, tipo_documento);
create index IX_D3A05C9B on tracciabilitaScheda (anno, id_associato, numero_documento, tipo_documento, codice_prodotto);
create index IX_9A942AF3 on tracciabilitaScheda (anno, id_associato, tipo_documento);

create index IX_2817DB3 on tracciabilita_rigo (id_scheda_tracciabilita);