package persistency;

import model.Opdracht;
import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;

/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public interface Persistable {
	
	public void getAlleOpdrachten(OpdrachtCatalogus opdrachtCatalogus);
	public void getAlleQuizzen(OpdrachtCatalogus opdrachtCatalogus,QuizCatalogus quizCatalogus);
	public void slaOpdrachtOp (OpdrachtCatalogus opdrachtCatalogus, Opdracht opdracht);
	public void slaQuizOp (QuizCatalogus quizCatalogus,Quiz quiz);
	public void verwijderQuiz(Quiz quiz, QuizCatalogus quizCatalogus);
	public void verwijderOpdracht(Opdracht opdracht, OpdrachtCatalogus opdrachtCatalogus);
	public Opdracht getBepaaldeOpdracht(Integer i,OpdrachtCatalogus opdrachtCatalogus);
	public void wijzigQuiz(Quiz quiz,QuizCatalogus quizCatalogus);
	public void wijzigOpdracht(Opdracht opdracht, OpdrachtCatalogus opdrachtCatalogus);

}
