package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import bean.Consommation;

public class ConsulterConsommationsWS {
	public List<Consommation> consulterConsommations(String id) {
		List<Consommation> listConsommations = new ArrayList<Consommation>();
		try {
			Long id_contrat = Long.parseLong(id);

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from consommation where code_contrat=" + id_contrat);
			while (rs.next()) {

				Consommation consommation = new Consommation();
				consommation.setId(rs.getLong("id"));
				consommation.setDate_releve(rs.getDate("date_releve"));
				consommation.setIndex_lu(rs.getLong("index_lu"));
				consommation.setNbr_jour(rs.getInt("nbr_jour"));
				consommation.setPeriode(rs.getString("periode"));
				consommation.setVolume_consomme(rs.getDouble("volume_consomme"));
				consommation.setVolume_facture(rs.getDouble("volume_facture"));

				consommation.setType_lecture(getLibelleType_lecture(rs.getLong("code_type_lecture")));

				listConsommations.add(consommation);

			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return listConsommations;
	}

	public String getLibelleType_lecture(Long id) {
		String libelle = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select libelle from type_lecture where id=" + id);
			while (rs.next()) {
				libelle = rs.getString("libelle");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return libelle;

	}

}
