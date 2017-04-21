package projectWS.projectWS;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class AjouterClientWS {
	public String add(String s, String s1, String s2, String s3, String s4, String s5) throws Exception {
		String msg="non";
		try {
			String verifEmail=verifierEmail(s3);
			String verifMDP=verifierMDP(s5);
			if(verifEmail.equals("non existant") & verifMDP.equals("verifie") ){
				
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");

			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO client (nom, prenom, CIN, email,tel,MDP) VALUES (?,?,?,?,?,?)");
			preparedStatement.setString(1, s);
			preparedStatement.setString(2, s1);
			preparedStatement.setString(3, s2);
			preparedStatement.setString(4, s3);
			preparedStatement.setString(5, s4);
			preparedStatement.setString(6, s5);
			preparedStatement.executeUpdate();
			msg = "oui";
			}
			else if(verifEmail.equals("existant")){
				msg="existant";
			}
			else if(verifMDP.equals("non verifie")){
				msg="non verifie";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "non";
		}
		return msg;
	}

	public String verifierEmail(String email) {
		String msg = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence1",
					"root", "");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM client c WHERE c.email = '" + email + "'");

			if (rs.next()) {
				msg = "existant";
			}
			else{
				msg="non existant";
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return msg;

	}
	public String verifierMDP(String mdp){
		int size=mdp.length();
		String msg="non verifie";
		if(size<=10 & size>=5){
			msg="verifie";
		}
		return msg;
		
	}

}
