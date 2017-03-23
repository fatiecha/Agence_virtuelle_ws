package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class AjouterConCliWS {
	public String addContratClient(String id1, String id2) throws Exception {
		String msg, cin = null, cin2 = null;
		try {
			Long id_contrat = Long.parseLong(id1);
			Long id_client = Long.parseLong(id2);
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");

			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select CIN from contrat where id=" + id_contrat);
			while (rs.next()) {
				cin = rs.getString("CIN");
			}
			Connection connection2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");

			Statement statement2 = connection2.createStatement();

			ResultSet rs2 = statement2.executeQuery("select CIN from client where id=" + id_client);
			while (rs2.next()) {
				cin2 = rs2.getString("CIN");
			}

			if (cin.equals(cin2)) {
				Connection connection3 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
						"root", "");
				PreparedStatement preparedStatement = connection3
						.prepareStatement("INSERT INTO con_cli (CODE_CON, CODE_CLI) VALUES (?,?)");
				preparedStatement.setLong(1, id_contrat);
				preparedStatement.setLong(2, id_client);

				preparedStatement.executeUpdate();

				msg = "oui";
			} else {
				msg = "non";
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg = "non";
		}
		return msg;

	}

}
