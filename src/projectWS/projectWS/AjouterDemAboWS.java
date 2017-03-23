package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import com.mysql.jdbc.Connection;

public class AjouterDemAboWS {
	public String ajouterDem_Abo(String tournee, String code_client, String service, String tarif) throws Exception {

		String msg;
		AjouterReclamationWS c = new AjouterReclamationWS();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");

			String etat = "En attente";
			System.out.println("teeeeeest");
			Long lcode_client = Long.parseLong(code_client);
			System.out.println("cd cli " + lcode_client);
			Long ltournee = Long.parseLong(tournee);
			System.out.println(ltournee + " tourne ");

			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO demande_abonnement ( tournee, date,code_client,tarif) VALUES (?,?,?,?)");
			preparedStatement.setLong(1, ltournee);
			preparedStatement.setDate(2, date);
			preparedStatement.setLong(3, lcode_client);
			preparedStatement.setString(4, tarif);

			preparedStatement.executeUpdate();
			PreparedStatement preparedStatement2 = connection.prepareStatement(
					"INSERT INTO contrat ( cin, date,service,	demande_abonnement_id,etat) VALUES (?,?,?,?,?)");
			preparedStatement2.setString(1, getCinClient(lcode_client));
			preparedStatement2.setDate(2, date);
			preparedStatement2.setString(3, service);
			preparedStatement2.setString(4, getIdMax());

			preparedStatement2.setString(5, etat);
			preparedStatement2.executeUpdate();
			c.ajouterReclamation(getIdMaxContrat(), "reclamation client", "verification demande contrat", "");
			msg = "oui";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "non";
		}
		return msg;
	}

	public String getCinClient(Long id) {
		String cin = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select cin from client where id=" + id);
			while (rs.next()) {
				cin = rs.getString("cin");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return cin;

	}

	public String getIdMax() {
		Long id = 0l;
		String strLong = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select max(id) as maxid from demande_abonnement  ");
			while (rs.next()) {
				id = rs.getLong("maxid");
				strLong = Long.toString(id);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return strLong;
	}

	public String getIdMaxContrat() {
		String strLong = null;
		Long id = 0l;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select max(id) as maxid from contrat  ");
			while (rs.next()) {
				id = rs.getLong("maxid");
				strLong = Long.toString(id);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return strLong;
	}
}
