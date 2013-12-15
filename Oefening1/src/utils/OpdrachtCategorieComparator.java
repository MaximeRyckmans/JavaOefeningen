package utils;

import java.util.Comparator;

import model.Opdracht;

public class OpdrachtCategorieComparator implements Comparator<Opdracht> {

	@Override
	public int compare(Opdracht o1, Opdracht o2) {
		int comparator = o1.getOpdrachtCategorie().compareTo(
				o2.getOpdrachtCategorie());
		if (comparator == 0) {
			comparator = o1.getVraag().compareTo(o2.getVraag());
		}
		return comparator;
	}

}
