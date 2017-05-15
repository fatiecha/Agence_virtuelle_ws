package projectWS.projectWS;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;

import bean.Compte;

import java.sql.ResultSet;

import java.sql.Statement;

public class ConsulterCompteWS {
	public Compte consulterCompte(String id) {
		Compte compte = new Compte();
		try {
			Long id_contrat = Long.parseLong(id);

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from compte where contrat_id=" + id_contrat);

			while (rs.next()) {

				long userid = rs.getLong("id");
				long credit = rs.getLong("credit");

				compte.setId(rs.getLong("id"));
				compte.setCredit(rs.getLong("credit"));
				compte.setMt_exigible(rs.getLong("mt_exigible"));
				compte.setMt_impayé(rs.getLong("mt_impayé"));
				compte.setProvision(rs.getLong("provision"));
				compte.setContrat_id(rs.getLong("contrat_id"));

			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return compte;

	}

	public static void main(String[] args) {
		ConsulterCompteWS c = new ConsulterCompteWS();
		Compte a = new Compte();
		a = c.consulterCompte("1");
		System.out.println(a.getCredit());
		System.out.println(a.getMt_exigible());
		System.out.println(a.getMt_impayé());
		System.out.println(a.getProvision());
		System.out.println(a.getContrat_id());
	}
}
