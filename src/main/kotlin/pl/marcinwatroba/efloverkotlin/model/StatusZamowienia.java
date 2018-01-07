package pl.marcinwatroba.efloverkotlin.model;

import java.io.Serializable;

public enum StatusZamowienia implements Serializable {
	oczekujeNaZaplate,
	wPrzygotowaniu,
	przygotowana,
	przekazanaKurierowi,
	dostarczona,
	nieDostarczona
}