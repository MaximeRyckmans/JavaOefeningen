package utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Datum implements Comparable<Datum>, Cloneable {
	protected int dag;
	protected int maand;
	protected int jaar;

	public Datum() {
		Date d = new Date();
		dag = d.getDate();
		maand = d.getMonth() + 1;
		jaar = d.getYear() + 1900;
	}

	public Datum(Datum datum) {
		try {
			setDatum(datum.getDag(), datum.getMaand(), datum.getJaar());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	public Datum(int dag, int maand, int jaar) {
		try {
			setDatum(dag, maand, jaar);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	public Datum(String datum) {
		try {
			String[] deelVanDatum = datum.split("/");
			this.jaar = Integer.parseInt(deelVanDatum[2]);
			controleerMaand(Integer.parseInt(deelVanDatum[1]) - 1);
			controleerDag(Integer.parseInt(deelVanDatum[0]));
		} catch (Exception exception) {

			System.out.println(exception.getMessage());
		}
	}

	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public int getMaand() {
		return maand;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	private boolean controleerDag(int dag) {
		int[] dagenPerMaand = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (dag > 0 && dag <= dagenPerMaand[maand]) {
			if (isSchrikkeljaar(dag, maand, jaar)) {
				return true;
			}
			return true;
		}
		return false;

	}

	private boolean isSchrikkeljaar(int dag, int maand, int jaar) {
		if (maand == 2 && dag == 29
				&& (jaar % 400 == 0 || (jaar % 4 == 0 && jaar % 100 != 0))) {
			return true;
		}
		return false;
	}

	private boolean controleerMaand(int maand) {
		int maandAangepast = maand - 1;
		if (maandAangepast >= 0 && maandAangepast < 12) {
			return true;
		}
		return false;

	}

	public Boolean setDatum(int dag, int maand, int jaar) throws Exception {
		if (controleerDag(dag)) {
			this.dag = dag;
		} else {
			throw new Exception("Ongeldige dag");

		}
		if (controleerMaand(maand)) {
			this.maand = maand;
		} else {
			throw new Exception("Ongeldige maand");
		}
		this.jaar = jaar;
		return true;
	}

	/**
	 * methode geeft datum terug in Amerikaans formaat
	 * 
	 * @return datum in amerikaans formaat (y/MM/dd)
	 */
	public String getDatumInAmerikaansFormaat() {
		SimpleDateFormat df = new SimpleDateFormat("y/MM/d");
		Date d = new Date();
		d.setDate(dag);
		d.setMonth(maand - 1);
		d.setYear(jaar - 1900);
		return df.format(d);
	}

	/**
	 * methode geeft datum terug in Europees formaat
	 * 
	 * @return datum in europees formaat (d/MM/yyyy)
	 */
	public String getDatumInEuropeesFormaat() {
		SimpleDateFormat df = new SimpleDateFormat("d/MM/yyyy");
		Date d = new Date();
		d.setDate(dag);
		d.setMonth(maand - 1);
		d.setYear(jaar - 1900);
		return df.format(d);
	}

	@Override
	public String toString() {
		String[] maanden = { "januari", "februari", "maart", "april", "mei",
				"juni", "juli", "augustus", "september", "oktober", "november",
				"december" };
		String juisteMaand = maanden[this.maand - 1];
		return this.dag + " " + juisteMaand + " " + this.jaar;
	}

	public boolean kleinerDan(Datum d) {
		if (this.getJaar() > d.getJaar()) {
			return false;
		} else if (this.getJaar() < d.getJaar()) {
			return true;
		} else if (this.getMaand() > d.getMaand()) {
			return false;
		} else if (this.getMaand() < d.getMaand()) {
			return true;
		} else if (this.getDag() > d.getDag()) {
			return false;
		}

		return true;
	}

	public int verschilInJaren(Datum d) {
		int verschilInJaren = 0;
		if (this.kleinerDan(d)) {
			verschilInJaren = d.getJaar() - this.getJaar();
			if (this.getMaand() > d.getMaand()) {
				verschilInJaren -= 1;
			}
		} else {
			verschilInJaren = this.getJaar() - d.getJaar();
			if (d.getMaand() > this.getMaand()) {
				verschilInJaren -= 1;
			}
		}
		return verschilInJaren;
	}

	public int verschilInMaanden(Datum d) {
		int verschilInJaren = this.verschilInJaren(d);
		if (this.kleinerDan(d) && this.getJaar() == d.getJaar()) {
			int verschilMaanden = d.getMaand() - this.getMaand();
			return verschilInJaren * 12 + verschilMaanden;
		}
		if (this.kleinerDan(d)) {
			int overschotMaanden = 12 - this.getMaand();
			return verschilInJaren * 12 + overschotMaanden + d.getMaand();
		}
		if (!this.kleinerDan(d) && this.getJaar() == d.getJaar()) {
			int verschilMaanden = this.getMaand() - d.getMaand();
			return verschilInJaren * 12 + verschilMaanden;
		}
		if (!this.kleinerDan(d)) {
			int overschotMaanden = 12 - d.getMaand();
			return verschilInJaren * 12 + overschotMaanden + this.getMaand();
		}
		return 0;
	}

	public int verschilInDagen(Datum d) {
		int totaalAantalDagen = 0;
		int dagenEersteDatum = 365 * this.getJaar() + this.getJaar() / 4
				- this.getJaar() / 100 + this.getJaar() / 400 + this.getDag()
				+ (153 * this.getMaand() + 8) / 5;
		int dagenTweedeDatum = 365 * d.getJaar() + d.getJaar() / 4
				- d.getJaar() / 100 + d.getJaar() / 400 + d.getDag()
				+ (153 * d.getMaand() + 8) / 5;
		if (this.kleinerDan(d)) {
			totaalAantalDagen = dagenTweedeDatum - dagenEersteDatum;
		} else {
			totaalAantalDagen = dagenEersteDatum - dagenTweedeDatum;
		}
		return totaalAantalDagen;
	}
//TODO
	public void veranderDatum(int dagen) {
		int dagenEersteDatum = 365 * this.getJaar() + this.getJaar() / 4
				- this.getJaar() / 100 + this.getJaar() / 400 + this.getDag()
				+ (153 * this.getMaand() + 8) / 5;
		dagenEersteDatum+=dagen;
		
		
	}
	//TODO
	private Datum berekenDatumVanAantalDagen(int aantalDagen){
		int dagenEersteDatum = 365 * this.getJaar() + this.getJaar() / 4
				- this.getJaar() / 100 + this.getJaar() / 400 + this.getDag()
				+ (153 * this.getMaand() + 8) / 5;
		int aantalJaren= dagenEersteDatum;
		return null;
	}
	public Datum veranderDatum2(int aantalDagen) {
		Datum d = new Datum();
		return d;
	}

	public int getAantalDagenVanMaandenDitJaar(int maand) {
		int aantalDagen = 0;
		int[] dagenPerMaand = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int i = 0; i < maand; i++) {
			aantalDagen += dagenPerMaand[i];
		}
		return aantalDagen;
	}

	public boolean equals(Datum d) {
		if (this.jaar == d.getJaar() && this.maand == d.getMaand()
				&& this.dag == d.getDag()) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Datum o) {
		if (this.equals(o)) {
			return 0;
		} else if (this.kleinerDan(o)) {
			return 1;
		}
		return -1;

	}
}