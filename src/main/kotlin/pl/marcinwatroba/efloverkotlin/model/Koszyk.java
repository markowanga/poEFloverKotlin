package pl.marcinwatroba.efloverkotlin.model;

import java.io.Serializable;
import java.util.List;

public class Koszyk implements Serializable {

	public List<ProduktWKoszyku> produktWKoszykuList;

	public Koszyk(List<ProduktWKoszyku> produktWKoszykuList) {
		this.produktWKoszykuList = produktWKoszykuList;
	}

	public float getKwotaDoZapłaty() {
		float sum = 0;
		for (ProduktWKoszyku p: produktWKoszykuList) {
			sum += p.ilosc * p.produkt.cena;
		}
		return sum;
	}

	public String getCostString() {
		return String.format("%10.2fzł", getKwotaDoZapłaty());
	}
}