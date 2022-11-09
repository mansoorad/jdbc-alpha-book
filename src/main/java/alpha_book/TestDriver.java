package alpha_book;

import java.util.Scanner;

public class TestDriver {

	public static void main(String[] args) throws Exception {
		SocialMedia socialMedia = new SocialMedia();
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
		System.out.println("*****************ALPHA BOOK****************");
		System.out.println("1. LOGIN");
		System.out.println("2. SIGNUP");
		System.out.println("3. EXIT");
		System.out.println();
		System.out.println("ENTER YOUR CHOICE : ");
		System.out.println("********************************************");
		
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1 : {
			System.out.println("***************WELCOME TO LOGIN PAGE***************");
			System.out.println("EMAIL-ID :");
			String emailId = scanner.next();
			System.out.println("PASSWORD :");
			String password = scanner.next();
			user.setEmailId(emailId);
			user.setPassword(password);
			socialMedia.logIn(emailId,password,user);	
		break;	
		}
		
		case 2 : {
			System.out.println("***************ALPHA BOOK***************");
			System.out.println("FIRST NAME :");
			String firstName = scanner.next();
			System.out.println("LAST NAME :");
			String lastName = scanner.next();
			System.out.println("GENDER :");
			String gender = scanner.next();
			System.out.println("CONTACT NUMBER :");
			long contactNumber = scanner.nextLong();
			System.out.println("DATE OF BIRTH :");
			String dateOfBirth = scanner.next();
			System.out.println("EMAIL ID :");
			String emailId = scanner.next();
			System.out.println("PASSWORD :");
			String password = scanner.next();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setGender(gender);
			user.setContactNumber(contactNumber);
			user.setDateOfBirth(dateOfBirth);
			user.setEmailId(emailId);
			user.setPassword(password);
			socialMedia.signUp(user);	
		break;
		}
		
		case 3 :{
			flag = false;
			socialMedia.logOut();
		break;
		}
		
		default : {
			System.out.println("Invalid choice");
			System.out.println("Please Enter valid choice");
		}
		
		}
		
		}
		
		
		
	}

}
