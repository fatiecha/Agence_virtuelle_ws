package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import bean.Echeance;
import bean.Facilite;
import bean.Facture;

public class ConsulterFacilitesWS {
	public List<Facilite> consulterFacilite(String id) {
		List<Facilite> listFacilite = new ArrayList<Facilite>();
		try {
			Long id_contrat = Long.parseLong(id);

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from facilite where code_contrat=" + id_contrat);
			while (rs.next()) {

				Facilite facilite = new Facilite();
				facilite.setId(rs.getLong("id"));
				facilite.setEtat(rs.getString("etat"));
				facilite.setMontant(rs.getDouble("montant"));

				listFacilite.add(facilite);

			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return listFacilite;
	}

	public List<Echeance> consulterEcheance(String id) {
		List<Echeance> listEcheance = new ArrayList<Echeance>();
		try {
			Long id_facilite = Long.parseLong(id);
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from echeance where code_facilite=" + id_facilite);
			while (rs.next()) {

				Echeance echeance = new Echeance();
				echeance.setOrdre(rs.getInt("ordre"));
				echeance.setMontant(rs.getDouble("montant"));
				echeance.setEtat(rs.getString("etat"));
				echeance.setDateEcheance(rs.getDate("dateEcheance"));

				listEcheance.add(echeance);

			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return listEcheance;
	}
}
