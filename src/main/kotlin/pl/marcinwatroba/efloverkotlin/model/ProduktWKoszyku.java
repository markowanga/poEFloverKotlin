package pl.marcinwatroba.efloverkotlin.model;

import java.io.Serializable;

public class ProduktWKoszyku implements Serializable {

	public int ilosc;
	public Produkt produkt;

	public ProduktWKoszyku(Produkt produkt, int ilosc) {
		this.produkt = produkt;
		this.ilosc = ilosc;
	}

	public float getAllPrice() {
		return ilosc * produkt.cena;
	}

}