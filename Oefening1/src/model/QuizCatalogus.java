package model;

import java.util.Iterator;
import java.util.List;
/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public class QuizCatalogus implements Comparable<QuizCatalogus>, Cloneable, Iterable<Quiz> {
	private int id;
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
	
	
}
