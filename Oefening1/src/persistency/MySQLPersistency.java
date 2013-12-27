package persistency;

import java.sql.Connection;
import java.sql.DriverManager;

import model.Opdracht;
import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;

public class MySQLPersistency implements Persistable {
	
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/quizdb";
	String user="root";
	String password="";

	@Override
	public void getAlleOpdrachten(OpdrachtCatalogus opdrachtCatalogus) {
		try {
			con=DriverManager.getConnection(url, user, password);
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	@Override
	public void getAlleQuizzen(OpdrachtCatalogus opdrachtCatalogus,
			QuizCatalogus quizCatalogus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void slaOpdrachtOp(OpdrachtCatalogus opdrachtCatalogus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void slaQuizOp(QuizCatalogus quizCatalogus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verwijderQuiz(Quiz quiz) {
		// TODO Auto-generated method stub

	}

	@Override
	public Opdracht getBepaaldeOpdracht(Integer i,
			OpdrachtCatalogus opdrachtCatalogus) {
		// TODO Auto-generated method stub
		return null;
	}
}
