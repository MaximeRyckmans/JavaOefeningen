package model;

import java.util.HashMap;
import java.util.Map;

public class Meerkeuze extends Opdracht implements Valideerbaar {

	/**
	 * @author Davy Pulinx
	 * @version 1.0 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer, String> keuzesMap;
	private String valideerTekst = "Nog niet gevalideerd";
	private String alleKeuzes;
	
	/*
	 * Constructors
	 */
	public Meerkeuze(){}
	
	public Meerkeuze(String vraag, String antwoord, int maxAantalPogingen, String alleKeuzes, OpdrachtCategorie opdrachtCategorie){
		super(vraag, antwoord, maxAantalPogingen, opdrachtCategorie);
		
		this.alleKeuzes = alleKeuzes;
		samenstellenKeuzes(this.alleKeuzes);
		isAntwoordInKeuzes(antwoord);
	}
	
	public Meerkeuze(String vraag, String antwoord, int maxAantalPogingen, String alleKeuzes, String antwoordHint, OpdrachtCategorie opdrachtCategorie) {
		super(vraag, antwoord, maxAantalPogingen, antwoordHint, opdrachtCategorie);
		
		this.alleKeuzes = alleKeuzes;
		samenstellenKeuzes(this.alleKeuzes);
		isAntwoordInKeuzes(antwoord);
	}
	
	public Meerkeuze(String vraag, String antwoord, int maxAantalPogingen, String alleKeuzes, int maxAntwoordTijd, OpdrachtCategorie opdrachtCategorie) {
		super(vraag, antwoord, maxAantalPogingen, maxAntwoordTijd, opdrachtCategorie);
		
		this.alleKeuzes = alleKeuzes;
		samenstellenKeuzes(this.alleKeuzes);
		isAntwoordInKeuzes(antwoord);
	}
	
	public Meerkeuze(String vraag, String antwoord, int maxAantalPogingen, String alleKeuzes, String antwoordHint, int maxAntwoordTijd, OpdrachtCategorie opdrachtCategorie) {
		super(vraag, antwoord, maxAantalPogingen, antwoordHint, maxAntwoordTijd, opdrachtCategorie);
		
		this.alleKeuzes = alleKeuzes;
		samenstellenKeuzes(this.alleKeuzes);
		isAntwoordInKeuzes(antwoord);
	}
	
	public Meerkeuze(int id, String vraag, String antwoord, int maxAantalPogingen, String alleKeuzes, String antwoordHint, int maxAntwoordTijd, OpdrachtCategorie opdrachtCategorie) {
		super(id, vraag, antwoord, maxAantalPogingen, antwoordHint, maxAntwoordTijd, opdrachtCategorie);
		
		this.alleKeuzes = alleKeuzes;
		samenstellenKeuzes(this.alleKeuzes);
		isAntwoordInKeuzes(antwoord);
	}
	
	/*
	 * Methode om te checken of het juiste antwoord wel in de keuzes aanwezig is.
	 */
	private boolean isAntwoordInKeuzes(String antwoord){
		if (!keuzesMap.containsValue(antwoord)) {
			keuzesMap.clear();
			return false;
			//throw new IllegalArgumentException("De gegeven keuzes bevatten niet het juiste antwoord");
		}
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see model.Opdracht#isJuisteAntwoord(java.lang.String)
	 */
	@Override
	public boolean isJuisteAntwoord(String antwoord) {
		try{
		int integer = Integer.parseInt(antwoord);
		
		if (super.getAntwoord() == keuzesMap.get(integer)) {
			return true;
		}
		}catch(NumberFormatException nfe){
			System.out.println("Het gegeven antwoord is geen geldig cijfer");
		}
		
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see model.Valideerbaar#isValide(java.lang.String)
	 */
	@Override
	public boolean isValide(String antwoord) {
		try{
			int integer = Integer.parseInt(antwoord);
			
			if (integer > 0 && integer < keuzesMap.size()) {
				this.valideerTekst = "Het ingegeven antwoord is een mogelijke keuze";
				return true;
			}else {
				this.valideerTekst = "Het ingegeven antwoord behoort niet tot de juiste mogelijkheden";
				return false;
			}
			}catch (NumberFormatException nfe) {
				this.valideerTekst = "Het gegeven antwoord is geen geldig cijfer";
				return false;
			}
	}

	/*
	 * (non-Javadoc)
	 * @see model.Valideerbaar#getValideerTekst()
	 */
	@Override
	public String getValideerTekst() {
		return valideerTekst;
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

	public Map<Integer, String> getKeuzesMap() {
		return keuzesMap;
	}

	public void setKeuzesMap(Map<Integer, String> keuzesMap) {
		this.keuzesMap = keuzesMap;
	}
	
	public String getAlleKeuzes() {
		return alleKeuzes;
	}

	public void setAlleKeuzes(String alleKeuzes) {
		this.alleKeuzes = alleKeuzes;
	}

	private void samenstellenKeuzes(String alleKeuzes){
		String delimiter = ";";
		String[] temp = alleKeuzes.split(delimiter);
		
		keuzesMap = new HashMap<Integer, String>();
		
		for (int i = 0; i < temp.length; i++) {
			keuzesMap.put(i++, temp[i]);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see model.Opdracht#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	

}
