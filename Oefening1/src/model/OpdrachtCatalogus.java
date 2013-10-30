package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public class OpdrachtCatalogus implements Cloneable,Comparable<OpdrachtCatalogus>, Iterable<Opdracht>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8220101486039682153L;
	private List<Opdracht> opdrachten;
	private int id;

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

	public void addOpdrachtToList(Opdracht opdracht){
		if(!opdracht.equals(null) || !opdrachten.contains(opdracht)){
			this.opdrachten.add(opdracht);
		}
	}
	public void removeOpdrachtFromList(Opdracht opdracht){
		if(opdrachten.contains(opdracht)){
			this.opdrachten.remove(opdracht);
		}
	}

	@Override
	public int compareTo(OpdrachtCatalogus o) {
		final int BEFORE = -1;
		final int  EQUAL = 0;
		final int AFTER = 1;
		
		if(this == o) return EQUAL;
		
		if (this.id < o.id) return BEFORE;
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
		File file = new File("bestanden\\opdrachten.txt");
		try {
			PrintWriter writer = new PrintWriter(file);
			for (int i = 0; i < this.getOpdrachten().size(); i++) {
				Opdracht opdracht = opdrachten.get(i);
				String lijn = opdracht.getId() + "," + opdracht.getVraag()
						+ "," + opdracht.getAntwoord() + ","
						+ opdracht.getMaxAantalPogingen() + ","
						+ opdracht.getAntwoordHint() + ","
						+ opdracht.getmaxAntwoordTijd();
				writer.println(lijn);
			}
			if (writer != null)
				writer.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	//Reads opdrachten from a text file, each line in the file is a new opdacht object. Currently having trouble with how to cope with the different opdrachten.
	public void leesOpdrachtenVanBestand(){
		  File file = new File("bestanden\\opdrachten.txt");
		  try{
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()){
		          String lijn = scanner.nextLine();
			  String [] velden = lijn.split(",");
			  int id = Integer.parseInt(velden[0]);
			  String vraag= velden[1];
			  String antwoord = velden[2];
			  int maxAantalPogingen = Integer.parseInt(velden[3]);
			  String antwoordHint=velden[4];
			  int maxAntwoordTijd=Integer.parseInt(velden[4]);
			//  Opdracht opdracht=new Opdracht(vraag,antwoord,maxAantalPogingen,antwoordHint, maxAntwoordTijd);
		//	  this.opdrachten.add(opdracht);
			}
			if (scanner!=null){
			  scanner.close();
			}
		  }
		  catch(FileNotFoundException ex){
		    System.out.println("bestand niet gevonden");
		  }
		  catch(Exception ex){
		    System.out.println(ex.getMessage());
		  }
		}
	
	
}
