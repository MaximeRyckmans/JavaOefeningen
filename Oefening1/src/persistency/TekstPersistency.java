package persistency;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Klas;
import model.Leraar;
import model.Meerkeuze;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.Opsomming;
import model.Quiz;
import model.QuizCatalogus;
import model.QuizStatus;
import model.Reproductie;
/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public class TekstPersistency implements Persistable {

	@Override
	public void getAlleOpdrachten(OpdrachtCatalogus opdrachtCatalogus) {
		leesOpdrachtenVanBestand(opdrachtCatalogus);

	}

	@Override
	public void getAlleQuizzen(OpdrachtCatalogus opdrachtCatalogus,
			QuizCatalogus quizCatalogus) {
		leesQuizzenVanBestand(opdrachtCatalogus, quizCatalogus);
		
	}

	@Override
	public void slaOpdrachtOp(OpdrachtCatalogus opdrachtCatalogus, Opdracht opdracht) {
		opdrachtCatalogus.addOpdrachtToList(opdracht);
		schrijfOpdrachtenNaarBestand(opdrachtCatalogus);

	}
	

	@Override
	public Opdracht getBepaaldeOpdracht(Integer i,OpdrachtCatalogus opdrachtCatalogus) {
		return getBepaaldeOpdrachten(i,opdrachtCatalogus);
		
	}

	@Override
	public void slaQuizOp(QuizCatalogus quizCatalogus, Quiz quiz) {
		schrijfQuizzenNaarBestand(quizCatalogus);

	}

	@Override
	public void verwijderQuiz(Quiz quiz, QuizCatalogus quizCatalogus) {
		quizCatalogus.removeQuizFromList(quiz);
		schrijfQuizzenNaarBestand(quizCatalogus);

	}
	
	@Override
	public void verwijderOpdracht(Opdracht opdracht,
			OpdrachtCatalogus opdrachtCatalogus) {
		opdrachtCatalogus.removeOpdrachtFromList(opdracht);
		schrijfOpdrachtenNaarBestand(opdrachtCatalogus);
		
	}
	

	public void schrijfOpdrachtenNaarBestand(OpdrachtCatalogus opdrachtCatalogus) {
		File fileWrite = new File("bestanden/opdrachten");
		try {
			// Wegschrijven
			FileWriter writer = new FileWriter(fileWrite, false);
			for (int i = 0; i < opdrachtCatalogus.getOpdrachten().size(); i++) {
				Opdracht opdracht = opdrachtCatalogus.getOpdrachten().get(i);
				String typeOpdracht = opdracht.getClass().getSimpleName();
				String lijn = opdracht.getId() + "," + opdracht.getVraag()
						+ "," + opdracht.getAntwoord() + ","
						+ opdracht.getMaxAantalPogingen() + ","
						+ opdracht.getAntwoordHint() + ","
						+ opdracht.getmaxAntwoordTijd() + "," + typeOpdracht
						+ "," + opdracht.getOpdrachtCategorie();
				if (typeOpdracht.equals("Meerkeuze")) {
					lijn += "," + ((Meerkeuze) opdracht).getAlleKeuzes();
				} else if (opdracht.equals("Reproductie")) {
					lijn += ","
							+ ((Reproductie) opdracht).getTrefwoorden()
							+ ","
							+ ((Reproductie) opdracht)
									.getMinAantalJuisteTrefwoorden();
				}

				writer.write(lijn + "\n");
			}
			if (writer != null)
				writer.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void leesOpdrachtenVanBestand(OpdrachtCatalogus opdrachtCatalogus) {
		File file = new File("bestanden/opdrachten");
		if (file.exists()) {
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
					String soortOpdracht = velden[6];
					String opdrachtCategorieString = velden[7];
					OpdrachtCategorie opdrachtCategorie = OpdrachtCategorie
							.valueOf(opdrachtCategorieString);
					Opdracht opdracht = null;
					if (soortOpdracht.equals("Meerkeuze")) {
						String alleKeuzes = velden[8];
						opdracht = new Meerkeuze(vraag, antwoord,
								maxAantalPogingen, alleKeuzes, antwoordHint,
								maxAntwoordTijd, opdrachtCategorie);
						opdracht.setId(id);
					} else if (soortOpdracht.equals("Reproductie")) {
						String trefwoorden = velden[8];
						int minAantalJuisteTrefwoorden = Integer
								.parseInt(velden[9]);
						opdracht = new Reproductie(vraag, antwoordHint,
								maxAantalPogingen, antwoordHint,
								maxAntwoordTijd, trefwoorden,
								minAantalJuisteTrefwoorden, opdrachtCategorie);
					} else if (soortOpdracht.equals("Opsomming")) {
						opdracht = new Opsomming(vraag, antwoord,
								maxAantalPogingen, antwoordHint,
								maxAntwoordTijd, opdrachtCategorie);
					}
					opdrachtCatalogus.getOpdrachten().add(opdracht);
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
	}

	public Opdracht getBepaaldeOpdrachten(Integer i, OpdrachtCatalogus opdrachtCatalogus) {
		
		Opdracht opdracht = null;
		for (Opdracht opdr : opdrachtCatalogus.getOpdrachten()) {
			if (i.equals(opdr.getId())) {
				opdracht = opdr;
				return opdracht;
			}
		}
		opdracht = null;
		return opdracht;
	}
	

	public void schrijfQuizzenNaarBestand(QuizCatalogus quizCatalogus) {
		File file = new File("bestanden/quizzen");
		try {
			PrintWriter writer = new PrintWriter(file);
			for (int i = 0; i < quizCatalogus.getQuizzen().size(); i++) {
				Quiz quiz = quizCatalogus.getQuizzen().get(i);
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
	public void leesQuizzenVanBestand(OpdrachtCatalogus opdrachtCatalogus, QuizCatalogus quizCatalogus){
		
		  File file = new File("bestanden/quizzen");
		  List<Opdracht> opdrachten = new ArrayList<Opdracht>();
		  try{
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()){
		          String lijn = scanner.nextLine();
			  String [] velden = lijn.split(",");
			  int id = Integer.parseInt(velden[0]);
			  int aantalDeelnames=Integer.parseInt(velden[1]);
			  String leerjaarNaam=velden[2];
			  Klas leerjaar= Klas.valueOf(leerjaarNaam);
			
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
				  opdrachten.add(this.getBepaaldeOpdrachten(ids.get(i), opdrachtCatalogus));
			  }
			
			  Quiz quiz = new Quiz(id,aantalDeelnames, leerjaar, leraar, onderwerp, quizStatus, opdrachten);
			  quizCatalogus.getQuizzen().add(quiz);
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
