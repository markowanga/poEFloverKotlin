package pl.marcinwatroba.efloverkotlin.model;

import java.util.Date;
import java.util.List;

public class Zamowienie extends Koszyk {

    public int id;
    public StatusZamowienia statusZamowienia;
    public Adres adres;
    public Date data;
    public MetodaPlatnosci metodaPlatnosci;

    public Zamowienie(int id, List<ProduktWKoszyku> produktWKoszykuList, Adres adres, Date data,
                      MetodaPlatnosci metodaPlatnosci, StatusZamowienia statusZamowienia) {
        super(produktWKoszykuList);
        this.adres = adres;
        this.id = id;
        this.data = data;
        this.metodaPlatnosci = metodaPlatnosci;
        this.statusZamowienia = statusZamowienia;
    }
}