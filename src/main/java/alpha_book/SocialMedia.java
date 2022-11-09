package alpha_book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SocialMedia {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	
	public void logIn(String emailId, String password, User user) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alphabook","root","root");
		PreparedStatement preparedStatement = connection.prepareStatement("Select * from user where emailId = ? and password = ? ");
		preparedStatement.setString(1, user.getEmailId());
		preparedStatement.setString(2, user.getPassword());
		ResultSet resultSet = preparedStatement.executeQuery();
		
		String emailId1 = "";
		String password1 = "";
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getLong(4));
			System.out.println(resultSet.getString(5));
			System.out.println(resultSet.getString(6));
			System.out.println(resultSet.getString(7));
			emailId1 = resultSet.getString(6);
			password1 = resultSet.getString(7);
			
		}
		if(emailId1.equals(user.getEmailId())&&password1.equals(user.getPassword())) {
			System.out.println("Logged in Successfully");
			System.out.println("Do you want to add Status :");
			System.out.println("1. Yes");
			System.out.println("2. No");
			System.out.println("Enter your choice : ");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1 :{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connectionStatus = DriverManager.getConnection("jdbc:mysql://localhost:3306/status", "root", "root");
				PreparedStatement preparedStatement = connectionStatus.prepareStatement("Insert into status ")
				break;
			}
			case 2 :{
				
				break;
			}
			default : {
				System.out.println("Please Enter Valid Choice");
			}
			}
			
			
			
		}else if(emailId1.equalsIgnoreCase(user.getEmailId())){
			System.out.println("Email doesn't exists");
		
		}else if(password1.equalsIgnoreCase(user.getPassword())) {
			System.out.println("Invalid Password up to 3 attempts");
			System.out.println("RE-ENTER PASSWORD :");
			String password2 = scanner.next();
			
			SocialMedia socialMedia = new SocialMedia();
			user.setPassword(password1);
			socialMedia.logIn(emailId,password2,user);
		}
		else
		{
			System.out.println("Invalid Creditials");
		}
		
		}
	
	
	public void signUp(User user) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alphabook","root","root");
		PreparedStatement preparedStatement = connection.prepareStatement("Insert into user values(?,?,?,?,?,?,?)");
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getLastName());
		preparedStatement.setString(3, user.getGender());
		preparedStatement.setLong(4, user.getContactNumber());
		preparedStatement.setString(5, user.getDateOfBirth());
		preparedStatement.setString(6, user.getEmailId());
		preparedStatement.setString(7, user.getPassword());
		
		System.out.println("1. SUBMIT");
		System.out.println("2. CANCEL");
		System.out.println("ENTER YOUR CHOICE :");
		System.out.println("******************************");
		int submit = scanner.nextInt();
		if(submit==1) {
			preparedStatement.executeUpdate();
			System.out.println("*********SignUp Successfully********");
		}else if(submit==2){
			System.out.println("Cancelled");
			System.out.println("Thank you");
		}else {
			System.out.println("Enter valid choice");
		}
		connection.close();
		
	}
	
	public void logOut() {
		System.out.println("Logged Out");
		System.out.println("*************Thank You For Using The App***************");

	}
}
