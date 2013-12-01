package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 * 
 */
public class OpdrachtCatalogus implements Cloneable,
		Comparable<OpdrachtCatalogus>, Iterable<Opdracht> {

	private List<Opdracht> opdrachten;
	private int id;
	
	public OpdrachtCatalogus(){
		opdrachten = new ArrayList<Opdracht>();
	}
	
	public List<Opdracht> getOpdrachten() {
		return opdrachten;
	}

	public void setOpdrachten(List<Opdracht> opdrachten) {
		this.opdrachten = opdrachten;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addOpdrachtToList(Opdracht opdracht) {
		if (!opdracht.equals(null) || !opdrachten.contains(opdracht)) {
			this.opdrachten.add(opdracht);
		}
	}

	public void removeOpdrachtFromList(Opdracht opdracht) {
		if (opdrachten.contains(opdracht)) {
			this.opdrachten.remove(opdracht);
		}
	}

	@Override
	public int compareTo(OpdrachtCatalogus o) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (this == o)
			return EQUAL;

		if (this.id < o.id)
			return BEFORE;
		return AFTER;
	}

	@Override
	public String toString() {
		return "OpdrachtCatalogus [opdrachten=" + opdrachten + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((opdrachten == null) ? 0 : opdrachten.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpdrachtCatalogus other = (OpdrachtCatalogus) obj;
		if (opdrachten == null) {
			if (other.opdrachten != null)
				return false;
		} else if (!opdrachten.equals(other.opdrachten))
			return false;
		return true;
	}

	@Override
	public Iterator<Opdracht> iterator() {
		return opdrachten.iterator();
	}

	public void schrijfOpdrachtenNaarBestand() {
		File file = new File("bestanden\\opdrachten");
		try {
			PrintWriter writer = new PrintWriter(file);
			for (int i = 0; i < this.getOpdrachten().size(); i++) {
				Opdracht opdracht = opdrachten.get(i);
				String lijn = opdracht.getId() + "," + opdracht.getVraag()
						+ "," + opdracht.getAntwoord() + ","
						+ opdracht.getMaxAantalPogingen() + ","
						+ opdracht.getAntwoordHint() + ","
						+ opdracht.getmaxAntwoordTijd() + ","
						+ opdracht.getClass();
				writer.println(lijn);
			}
			if (writer != null)
				writer.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void leesOpdrachtenVanBestand() {

		File file = new File("bestanden/opdrachten");

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String lijn = scanner.nextLine();
				String[] velden = lijn.split(",");
				int id = Integer.parseInt(velden[0]);
				String vraag = velden[1];
				String antwoord = velden[2];
				int maxAantalPogingen = Integer.parseInt(velden[3]);
				String antwoordHint = velden[4];
				int maxAntwoordTijd = Integer.parseInt(velden[5]);
				String klasNaam = velden[6];
				Opdracht opdracht = null;
				if (klasNaam.equals("Meerkeuze")) {
					String alleKeuzes = velden[7];
					opdracht = new Meerkeuze(vraag, antwoord,
							maxAantalPogingen, alleKeuzes, antwoordHint,
							maxAntwoordTijd);
					opdracht.setId(id);
				} else if (klasNaam.equals("Reproductie")) {
					String trefwoorden = velden[7];
					int minAantalJuisteTrefwoorden = Integer
							.parseInt(velden[8]);
					opdracht = new Reproductie(vraag, antwoordHint,
							maxAantalPogingen, antwoordHint, maxAntwoordTijd,
							trefwoorden, minAantalJuisteTrefwoorden);
				} else if (klasNaam.equals("Opsomming")) {
					opdracht = new Opsomming(vraag, antwoord,
							maxAantalPogingen, antwoordHint, maxAntwoordTijd);
				}
				this.opdrachten.add(opdracht);
				
			}
			if (scanner != null) {
				scanner.close();
			}
		} catch (FileNotFoundException ex) {
			System.out.println("bestand niet gevonden");
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println("here");
			System.out.println(ex.getMessage());
		}
	}

	public List<Opdracht> LeesBepaaldeOpdrachtenVanBestand(List<Integer> ids) {

		File file = new File("bestanden\\opdrachten.txt");
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String lijn = scanner.nextLine();
				String[] velden = lijn.split(",");
				if (ids.contains(Integer.parseInt(velden[0]))) {
					int id = Integer.parseInt(velden[0]);
					String vraag = velden[1];
					String antwoord = velden[2];
					int maxAantalPogingen = Integer.parseInt(velden[3]);
					String antwoordHint = velden[4];
					int maxAntwoordTijd = Integer.parseInt(velden[4]);
					String klasNaam = velden[5];
					Opdracht opdracht = null;
					if (klasNaam.equals("Meerkeuze")) {
						String alleKeuzes = velden[6];
						opdracht = new Meerkeuze(vraag, antwoord,
								maxAantalPogingen, alleKeuzes, antwoordHint,
								maxAntwoordTijd);
						opdracht.setId(id);
					} else if (klasNaam.equals("Reproductie")) {
						String trefwoorden = velden[6];
						int minAantalJuisteTrefwoorden = Integer
								.parseInt(velden[7]);
						opdracht = new Reproductie(vraag, antwoordHint,
								maxAantalPogingen, antwoordHint,
								maxAntwoordTijd, trefwoorden,
								minAantalJuisteTrefwoorden);
					} else if (klasNaam.equals("Opsomming")) {
						opdracht = new Opsomming(vraag, antwoord,
								maxAantalPogingen, antwoordHint,
								maxAntwoordTijd);
					}
					this.opdrachten.add(opdracht);
				}
			}
			if (scanner != null) {
				scanner.close();
			}
		} catch (FileNotFoundException ex) {
			System.out.println("bestand niet gevonden");
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return this.opdrachten;
	}
}
