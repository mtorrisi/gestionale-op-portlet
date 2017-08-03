YUI().ready('aui-io-plugin', function(Y) {
	if (!window.addEventListener) {
		window.attachEvent('onmessage', receiver);
	} else {
		window.addEventListener('message', receiver, false);
	}

});

function receiver(e) {
	console.log(e);
}

function DDTrow(codiceArticolo, descrizione, lotto, reti, pedane, imballo, rtxCl,
				kgRete, colli, pesoLordo, tara, taraPedana, pesoNetto,prezzo,
				codArtFornitore, passaporto, progressivo) {
	this.codiceArticolo = codiceArticolo;
	this.descrizione = descrizione;
	this.lotto = lotto;
	this.pedane = pedane;
	this.imballo  = imballo;
	this.rtxCl = rtxCl;
	this.kgRete = kgRete;
	this.colli = colli;
	this.pesoLordo = pesoLordo;
	this.taraPedana = taraPedana;
	this.pesoNetto = pesoNetto;
	this.prezzo = prezzo;
	this.codArtFornitore = codArtFornitore;
	this.passaporto = passaporto;
	this.progressivo = progressivo;
}