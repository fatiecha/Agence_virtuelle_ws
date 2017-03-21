package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class  AjouterClientWS {
	public String add(String s,String s1,String s2,String s3,String s4,String s5) throws Exception{
		String msg;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection =(Connection) DriverManager
				.getConnection("jdbc:mysql://localhost:3306/agence1","root", "");
		
		
		PreparedStatement preparedStatement = connection.prepareStatement( "INSERT INTO client (nom, prenom, CIN, email,tel,MDP) VALUES (?,?,?,?,?,?)");
		preparedStatement.setString(1, s);
		preparedStatement.setString(2, s1);
		preparedStatement.setString(3, s2);
		preparedStatement.setString(4, s3);
		preparedStatement.setString(5, s4);
		preparedStatement.setString(6, s5);
		preparedStatement.executeUpdate();
		msg="oui";
		}
		catch (Exception e) {
			e.printStackTrace();
			msg="non";
		}
		return msg;
	}
	
}
