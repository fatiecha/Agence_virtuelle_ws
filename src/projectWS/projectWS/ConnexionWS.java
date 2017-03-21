package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import bean.Facture;

public class ConnexionWS {
	public  long seConnecter(String email,String mdp) {
		long a=0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select id  from client where email='" + email + "'and MDP='" +mdp+"'");
			while (rs.next()) {
				a=rs.getLong("id");

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return a;
	}
	
	
}
