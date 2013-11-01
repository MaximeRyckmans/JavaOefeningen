package model;

public class Opsomming extends Opdracht implements Valideerbaar{

	/**
	 * @author Davy Pulinx
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	private String valideerTekst = "Nog niet gevalideerd";
	
	/*
	 * Constructors
	 */
	public Opsomming() {}
	
	public Opsomming(String vraag, String antwoord, int maxAantalPogingen){
		super(vraag, antwoord, maxAantalPogingen);
	}
	
	public Opsomming(String vraag, String antwoord, int maxAantalPogingen, String antwoordHint) {
		super(vraag, antwoord, maxAantalPogingen, antwoordHint);
	}
	
	public Opsomming(String vraag, String antwoord, int maxAantalPogingen, int maxAntwoordTijd){
		super(vraag, antwoord, maxAantalPogingen, maxAntwoordTijd);
	}
	
	public Opsomming(String vraag, String antwoord, int maxAantalPogingen, String antwoordHint, int maxAntwoordTijd) {
		super(vraag, antwoord, maxAantalPogingen, antwoordHint, maxAntwoordTijd);
	}

	/*
	 * (non-Javadoc)
	 * @see model.Opdracht#isJuisteAntwoord(java.lang.String)
	 */
	@Override
	public boolean isJuisteAntwoord(String antwoord) {
		if (super.getAntwoord().toLowerCase() == antwoord.toLowerCase()) {
			return true;
		}
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see model.Valideerbaar#isValide(java.lang.String) 
	 */
	@Override
	public boolean isValide(String antwoord) {
		String delimiter = ";";
		String[] tempAntwoord = antwoord.split(delimiter);
		String[] tempJuistAntwoord = super.getAntwoord().split(delimiter);
		
		if (tempJuistAntwoord.length > 1) {
			if (!antwoord.contains(delimiter)) {
				this.valideerTekst = "Het antwoord is niet gesplitst met de het nodige ';' teken";
				return false;
			}else if (tempAntwoord.length < tempJuistAntwoord.length) {
				this.valideerTekst = "Het antwoord bevat niet genoeg waarden";
				return false;
			}else if (tempAntwoord.length > tempJuistAntwoord.length) {
				this.valideerTekst = "Het antwoord bevat te veel waarden";
				return false;
			}else {
				this.valideerTekst = "Het antwoord bevat het juiste aantal waarden";
				return true;
			}
		}else {
			if (tempAntwoord.length > 1) {
				this.valideerTekst = "Het antwoord bevat te veel waarden";
				return false;
			}else {
				this.valideerTekst = "Het antwoord bevat het juiste aantal waarden";
				return true;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see model.Valideerbaar#getValideerTekst() 
	 */
	@Override
	public String getValideerTekst() {
		return this.valideerTekst;
	}

	/*
	 * (non-Javadoc)
	 * @see model.Opdracht#compareTo(model.Opdracht) 
	 */
	@Override
	public int compareTo(Opdracht o) {
		final int BEFORE = -1;
		final int  EQUAL = 0;
		final int AFTER = 1;
		
		if(this == o) return EQUAL;
		
		if (super.getId() < o.getId()) return BEFORE;
		return AFTER;
	}

	/*
	 * (non-Javadoc)
	 * @see model.Opdracht#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "/nType= Opsomming /nvalideerTekst=" + valideerTekst;
	}
	
	

}
