create index IX_B856D87E on Articoli (RanCatmer);

create index IX_75890C32 on DestinatariDiversi (RavCodrif);

create index IX_AC8B1912 on SSRIGORD (WkNOrd);
create index IX_88FCE1A8 on SSRIGORD (WkNOrd, WKAnno);

create index IX_8C00B6D8 on SSTESORD (WkOperatore);
create index IX_67C73F9D on SSTESORD (WkOperatore, WKCompleto, WKInviato);

create index IX_E93AA8C3 on associato (attivo);
create unique index IX_95DBA707 on associato (centro);
create unique index IX_DEA53A9E on associato (email);
create index IX_D8824E5A on associato (partita_iva);
create index IX_B149F450 on associato (ragione_sociale);

create index IX_D2B09DD9 on gestionaleOP_Testata_Righe (WKAnno);
create index IX_E72C6D7E on gestionaleOP_Testata_Righe (WKNOrd);
create index IX_83F3D59E on gestionaleOP_Testata_Righe (WkNOrd);
create index IX_4333201C on gestionaleOP_Testata_Righe (WkRigord);

create unique index IX_D165BC05 on op (email);
create unique index IX_85A73365 on op (id_liferay);
create index IX_7BFE681 on op (partita_iva);
create index IX_5A2120F7 on op (ragione_sociale);