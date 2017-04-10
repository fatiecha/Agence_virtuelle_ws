package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import bean.Devis;

public class ConsulterDevisWS {
	public  ArrayList<Devis> consulterDevis(String id) {
		ArrayList<Devis> listDevis = new ArrayList<Devis>();
		try {
			Long id_contrat = Long.parseLong(id);
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from devis where code_contrat=" + id_contrat);
			while (rs.next()) {

				Devis devis = new Devis();
				devis.setId(rs.getLong("id"));
				devis.setCommentaire(rs.getString("commentaire"));
				devis.setDate(rs.getDate("date"));
				devis.setEtat(rs.getString("etat"));
				devis.setMontant(rs.getDouble("montant"));
				devis.setContrat(rs.getLong("code_contrat"));


				listDevis.add(devis);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return listDevis;
	}
	
}
