package model;

import java.util.LinkedList;
import java.util.List;

public class Quiz {

	private int aantalDeelnames;
	private int leerjaar;
	private Leraar leraar;
	private String onderwerp;
	private QuizStatus quizStatus;
	private List<Opdracht> opdrachten = new LinkedList<Opdracht>();

	public Quiz() {
	}
	
	public Quiz(int aantalDeelnames, int leerjaar, Leraar leraar, String onderwerp, QuizStatus quizStatus, List<Opdracht> opdrachten) {
		this.aantalDeelnames = aantalDeelnames;
		this.leerjaar = leerjaar;
		this.leraar = leraar;
		this.onderwerp = onderwerp;
		this.quizStatus = quizStatus;
		this.opdrachten = opdrachten;
	}

	public int getAantalDeelnames() {
		return aantalDeelnames;
	}

	public void setAantalDeelnames(int aantalDeelnames) {
		this.aantalDeelnames = aantalDeelnames;
	}

	public int getLeerjaar() {
		return leerjaar;
	}

	public void setLeerjaar(int leerjaar) {
			this.leerjaar = leerjaar;
	}

	public Leraar getLeraar() {
		return leraar;
	}

	public void setLeraar(Leraar leraar) {
		this.leraar = leraar;
	}

	public String getOnderwerp() {
		return onderwerp;
	}

	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}

	public QuizStatus getQuizStatus() {
		return quizStatus;
	}

	public void setQuizStatus(QuizStatus quizStatus) {
		this.quizStatus = quizStatus;
	}

	public void addOpdracht(List<Opdracht> opdracht) {
		try {
			for (Opdracht o : opdracht) {
				opdrachten.add(o);
			}
		} catch (NullPointerException ex) {
			System.out.println(ex);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aantalDeelnames;
		result = prime * result + leerjaar;
		result = prime * result + ((leraar == null) ? 0 : leraar.hashCode());
		result = prime * result
				+ ((onderwerp == null) ? 0 : onderwerp.hashCode());
		result = prime * result
				+ ((opdrachten == null) ? 0 : opdrachten.hashCode());
		result = prime * result
				+ ((quizStatus == null) ? 0 : quizStatus.hashCode());
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
		Quiz other = (Quiz) obj;
		if (aantalDeelnames != other.aantalDeelnames)
			return false;
		if (leerjaar != other.leerjaar)
			return false;
		if (leraar != other.leraar)
			return false;
		if (onderwerp == null) {
			if (other.onderwerp != null)
				return false;
		} else if (!onderwerp.equals(other.onderwerp))
			return false;
		if (opdrachten == null) {
			if (other.opdrachten != null)
				return false;
		} else if (!opdrachten.equals(other.opdrachten))
			return false;
		if (quizStatus != other.quizStatus)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quiz [aantalDeelnames=" + aantalDeelnames + ", leerjaar="
				+ leerjaar + ", leraar=" + leraar + ", onderwerp=" + onderwerp
				+ ", quizStatus=" + quizStatus + ", opdrachten=" + opdrachten
				+ "]";
	}
	
}
