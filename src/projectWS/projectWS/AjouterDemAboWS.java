package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import com.mysql.jdbc.Connection;

public class AjouterDemAboWS {
	public String ajouterDem_Abo(Long tournee, Long code_client,String service,String tarif) throws Exception{
		String msg;
		AjouterReclamationWS c=new AjouterReclamationWS();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection =(Connection) DriverManager
				.getConnection("jdbc:mysql://localhost:3306/agence1","root", "");
		
		String etat="En attente";

		PreparedStatement preparedStatement = connection.prepareStatement( "INSERT INTO demande_abonnement ( tournee, date,code_client,tarif) VALUES (?,?,?,?)");
		preparedStatement.setLong(1, tournee);
		preparedStatement.setDate(2, date);
		preparedStatement.setLong(3, code_client);
		preparedStatement.setString(4,tarif);

		preparedStatement.executeUpdate();
		PreparedStatement preparedStatement2 = connection.prepareStatement( "INSERT INTO contrat ( cin, date,service,	demande_abonnement_id,etat) VALUES (?,?,?,?,?)");
		preparedStatement2.setString(1,getCinClient(code_client) );
		preparedStatement2.setDate(2, date);
		preparedStatement2.setString(3, service);
		preparedStatement2.setLong(4, getIdMax());
		
		preparedStatement2.setString(5, etat);
		preparedStatement2.executeUpdate();
		c.ajouterReclamation(getIdMaxContrat(), "reclamation client", "verification demande contrat", "");
		msg="oui";
		}
		catch (Exception e) {
			e.printStackTrace();
			msg="non";
		}
		return msg;
	}
public String getCinClient(Long id){
	String cin=null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
			"root", "");
	Statement statement = connection.createStatement();
	ResultSet rs = statement.executeQuery("select cin from client where id=" + id);
	while(rs.next()){
	cin=rs.getString("cin");
	}
	} catch (Exception e) {
		e.printStackTrace();

	}
	return cin;
	
}

public Long getIdMax(){
	Long id=0l;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
			"root", "");
	Statement statement = connection.createStatement();
	ResultSet rs = statement.executeQuery("select max(id) as maxid from demande_abonnement  " );
	while(rs.next()){
		id=rs.getLong("maxid");

	}
	
	} catch (Exception e) {
		e.printStackTrace();

	}
	return id;
}
public Long getIdMaxContrat(){
	Long id=0l;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
			"root", "");
	Statement statement = connection.createStatement();
	ResultSet rs = statement.executeQuery("select max(id) as maxid from contrat  " );
	while(rs.next()){
		id=rs.getLong("maxid");

	}
	
	} catch (Exception e) {
		e.printStackTrace();

	}
	return id;
}
}
