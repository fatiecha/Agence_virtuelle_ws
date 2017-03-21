package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;



import com.mysql.jdbc.Connection;

public class AjouterReclamationWS {

	public String ajouterReclamation(long code_contrat,String origine ,String  type_reclamation,String comm) throws Exception{
		String msg;
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection =(Connection) DriverManager
				.getConnection("jdbc:mysql://localhost:3306/agence1","root", "");
		
		String etat="en cours";
		PreparedStatement preparedStatement = connection.prepareStatement( "INSERT INTO reclamation (date, origine, etat, commentaire,code_type_reclamation,code_contrat) VALUES (?,?,?,?,?,?)");
		preparedStatement.setDate(1, date);
		preparedStatement.setString(2, origine);
		preparedStatement.setString(3,etat);
		preparedStatement.setString(4,comm);
		preparedStatement.setLong(5, getIdType_reclamation(type_reclamation));
		preparedStatement.setLong(6,code_contrat);

		preparedStatement.executeUpdate();
		msg="oui";
		}
		catch (Exception e) {
			e.printStackTrace();
			msg="non";
		}
		return msg;
	}
	
	public Long getIdType_reclamation(String libelle){
		Long id=0l;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
				"root", "");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select id from type_reclamation  where libelle='" + libelle+"'");
		while(rs.next()){
		id=rs.getLong("id");
		}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return id;
	}
}
