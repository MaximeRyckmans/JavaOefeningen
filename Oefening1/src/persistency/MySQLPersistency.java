package persistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Meerkeuze;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.Opsomming;
import model.Quiz;
import model.QuizCatalogus;
import model.Reproductie;

public class MySQLPersistency implements Persistable {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public void getAlleOpdrachten(OpdrachtCatalogus opdrachtCatalogus) {
		try {
			con = createConnection();
			String query = "select opdrachten.idopdrachten, opdrachten.vraag,opdrachten.antwoord,opdrachten.maxAantalpogingen,opdrachten.antwoordHint,opdrachten.maxAntwoordTijd, opdrachtcategorieën.opdrachtCategorieNaam,meerkeuzeopdrachten.alleKeuzes from opdrachten left join (`opdrachtcategorieën`, opdrachtsoorten, meerkeuzeopdrachten) ON (`opdrachtcategorieën`.`idopdrachtCategorieën` = opdrachten.opdrachtenCategorie and opdrachtsoorten.idOpdrachtSoorten = opdrachten.soortOpdracht and meerkeuzeopdrachten.idmeerkeuzeOpdrachten= opdrachten.idopdrachten) where opdrachtsoorten.OpdrachtSoortenNaam='Meerkeuze'";
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				int id = rs.getInt(1);
				String vraag = rs.getString(2);
				String antwoord = rs.getString(3);
				int maxAantalPogingen = rs.getInt(4);
				String antwoordHint = rs.getString(5);
				int maxAntwoordTijd = rs.getInt(6);
				OpdrachtCategorie opdrachtCategorie = OpdrachtCategorie
						.valueOf(rs.getString(7));
				String alleKeuzes = rs.getString(8);

				Opdracht opdr = new Meerkeuze(id, vraag, antwoord,
						maxAantalPogingen, alleKeuzes, antwoordHint,
						maxAntwoordTijd, opdrachtCategorie);
				opdrachtCatalogus.getOpdrachten().add(opdr);
			}

			query = "select opdrachten.idopdrachten, opdrachten.vraag,opdrachten.antwoord,opdrachten.maxAantalpogingen,opdrachten.antwoordHint,opdrachten.maxAntwoordTijd, opdrachtcategorieën.opdrachtCategorieNaam from opdrachten left join (`opdrachtcategorieën`, opdrachtsoorten, opsommingsopdrachten) ON (`opdrachtcategorieën`.`idopdrachtCategorieën` = opdrachten.opdrachtenCategorie and opdrachtsoorten.idOpdrachtSoorten = opdrachten.soortOpdracht and opsommingsopdrachten.idopsommingsOpdrachten= opdrachten.idopdrachten) where opdrachtsoorten.OpdrachtSoortenNaam='Opsomming'";
			rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String vraag = rs.getString(2);
				String antwoord = rs.getString(3);
				int maxAantalPogingen = rs.getInt(4);
				String antwoordHint = rs.getString(5);
				int maxAntwoordTijd = rs.getInt(6);
				OpdrachtCategorie opdrachtCategorie = OpdrachtCategorie
						.valueOf(rs.getString(7));
				Opdracht opdr = new Opsomming(vraag, antwoord,
						maxAantalPogingen, antwoordHint, maxAntwoordTijd,
						opdrachtCategorie);
				opdrachtCatalogus.getOpdrachten().add(opdr);
			}

			query = "select opdrachten.idopdrachten, opdrachten.vraag,opdrachten.antwoord,opdrachten.maxAantalpogingen,opdrachten.antwoordHint,opdrachten.maxAntwoordTijd, opdrachtcategorieën.opdrachtCategorieNaam,reproductieopdrachten.trefwoorden,reproductieopdrachten.minAantalTrefwoorden from opdrachten left join (`opdrachtcategorieën`, opdrachtsoorten, reproductieopdrachten) ON (`opdrachtcategorieën`.`idopdrachtCategorieën` = opdrachten.opdrachtenCategorie and opdrachtsoorten.idOpdrachtSoorten = opdrachten.soortOpdracht and reproductieopdrachten.idreproductieOpdrachten = opdrachten.idopdrachten) where opdrachtsoorten.OpdrachtSoortenNaam='Reproductie'";
			rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String vraag = rs.getString(2);
				String antwoord = rs.getString(3);
				int maxAantalPogingen = rs.getInt(4);
				String antwoordHint = rs.getString(5);
				int maxAntwoordTijd = rs.getInt(6);
				OpdrachtCategorie opdrachtCategorie = OpdrachtCategorie
						.valueOf(rs.getString(7));
				String trefwoorden = rs.getString(8);
				int minAantalJuisteTrefwoorden = rs.getInt(9);
				Opdracht opdr = new Reproductie(vraag, antwoord,
						maxAantalPogingen, antwoordHint, maxAntwoordTijd,
						trefwoorden, minAantalJuisteTrefwoorden,
						opdrachtCategorie);
				opdrachtCatalogus.getOpdrachten().add(opdr);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {

					rs.close();
				}
				if (st != null) {
					st.close();
				}
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

	private Connection createConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/quizdb2";
			String user = "root";
			String password = "root";

			con = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	private void closeConnection() {
		try {
			if (this.con != null) {
				this.con.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
