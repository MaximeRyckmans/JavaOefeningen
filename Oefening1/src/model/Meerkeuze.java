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
	
	public Meerkeuze(){
		
	}
	
	public Meerkeuze(String vraag, String antwoord, int maxAantalPogingen, String antwoordHint, int maxAntwoordTijd, 
			String alleKeuzes){
		super(vraag, antwoord, maxAantalPogingen, antwoordHint, maxAntwoordTijd);
		
		samenstellenKeuzes(alleKeuzes);
		
		if (!keuzesMap.containsValue(antwoord)) {
			keuzesMap.clear();
			throw new IllegalArgumentException("De gegeven keuzes bevatten niet het juiste antwoord");
		}
	}
	
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

	@Override
	public String getValideerTekst() {
		return valideerTekst;
	}

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
	
	public void samenstellenKeuzes(String alleKeuzes){
		String delimiter = ";";
		String[] temp = alleKeuzes.split(delimiter);
		
		keuzesMap = new HashMap<Integer, String>();
		
		for (int i = 0; i < temp.length; i++) {
			keuzesMap.put(i++, temp[i]);
		}
	}

	@Override
	public String toString() {
		return super.toString() + "/nMeerkeuze [keuzesMap=" + keuzesMap + "]";
	}

	

}
