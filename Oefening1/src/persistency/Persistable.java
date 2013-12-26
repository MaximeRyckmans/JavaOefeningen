package persistency;

import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;

public interface Persistable {
	
	public void getAlleOpdrachten(OpdrachtCatalogus opdrachtCatalogus);
	public void getAlleQuizzen(QuizCatalogus quizCatalogus);
	public void slaOpdrachtOp (OpdrachtCatalogus opdrachtCatalogus);
	public void slaQuizOp (QuizCatalogus quizCatalogus);
	public void verwijderQuiz(Quiz quiz);

}
