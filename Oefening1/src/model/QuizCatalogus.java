package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import test.LeraarTest;
/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public class QuizCatalogus implements Comparable<QuizCatalogus>, Cloneable, Iterable<Quiz> {
	private int id;
	private List<Quiz> quizzen	=new	ArrayList<Quiz>();

	public List<Quiz> getQuizzen() {
		return quizzen;
	}

	public void setQuizzen(List<Quiz> quizzen) {
		this.quizzen = quizzen;
	}
	public void addQuizToList(Quiz quiz){
		if(!quizzen.equals(null) || !quizzen.contains(quiz)){
			this.quizzen.add(quiz);
		}
	}
	public void removeQuizFromList(Quiz quiz){
		if(quizzen.contains(quiz)){
			this.quizzen.remove(quiz);
		}
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Iterator<Quiz> iterator() {
		return quizzen.iterator();
	}
	//Compares different catalogi to eachother, but I don't know if this is necessary
	@Override
	public int compareTo(QuizCatalogus o) {
		if(this.id == o.id){
			return 0;
		}else if(this.id < o.id){
			return -1;
		}
		return 1;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((quizzen == null) ? 0 : quizzen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuizCatalogus other = (QuizCatalogus) obj;
		if (id != other.id)
			return false;
		if (quizzen == null) {
			if (other.quizzen != null)
				return false;
		} else if (!quizzen.equals(other.quizzen))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuizCatalogus [id=" + id + ", quizzen=" + quizzen + "]";
	}
	
	public void schrijfQuizzenNaarBestand() {
		File file = new File("bestanden/quizzen");
		try {
			PrintWriter writer = new PrintWriter(file);
			for (int i = 0; i < this.getQuizzen().size(); i++) {
				Quiz quiz = quizzen.get(i);
				String lijn = quiz.getId() + "," + quiz.getAantalDeelnames()
						+ "," + quiz.getLeerjaar() + ","
						+ quiz.getLeraar() + ","
						+ quiz.getOnderwerp() + ","
						+ quiz.getQuizStatus()+","+quiz.getOpdrachten();
				writer.println(lijn);
			}
			if (writer != null)
				writer.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void leesQuizzenVanBestand(){
		OpdrachtCatalogus opdrc = new OpdrachtCatalogus();
		  File file = new File("bestanden/quizzen");
		  List<Opdracht> opdrachten = new ArrayList<Opdracht>();
		  try{
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()){
		          String lijn = scanner.nextLine();
			  String [] velden = lijn.split(",");
			  int id = Integer.parseInt(velden[0]);
			  int aantalDeelnames=Integer.parseInt(velden[1]);
			  int leerjaar=Integer.parseInt(velden[2]);
			
			  String onderwerp=velden[3];
			  String quizStatusNaam = velden[4];
			  QuizStatus quizStatus= QuizStatus.valueOf(quizStatusNaam);
			  String leraarNaam=velden[5]+velden[6];
			  Leraar leraar = Leraar.valueOf(leraarNaam);
			  List<Integer>ids = new ArrayList<Integer>();
			  
			  for(int i=7; i< velden.length;i++){
				  ids.add(Integer.parseInt(velden[i]));
			  }
			  
			  for(int i = 0; i< ids.size(); i++){
				  opdrachten.add(opdrc.LeesBepaaldeOpdrachtenVanBestand(ids));
			  }
			//  List<Opdracht> opdrachten = opdrc.LeesBepaaldeOpdrachtenVanBestand(ids);
			  Quiz quiz = new Quiz(id,aantalDeelnames, leerjaar, leraar, onderwerp, quizStatus, opdrachten);
			  quizzen.add(quiz);
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
