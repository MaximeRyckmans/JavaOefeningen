package collections;

import java.util.TreeSet;

import persistency.PersistencyFacade;
import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;

public class SorteerQuizzen {
	private TreeSet<Quiz> treeSet;
	private QuizCatalogus quizCatalogus;
	private OpdrachtCatalogus opdrachtCatalogus;
	private PersistencyFacade facade;
	
	public SorteerQuizzen(){
		quizCatalogus = new QuizCatalogus();
		opdrachtCatalogus = new OpdrachtCatalogus();
		facade = new PersistencyFacade();
		
		facade.getPersistable().getAlleQuizzen(opdrachtCatalogus, quizCatalogus);
		
		treeSet = new TreeSet<Quiz>(new QuizComparator());
		
		for (Quiz quiz : this.quizCatalogus.getQuizzen()) {
			treeSet.add(quiz);
		}
	}
	
	public void showQuizzen() {
		for (Quiz quiz : treeSet) {
			System.out.println(quiz.getOpdrachten().size() + " " + quiz.getOnderwerp());
		}
	}
	
	public static void main(String[] args){
		SorteerQuizzen sQ = new SorteerQuizzen();
		
		sQ.showQuizzen();
	}
}
