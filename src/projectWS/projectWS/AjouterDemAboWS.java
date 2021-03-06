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
int a;
		String msg="non";
		AjouterReclamationWS c = new AjouterReclamationWS();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT c.id FROM contrat c, demande_abonnement d WHERE d.tournee = "+tournee +" AND c.demande_abonnement_id = d.id AND c.service = '"+ service +"'");
			String etat = "En attente";
			Long lcode_client = Long.parseLong(code_client);
			Long ltournee = Long.parseLong(tournee);
			boolean empty=true;
			while (rs.next()) {
				empty=false;}
			if(empty){
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO demande_abonnement ( tournee, date,code_client,tarif) VALUES (?,?,?,?)");
			preparedStatement.setLong(1, ltournee);
			preparedStatement.setDate(2, date);
			preparedStatement.setLong(3, lcode_client);
			preparedStatement.setString(4, tarif);

			preparedStatement.executeUpdate();
			PreparedStatement preparedStatement2 = connection.prepareStatement(
					"INSERT INTO contrat ( cin, date,datePoseCompteur,service,demande_abonnement_id,etat) VALUES (?,?,?,?,?,?)");
			preparedStatement2.setString(1, getCinClient(lcode_client));
			preparedStatement2.setDate(2, date);
			preparedStatement2.setDate(3, date);
			preparedStatement2.setString(4, service);
			preparedStatement2.setString(5, getIdMax());

			preparedStatement2.setString(6, etat);
			preparedStatement2.executeUpdate();
			c.ajouterReclamation(getIdMaxContrat(), "reclamation client", "verification demande contrat", "");
			msg = "oui";}
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

	public int verifierTournee(String tournee, String service) {
		int a = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select tournee  from demande_abonnement and contrat where tournee="
					+ tournee + "and service in (select service from contrat c  where c.demande_abonnement_id=d.id  ");
			while (rs.next()) {
				a = 1;// tournee existant donc echec

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return a;
	}
}
