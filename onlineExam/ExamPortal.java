package onlineExam;
import java.util.Scanner;
import java.sql.*;
import onlineExam.controller.ConnectionOperations;
import onlineExam.view.ExamPortalMenu;
class ExamPortal{
static Scanner scanner=new Scanner(System.in);
static ConnectionOperations con=ConnectionOperations.getInstance();
public static void main(String[] args) throws Exception{
ExamPortalMenu examPortalMenu=new ExamPortalMenu();

String userName="";
String password="";


while(true){
	 System.out.println("Enter your choice \n 1.Applicant Login \n 2. Admin Login \n 3. New user \n 4.root Admin \n 5. Exit");
		    int choice = scanner.nextInt();
		    scanner.nextLine(); 
		    
		    switch(choice){
		    
		    
		    case 1:
		    System.out.println("enter your user name");
		    userName=scanner.nextLine();
		    System.out.println("enter your password");
		    password=scanner.nextLine();
		    
		             if(con.checkUserLogin(userName,password)){
		                 examPortalMenu.userMenu(userName,password);
		                    }
			    else{
			    System.out.println("username or password not exists, enter correct username and password");
			    }
	            
	           
		    break;
		    
		    
		    case 2:
		    System.out.println("enter the userName of admin");
		    userName=scanner.nextLine();
		    System.out.println("enter password");
		    password=scanner.nextLine();
		    
			    if(con.checkAdmin(userName,password)){
			    examPortalMenu.adminMenu();
			   }
			    else{
			    System.out.println("username not exists");
			    }
	            
	            break;
	            
	            
	            case 3:
	            
	            examPortalMenu.newUser();
	            break;
		    
		    case 4:
		    System.out.println("enter your user name");
		    userName=scanner.nextLine();
		    System.out.println("enter your password");
		    password=scanner.nextLine();
		       if(userName.equals("root") && password.equals("root@123")){
		       examPortalMenu.rootAdminMenu();
		       }
		       else{
		       System.out.println("invalid user name or password");
		       }
		        break;
		    
		    
		    case 5:
		    System.exit(0);
		    
		   default:
		   System.out.println("invalid choice");
		    }
		    }

}
}

