package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import bean.Contrat;

public class ConsulterContratsWS {
	public List<Contrat> consulterContrats(String id) {
		List<Contrat> listContrats = new ArrayList<Contrat>();
		try {
			Long id_client = Long.parseLong(id);
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from contrat  ,con_cli,client where contrat.id=con_cli.code_con and con_cli.code_cli=client.id and  client.id=" + id_client);
			while (rs.next()) {
				Contrat contrat = new Contrat();
				contrat.setId(rs.getLong("id"));
				contrat.setIdClient(id_client);
				contrat.setService(rs.getString("service"));
				contrat.setNomClient(getNomClient(id_client));
				listContrats.add(contrat);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return listContrats;

	}

	public Contrat detailContrat(String id_cta_st) {
		Contrat contrat = new Contrat();
		try {
			Long id_cta_long = Long.parseLong(id_cta_st);

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from contrat where id=" + id_cta_long);
			Statement statement2 = connection.createStatement();
			ResultSet rs2 = statement2.executeQuery(
					"select * from demande_abonnement d , contrat c where c.demande_abonnement_id=d.id and c.id="
							+ id_cta_long);
			
			while (rs.next()) {
				System.out.println("test rs "+rs.getDate("datePoseCompteur"));
				contrat.setDatePoseCompteur(rs.getDate("datePoseCompteur"));
				contrat.setNumCompteur(rs.getString("numCompteur"));

				contrat.setBranchement(rs.getString("branchement"));
				contrat.setAgence(rs.getString("agence"));

				contrat.setEtat(rs.getString("etat"));

			}
			while (rs2.next()) {
				System.out.println("test rs2 "+rs2.getString("tournee"));
				contrat.setTournee(rs2.getString("tournee"));
				contrat.setTarif(rs2.getString("tarif"));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return contrat;
	}

	public String getNomClient(long id) {
		String nom = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select nom from client where id=" + id);
			while (rs.next()) {
				nom = rs.getString("nom");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return nom;

	}
}
