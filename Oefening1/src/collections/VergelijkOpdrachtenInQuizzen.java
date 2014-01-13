package collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Scanner;

import persistency.PersistencyFacade;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;

/**
 * 
 * @author Pulinx Davy
 *
 */

public class VergelijkOpdrachtenInQuizzen {
	
	private List<Quiz> quizList;
	private HashSet<Opdracht> opdr1, opdr2;
	private Quiz selectedQuiz;
	
	public VergelijkOpdrachtenInQuizzen(){
		quizList = new ArrayList<Quiz>();
		opdr1 = new HashSet<Opdracht>();
		opdr2 = new HashSet<Opdracht>();
		
		QuizCatalogus quizCatalogus = new QuizCatalogus();
		OpdrachtCatalogus opdrachtCatalogus = new OpdrachtCatalogus();
		PersistencyFacade facade = new PersistencyFacade();
		
		facade.getPersistable().getAlleOpdrachten(opdrachtCatalogus);
		facade.getPersistable().getAlleQuizzen(opdrachtCatalogus, quizCatalogus);
		
		for (Quiz quiz : quizCatalogus) {
			quizList.add(quiz);
			for (Opdracht opdracht : quiz.getOpdrachten()) {
				opdr2.add(opdracht);
			}
		}
		
	}
	
	public void getGemeenschappelijkeQuizzen(Quiz quiz){
		for (Opdracht opdracht : quiz.getOpdrachten()) {
			opdr1.add(opdracht);
		}
		
		opdr1.retainAll(opdr2);
	}
	
	public void showMenu(){
		try {
			int i = 1;
			int quizId;
			
			for (Quiz quiz : quizList) {
				System.out.println(i + ". " + quiz);
				i++;
			}
			
			System.out.println("Selecteer quiz: ");
			Scanner scanner = new Scanner(System.in);
			quizId = scanner.nextInt();
			quizId--;
			
			selectedQuiz = quizList.get(quizId);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void viewResult(){
		System.out.println("\n Geselecteerde quiz: " + selectedQuiz);
		System.out.println("Quizzen met gemeenschappelijke opdrachten:");
		for (Opdracht opdracht : opdr1) {
			for (Quiz quiz : quizList) {
				for (Opdracht opdracht2 : quiz.getOpdrachten()) {
					if (opdracht2.equals(opdracht)) {
						if (!selectedQuiz.equals(quiz)) {
							System.out.println("\tQuiz: " + quiz);
							System.out.println("\t\tOpdracht: " + opdracht2);
						}
					}
				}
			}
		}
	}
		
	public static void main(String[] args){
		VergelijkOpdrachtenInQuizzen vO = new VergelijkOpdrachtenInQuizzen();
		
		vO.showMenu();
		vO.getGemeenschappelijkeQuizzen(vO.selectedQuiz);
		vO.viewResult();
		
	}
}
