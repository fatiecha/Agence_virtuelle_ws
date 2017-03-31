package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import bean.Facture;
import bean.Reclamation;

public class ConsulterFacturesWS {
	public  List<Facture> consulterFacture(String id) {
		List<Facture> listFacture = new ArrayList<Facture>();
		try {Long id_contrat = Long.parseLong(id);

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from facture where code_contrat=" + id_contrat);
			while (rs.next()) {

				Facture facture = new Facture();
				facture.setId(rs.getLong("id"));
				facture.setDate(rs.getDate("date"));
				facture.setDate_exigibilite(rs.getDate("date_exigibilite"));
				facture.setMontant(rs.getDouble("montant"));
				facture.setPeriode(rs.getString("periode"));
				facture.setSolde(rs.getDouble("solde"));
				facture.setType_facture(getLibelleType_facture(rs.getLong("code_type_facture")));
				facture.setEtat(rs.getBoolean("etat"));


				listFacture.add(facture);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return listFacture;
	}

	public String getLibelleType_facture(Long id){
		String libelle=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
				"root", "");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select libelle from type_facture where id=" + id);
		while(rs.next()){
		libelle=rs.getString("libelle");
		}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return libelle;
		
	}
}
