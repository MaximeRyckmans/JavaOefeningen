package collections;

import java.util.Comparator;

import model.Quiz;

public class QuizComparator implements Comparator<Quiz> {

	@Override
	public int compare(Quiz o1, Quiz o2) {
		int i = 0;
		
		if (o1.getOpdrachten().size() > o2.getOpdrachten().size()) {
			i = -1;
		}else if (o1.getOpdrachten().size() == o2.getOpdrachten().size()) {
			i = o1.compareTo(o2);
		}else if (o1.getOpdrachten().size() < o2.getOpdrachten().size()) {
			i = 1;
		}
		
		return i;
	}

}
