package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Contrat;
import com.mysql.jdbc.Connection;

public class AjouterConCliWS {

	// public String addContratClient(String numero, String id2, String service)
	// throws Exception {
	// String msg, cin = null, cin2 = null;
	// Long id_contrat = null;
	//
	// try {
	// Long id_client = Long.parseLong(id2);
	// Class.forName("com.mysql.jdbc.Driver");
	// Connection connection = (Connection)
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
	// "root", "");
	//
	// Statement statement = connection.createStatement();
	//
	// ResultSet rs = statement.executeQuery(
	// "select CIN,id from contrat where numero=" + numero + " and service ='" +
	// service + "'");
	// while (rs.next()) {
	// cin = rs.getString("CIN");
	// }
	// Connection connection2 = (Connection)
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
	// "root", "");
	//
	// Statement statement2 = connection2.createStatement();
	//
	// ResultSet rs2 = statement2.executeQuery("select CIN from client where
	// id=" + id_client);
	// while (rs2.next()) {
	// cin2 = rs2.getString("CIN");
	// }
	//
	// if (cin.equals(cin2)) {
	//
	// Connection connection3 = (Connection)
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
	// "root", "");
	// PreparedStatement preparedStatement = connection3
	// .prepareStatement("INSERT INTO con_cli (CODE_CON, CODE_CLI) VALUES
	// (?,?)");
	// preparedStatement.setLong(1, rs.getLong("id"));
	// preparedStatement.setLong(2, id_client);
	//
	// preparedStatement.executeUpdate();
	//
	// msg = "oui";
	//
	// } else {
	// msg = "non";
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// msg = "non";
	// }
	// return msg;
	//
	// }
	public String addContratClient(String numeroContrat, String idclient, String service) throws Exception {
		String cinContrat = null;
		String msg = "non";
		Long idContrat = null;
		String cinClient = null;
		boolean check=false;
		List<Contrat> contrats = new ArrayList<Contrat>();
		contrats = getCinIdContrat(numeroContrat, service);
		if (contrats.isEmpty()) {
			msg = "non";
		} else {
			for (int i = 0; i < contrats.size(); i++) {
				Contrat t = contrats.get(i);
				cinContrat=t.getCIN();
				idContrat=t.getId();
			}
			cinClient=getCinClient(idclient);
			check=checkConcli(idclient,Long.toString( idContrat));
			if(check){
				if(cinClient.equals(cinContrat)){
					 Connection connection3 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					 "root", "");
					 PreparedStatement preparedStatement = connection3.prepareStatement("INSERT INTO con_cli (CODE_CON, CODE_CLI) VALUES (?,?)");
					 preparedStatement.setLong(1, idContrat);
					 preparedStatement.setLong(2, Long.parseLong(idclient));
					 preparedStatement.executeUpdate();
					
					 msg = "oui";
					
					
				}
			}

		}
		return msg;
	}

	public boolean checkConcli(String idClient, String idContrat) {
		Long idCli = Long.parseLong(idClient);
		Long idCon = Long.parseLong(idContrat);
		boolean check = false;

		String cin = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");

			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(
					"select * from Con_cli where code_con = '"  + idCon + "'");
			if (!rs.next()) {
				check = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;

	}

	public String getCinClient(String idClient) {
		Long idCli = Long.parseLong(idClient);
		String cin = null;
		List<Contrat> contrats = new ArrayList<Contrat>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");

			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select CIN from client where id=" + idCli);
			while (rs.next()) {
				cin = rs.getString("CIN");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cin;

	}

	
	List<Contrat> getCinIdContrat(String numero, String service) {

		List<Contrat> contrats = new ArrayList<Contrat>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");

			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(
					"select CIN,id from contrat where numero=" + numero + " and service ='" + service + "'");
			while (rs.next()) {
				Contrat c = new Contrat();
				c.setCIN(rs.getString("CIN"));
				c.setId(rs.getLong("id"));
				contrats.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contrats;

	}

}
