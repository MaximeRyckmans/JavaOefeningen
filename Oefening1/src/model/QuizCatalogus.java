package model;

import java.util.List;
/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public class QuizCatalogus {
	
	private List<Quiz> quizzen;

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
	
}
