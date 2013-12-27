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
	public void slaOpdrachtOp (OpdrachtCatalogus opdrachtCatalogus);
	public void slaQuizOp (QuizCatalogus quizCatalogus);
	public void verwijderQuiz(Quiz quiz);
	public Opdracht getBepaaldeOpdracht(Integer i,OpdrachtCatalogus opdrachtCatalogus);

}
