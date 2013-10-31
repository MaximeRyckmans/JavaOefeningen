package model;

import java.io.Serializable;

/**
 * @author Pulinx Davy
 * @version 1.0
 */

public abstract class Opdracht implements Cloneable, Comparable<Opdracht>, Serializable {
	
	/**
	 * Categorie van opdracht moet nog toegevoegd worden??
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String vraag;
	private String antwoord;
	private int maxAantalPogingen;
	private String antwoordHint;
	private int maxAntwoordTijd;
	
	public Opdracht(){}
	
	public Opdracht(String vraag, String antwoord, int maxAantalPogingen){
		this.vraag = vraag;
		this.antwoord = antwoord;
		if (maxAantalPogingen > 1) {
			this.maxAantalPogingen = maxAantalPogingen;
		}else {
			this.maxAantalPogingen = 1;
		}
	}
	
	public Opdracht(String vraag, String antwoord, int maxAantalPogingen, String antwoordHint) {
		this(vraag, antwoord, maxAantalPogingen);
		this.antwoordHint = antwoordHint;
	}
	
	public Opdracht(String vraag, String antwoord, int maxAantalPogingen, int maxAntwoordTijd) {
		this(vraag, antwoord, maxAantalPogingen);
		this.maxAntwoordTijd = maxAntwoordTijd;
	}
	
	public Opdracht(String vraag, String antwoord, int maxAantalPogingen, String antwoordHint, int maxAntwoordTijd) {
		this(vraag, antwoord, maxAantalPogingen, antwoordHint);
		this.maxAntwoordTijd = maxAntwoordTijd;
	}

	public String getVraag() {
		return vraag;
	}

	public void setVraag(String vraag) {
		this.vraag = vraag;
	}

	@Override
	public String toString() {
		return "Opdracht [Vraag=" + vraag + "/nAntwoord=" + antwoord
				+ "/nMaximum aantal pogingen=" + maxAantalPogingen
				+ "/nHint=" + antwoordHint + "/nMaximum antwoord tijd="
				+ maxAntwoordTijd + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((antwoord == null) ? 0 : antwoord.hashCode());
		result = prime * result
				+ ((antwoordHint == null) ? 0 : antwoordHint.hashCode());
		result = prime * result + maxAantalPogingen;
		result = prime * result + maxAntwoordTijd;
		result = prime * result + ((vraag == null) ? 0 : vraag.hashCode());
		return result;
	}

	public boolean equals(Opdracht o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Opdracht other = (Opdracht) o;
		if (antwoord == null) {
			if (other.antwoord != null)
				return false;
		} else if (!antwoord.equals(other.antwoord))
			return false;
		if (antwoordHint == null) {
			if (other.antwoordHint != null)
				return false;
		} else if (!antwoordHint.equals(other.antwoordHint))
			return false;
		if (maxAantalPogingen != other.maxAantalPogingen)
			return false;
		if (maxAntwoordTijd != other.maxAntwoordTijd)
			return false;
		if (vraag == null) {
			if (other.vraag != null)
				return false;
		} else if (!vraag.equals(other.vraag))
			return false;
		return true;
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
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public abstract boolean isJuisteAntwoord(String antwoord);
	
	@Override
	public int compareTo(Opdracht o){
		final int BEFORE = -1;
		final int  EQUAL = 0;
		final int AFTER = 1;
		
		if(this == o) return EQUAL;
		
		if (this.id < o.id) return BEFORE;
		return AFTER;
	}
	
	
}
