package model;

public class Opdracht {
	
	private String vraag;
	private String antwoord;
	private int maxAantalPogingen;
	private String antwoordHint;
	private int maxAntwoordTijd;  ///ee
	
	public Opdracht(){
	}
	
	public Opdracht(String vraag, String antwoord, int maxAantalPogingen, String antwoordHint, int maxAntwoordTijd) {
		this.vraag = vraag;
		this.antwoord = antwoord;
		this.maxAantalPogingen = maxAantalPogingen;
		this.antwoordHint = antwoordHint;
		this.maxAntwoordTijd = maxAntwoordTijd;
	}

	public String getVraag() {
		return vraag;
	}

	public void setVraag(String vraag) {
		this.vraag = vraag;
	}

	public String getAntwoord() {
		return antwoord;
	}

	public void setAntwoord(String antwoord) {
		this.antwoord = antwoord;
	}

	public int getMaxAantalPogingen() {
		return maxAantalPogingen;
	}

	public void setMaxAantalPogingen(int maxAantalPogingen) {
		this.maxAantalPogingen = maxAantalPogingen;
	}

	public String getAntwoordHint() {
		return antwoordHint;
	}

	public void setAntwoordHint(String antwoordHint) {
		this.antwoordHint = antwoordHint;
	}

	public int getmaxAntwoordTijd() {
		return maxAntwoordTijd;
	}

	public void setmaxAntwoordTijd(int maxAntwoordTijd) {
		this.maxAntwoordTijd = maxAntwoordTijd;
	}
	
	public boolean isJuisteAntwoord(String antwoord) {
		if (this.antwoord == antwoord) {
			return true;
		}
		
		return false;
	}

}
