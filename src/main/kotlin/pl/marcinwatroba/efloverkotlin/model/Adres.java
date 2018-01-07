package pl.marcinwatroba.efloverkotlin.model;

public class Adres {

	public int id;
	public String ulica;
	public String nrDomu;
	public String miasto;
	public String kodPocztowy;

	public Adres(int id, String ulica, String nrDomu, String miasto, String kodPocztowy) {
		this.id = id;
		this.ulica = ulica;
		this.nrDomu = nrDomu;
		this.miasto = miasto;
		this.kodPocztowy = kodPocztowy;
	}

	public String getAddressString() {
		return "ul. " + ulica + " " + nrDomu + ", " + kodPocztowy + " " + miasto;
	}

}