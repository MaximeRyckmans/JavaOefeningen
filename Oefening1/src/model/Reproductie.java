package model;

public class Reproductie extends Opdracht {

	/**
	 * @author Davy Pulinx
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	private String trefwoorden;
	private int minAantalJuisteTrefwoorden;
	
	public Reproductie() {}
	
	public Reproductie(String vraag, String antwoord, int maxAantalPogingen, 
			String trefwoorden, int minAantalJuisteTrefwoorden) {
		super(vraag, antwoord, maxAantalPogingen);
		
		this.setTrefwoorden(trefwoorden);
		this.setMinAantalJuisteTrefwoorden(minAantalJuisteTrefwoorden);
	}
	
	public Reproductie(String vraag, String antwoord, int maxAantalPogingen, String antwoordHint, 
			String trefwoorden, int minAantalJuisteTrefwoorden) {
		super(vraag, antwoord, maxAantalPogingen, antwoordHint);
		
		this.setTrefwoorden(trefwoorden);
		this.setMinAantalJuisteTrefwoorden(minAantalJuisteTrefwoorden);
	}
	
	public Reproductie(String vraag, String antwoord, int maxAantalPogingen, int maxAntwoordTijd, 
			String trefwoorden, int minAantalJuisteTrefwoorden) {
		super(vraag, antwoord, maxAantalPogingen, maxAntwoordTijd);
		
		this.setTrefwoorden(trefwoorden);
		this.setMinAantalJuisteTrefwoorden(minAantalJuisteTrefwoorden);
	}
	
	public Reproductie(String vraag, String antwoord, int maxAantalPogingen, String antwoordHint, int maxAntwoordTijd,
			String trefwoorden, int minAantalJuisteTrefwoorden) {
		super(vraag, antwoord, maxAantalPogingen, antwoordHint, maxAntwoordTijd);
	}

	public String getTrefwoorden() {
		return trefwoorden;
	}

	public void setTrefwoorden(String trefwoorden) {
		this.trefwoorden = trefwoorden;
	}

	public int getMinAantalJuisteTrefwoorden() {
		return minAantalJuisteTrefwoorden;
	}

	public void setMinAantalJuisteTrefwoorden(int minAantalJuisteTrefwoorden) {
		this.minAantalJuisteTrefwoorden = minAantalJuisteTrefwoorden;
	}

	@Override
	public boolean isJuisteAntwoord(String antwoord) {
		String delimiter = ";";
		String[] tempTrefwoorden = trefwoorden.split(delimiter);
		
		for (int i = 0; i < tempTrefwoorden.length; i++) {
			if (antwoord.toLowerCase().contains(tempTrefwoorden[i].toLowerCase())) {
				return true;
			}
			else if (i++ >= minAantalJuisteTrefwoorden) {
				return true;
			}
		}	
		return false;
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

	@Override
	public String toString() {
		return "/nType= Reproductie /ntrefwoorden=" + trefwoorden
				+ "/nminAantalJuisteTrefwoorden=" + minAantalJuisteTrefwoorden;
	}

}
