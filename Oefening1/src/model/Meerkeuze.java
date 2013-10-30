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
	
	@Override
	public boolean isJuisteAntwoord(String antwoord) {
		int integer = Integer.parseInt(antwoord);
		
		if (super.getAntwoord() == keuzesMap.get(integer)) {
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
