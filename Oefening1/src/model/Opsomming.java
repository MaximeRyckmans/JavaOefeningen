package model;

public class Opsomming extends Opdracht implements Valideerbaar{

	/**
	 * @author Davy Pulinx
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	private String valideerTekst = "Nog niet gevalideerd";
	
	public Opsomming() {
		
	}
	
	public Opsomming(String vraag, String antwoord, int maxAantalPogingen, String antwoordHint, int maxAntwoordTijd) {
		super(vraag, antwoord, maxAantalPogingen, antwoordHint, maxAntwoordTijd);
	}

	@Override
	public boolean isJuisteAntwoord(String antwoord) {
		if (super.getAntwoord().toLowerCase() == antwoord.toLowerCase()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValide(String antwoord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getValideerTekst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Opdracht o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
