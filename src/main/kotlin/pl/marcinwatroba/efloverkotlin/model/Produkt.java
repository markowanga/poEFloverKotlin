package pl.marcinwatroba.efloverkotlin.model;

import java.io.Serializable;

public class Produkt implements Serializable {

    public int id;
    public float cena;
    public String nazwa;
    public String opis;
    public String imgPath;

    public Produkt(int id, String nazwa, float cena, String imgPath, String opis) {
        this.id = id;
        this.cena = cena;
        this.nazwa = nazwa;
        this.opis = opis;
        this.imgPath = imgPath;
    }

    public String getPriceString() {
        return String.format("%10.2f", cena) + "zł";
    }
}