package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import bean.Devis;
import bean.Reclamation;

public class ConsulterReclamationsWS {
	public  ArrayList<Reclamation> consulterReclamation(String id) {
		ArrayList<Reclamation> listReclamation = new ArrayList<Reclamation>();
		try {Long id_contrat = Long.parseLong(id);

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from reclamation where code_contrat=" + id_contrat);
			while (rs.next()) {

				Reclamation reclamation = new Reclamation();
				reclamation.setId(rs.getLong("id"));
				reclamation.setCommentaire(rs.getString("commentaire"));
				reclamation.setDate(rs.getDate("date"));
				reclamation.setEtat(rs.getString("etat"));
				reclamation.setOrigine(rs.getString("origine"));
				reclamation.setCommentaireResolution(rs.getString("commentaireResolution"));
				reclamation.setType_reclamation(getLibelleType_reclamation(rs.getLong("code_type_reclamation")));
				reclamation.setContrat(rs.getLong("code_contrat"));

				listReclamation.add(reclamation);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return listReclamation;
	}


	public String getLibelleType_reclamation(Long id){
		String libelle=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
				"root", "");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select libelle from type_reclamation where id=" + id);
		while(rs.next()){
		libelle=rs.getString("libelle");
		}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return libelle;
		
	}
}
