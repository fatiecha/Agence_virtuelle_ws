package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class CountFIWS {
public int countFactureImpayees(String id){
	int a=0;

	try {
		Long idClient=Long.parseLong(id);

		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
				"root", "");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT COUNT( * ) as total FROM Facture , Con_Cli WHERE Facture.etat =0 AND Facture.code_contrat = Con_Cli.CODE_CON AND Con_Cli.CODE_CLI =" +idClient);
		while (rs.next()) {

			a=rs.getInt("total");
			
			}
		
	} catch (Exception e) {
		e.printStackTrace();

	}

	return a;
}
}
