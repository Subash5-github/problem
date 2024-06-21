package onlineExam.controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Iterator;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.security.SecureRandom;
import onlineExam.model.Question;
import onlineExam.model.UserProfile;
import onlineExam.model.Exam;
import onlineExam.model.Application;
import onlineExam.model.Admin;
import onlineExam.database.DatabaseConnection;
import onlineExam.database.ConnectionStatement;




public class ConnectionOperations extends ValidationCheck{
       private static SecureRandom rand=new SecureRandom();
       private static ConnectionOperations connectionOperations=null;
	static Connection connection=DatabaseConnection.getConnection();
	static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    
    Scanner scanner=new Scanner(System.in);
    int correctAnswer=0;
    int totalQuestions=0;
     String description="";
        String option1="";
        String option2="";
        String option3="";
        String option4="";
    
 
    
    private ConnectionOperations(){}
   
   
    
    public static ConnectionOperations getInstance(){
	if(connectionOperations==null){
	     connectionOperations=new ConnectionOperations();
	}
	return connectionOperations;
	}
    
    
    public void setQuestion(String examId,Map<String,Question> quest){
    
    String query=SQLQueries.addQuestion;                                                             //set question in database
    
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    
	   
	    for(Map.Entry<String,Question> q: quest.entrySet()){
	     
	    psmt.setString(1,examId);
	    psmt.setString(2,q.getKey());
	    psmt.setString(3,q.getValue().getDescription());
	    psmt.setString(4,q.getValue().getOption1());
	   
	    psmt.setString(5,q.getValue().getOption2());
	    psmt.setString(6,q.getValue().getOption3());
	    psmt.setString(7,q.getValue().getOption4());
	    
	    psmt.setInt(8,q.getValue().getAnswer());
	    
	    
	    psmt.executeUpdate();
	     
	   
	    }
	    System.out.println();
	     System.out.println("question added successfully");
	     System.out.println();
	    }
	    catch(SQLException e){
	    e.getMessage();
	    
	    }
    }

        public List<Question> attendTest(String examId){
         
        ArrayList<Question> question=new ArrayList();
       
        boolean isValid=true;
        int option=0;
        
        String query=SQLQueries.retrieveQuestion;                                                             // retreive questions for attending the test
        try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
		psmt.setString(1,examId);
		ResultSet rs=psmt.executeQuery();
		while(rs.next()){
		description=rs.getString(1);
		option1=rs.getString(2);
		option2=rs.getString(3);
		option3=rs.getString(4);
		option4=rs.getString(5);
		question.add(new Question(description,option1,option2,option3,option4));
		}
		}
		catch(SQLException e){
		e.getMessage();
		}
	return question;
        }
            
        
        
        
        public void setResult(String rollNo,int totalMarks){
        String query=SQLQueries.storeResult;                                                        // store marks in db
		try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
		psmt.setString(1,rollNo);
		psmt.setInt(2,totalMarks);
		psmt.executeUpdate();
		statusUpdate(rollNo);
		System.out.println();
		System.out.println("test completed");
		System.out.println();
		}
		catch(SQLException e){
		e.getMessage();
		}
        }
        
        
        public List<Exam> examList(){
        String query=SQLQueries.examList;   
        ArrayList<Exam> listOfExam=new ArrayList();   
                                                          // display the list of exams
		try(Statement st = connection.createStatement();ResultSet rs = st.executeQuery(query)){
		while(rs.next()){
		listOfExam.add(new Exam(rs.getString(1),rs.getString(2),rs.getString(3)));
		
		}
		}
		catch(SQLException e){
		e.getMessage();
		}
        return listOfExam;
        }
        
        
        public void setExam(String examId,String examName,String examDate){
         String query=SQLQueries.addExam;                                                                                                            //add exam
		 try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
		 psmt.setString(1,examId);
		 psmt.setString(2,examName);
		 psmt.setString(3,examDate);
		 psmt.executeUpdate();
		 System.out.println();
		 System.out.println("exam added successfully");
		 System.out.println();
		}
		catch(SQLException e){
		e.getMessage();
		}
        }
        
        
        
        
    
    public void setApplication(String examId,String userName,Application application){
    
      String query=SQLQueries.setApplication;                                        // set application details in db
	      try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	      psmt.setString(1,examId);
	      psmt.setString(2,application.getRollNumber());
	      psmt.setString(3,userName);
	      psmt.setString(4,application.getName());
	      psmt.setString(5,application.getEmail());
	      psmt.setLong(6,application.getContact());
	      //psmt.setString(7,"not completed");
	      psmt.executeUpdate();
	      System.out.println();
	      System.out.println("exam registered successfully");
	      System.out.println();
	    }
	    catch(SQLException e){
		e.getMessage();
		}
    }
    
    public String rollNumGeneration(String examId){
      int num=rand.nextInt(100000000);
      
	   System.out.println(num);
	   boolean isValidRollno=true;
	   String rollNo=examId+num;
	      String query=SQLQueries.getRollNoByUserName;                                           // get roll number by using username
	      try(PreparedStatement statement=ConnectionStatement.getPreparedStatement(query)){
	      
	      while(isValidRollno){
	      statement.setString(1,rollNo);
	      ResultSet rs=statement.executeQuery();
	      
	      if(rs.next()){
	       num=rand.nextInt(100000000);
	       rollNo=examId+num;
	       continue;
	      }
	      
	      isValidRollno=false;
	    }
	    
	    }
	    catch(SQLException e){
		e.getMessage();
		}
        return rollNo;
    }
    
    
    public boolean checkExamId(String examId){
    String query=SQLQueries.checkExamid;                                            // check the presence of exam id
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,examId);
		    try(ResultSet rs=psmt.executeQuery()){
		    if(rs.next()){
		    return true;
		    }
		   
		    }
	    }
	    catch(SQLException e){
		e.getMessage();
		}
         return false;
        }
    
    public boolean checkDuplicateRegisteration(String userName,String examId,String email,long contact){
    
   //String query="select examid,username from registeration where examid="+id;//+"AND username="+userName;
    String query=SQLQueries.verifyDuplicates;                                                           //verify the duplicate application
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,examId);
	    psmt.setString(2,userName);
	    psmt.setString(3,email);
	    psmt.setLong(4,contact);
	    
	    ResultSet rs=psmt.executeQuery();
	    if(rs.next()){
	    
	    return false;
	    }
	    
	    }
	    catch(SQLException e){
		e.getMessage();
		}
        return true;
        }
    
    public List<UserProfile> applicantProfile(String userName){
       ArrayList<UserProfile> profileList=new ArrayList();
       boolean isvalid=false;
        if(userNameVerification(userName)){
    
         String query=SQLQueries.viewProfile;                                                               // view applicant profile
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,userName);
	    try(ResultSet rs=psmt.executeQuery()){
	    System.out.println();
	    System.out.println("Applied exams are ---");
	    
		    while(rs.next()){
		    profileList.add(new UserProfile(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5)));
		    isvalid=true;
		    }

	    }
	    System.out.println();
	    }
	    catch(SQLException e){
	     e.getMessage();
	     }
        }
       else{
       System.out.println();
          System.out.println("no user exists");
          System.out.println();
            }
	      if(!(isvalid)){
	      System.out.println();
	     System.out.println("no exams registered yet");
	       profileList.add(new UserProfile("----","---","--",0,"----"));
	       
	       return profileList;
	    }
	    else{
	      return profileList;
	    }
    
    }
    
    public boolean userNameVerification(String userName){
    String query=SQLQueries.duplicateUsername;                                                // verify the presence of username
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,userName);
	    try(ResultSet rs=psmt.executeQuery()){
	    if(rs.next()){
	     return true;
	    }
	    
	    }
	    }
	      catch(SQLException e){
		e.getMessage();
		}
        return false;
        }
    
    
    public boolean checkQuestionId(String questionId){
    String query=SQLQueries.verifyQuestionId;                                                                     // check question id
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,questionId);
	    
		    try(ResultSet rs=psmt.executeQuery()){
		    if(rs.next()){
		    return true;
		    }
		   
		    }
	    }
	    catch(SQLException e){
             e.getMessage();
	    }
         return false;
        }
    
    public void updateQuestion(String questionId,Question question){
	    
	    String query=SQLQueries.questionUpdate;                                                                        //update question
		    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
		    psmt.setString(1,question.getDescription());
		    psmt.setString(2,question.getOption1());
		    psmt.setString(3,question.getOption2());
		    psmt.setString(4,question.getOption3());
		    psmt.setString(5,question.getOption4());
		    psmt.setString(6,questionId);
		    psmt.executeUpdate();
		     System.out.println();
		    System.out.println("question updated successfully");
		    System.out.println();
	          }
	      catch(SQLException e){
		e.getMessage();
		}
        }
    
    public void updateAnswer(String questionId,int answer){
    String query=SQLQueries.answerUpdate;                                                          //update answer
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setInt(1,answer);
	    psmt.setString(2,questionId);
	    psmt.executeUpdate();
	    System.out.println();
	    System.out.println("answer updated successfully");
	    System.out.println();
	    }
	    catch(SQLException e){
            e.getMessage();
            }
        }
    
    
    public void userLoginDetails(String userName,String password){
   
     userName=checkUserName(userName);
     password=checkPassword(password);
	    if(checkUserLogin(userName,password)){
	    System.out.println();
	    System.out.println("username already exists");
	    System.out.println();
	    }
	    else{
	  
	     setUser(userName,password);
	     }
    }
    
    
    
    
     private void setUser(String userName,String password){
     String query=SQLQueries.newUser;                                                                                   // set new user
	     try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	     psmt.setString(1,userName);
	     psmt.setString(2,password);
	     psmt.executeUpdate();
	     System.out.println();
	     System.out.println("new user registered successfully");
	     System.out.println();
	     }
	       catch(SQLException e){
	       System.out.println();
	       System.out.println("username already exists");
	       System.out.println();
		e.getMessage();
		}
        }
     
     
     
     private String checkUserName(String userName){
        
	    while(!(validateUserName(userName))){
	      System.out.println("enter the valid username");
	      userName=scanner.nextLine();
	     }
     return userName;
     }
     
     
     
     private String checkPassword(String password){
       
	     while(!(validatePassword(password))){
	      System.out.println("enter the valid password");
	      password=scanner.nextLine();
	    }
      return password;
     }
   
     
     
     public void addAdminDetails(){
     String userName="";
    String password="";
    
	    System.out.println("enter your username(userName must contains 5 to 25 characters contains both alphabets and number and staring character should be an alphabet)");
	     userName=checkUserName(userName);
	    System.out.println("enter your password(password must contains 6 to 15 characters that include alphabets ,numbers,special characters and starting character should be an alphabet)");
	    password=checkPassword(password);
    
    setAdmin(userName,password);
    }
    
    
    
     private void setAdmin(String userName,String password){
     String query=SQLQueries.newAdmin ;                                                                  //set new admin
	     try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	     psmt.setString(1,userName);
	     psmt.setString(2,password);
	     psmt.executeUpdate();
	     System.out.println();
	     System.out.println("new admin added successfully");
	     System.out.println();
	     }
	       catch(SQLException e){
	       System.out.println();
		System.out.println("username or password already exists");
		System.out.println();
		}
        }
     
     public Map<String,Application> applicantHistory(String examId){
      TreeMap<String,Application> apply=new TreeMap();
     String query=SQLQueries.applicationHistory;                                                  //application history
	     try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	     psmt.setString(1,examId);
		     try(ResultSet rs=psmt.executeQuery()){
		     String rollNo="";
		     String email="";
		     long contact=0l;
		     String userName="";
		     String name="";
			     while(rs.next()){
			     rollNo=rs.getString(1);
			     userName=rs.getString(2);
			     name=rs.getString(3);
			     email=rs.getString(4);
			     contact=rs.getLong(5);
			     apply.put(userName,new Application(name,email,contact,rollNo));
			     }
	     }
     }
      catch(SQLException e){
        e.getMessage();
        }
        return apply;
        }
    
    
    
    public Map<String,Question> showQuestions(String examId){
    TreeMap<String,Question> questionShow=new TreeMap();
    String questionId="";
   
    int answer=0;
    
    String query=SQLQueries.showQuestionAnswer;                                                                 // display questions and answer
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,examId);
		    try(ResultSet rs=psmt.executeQuery()){
			    while(rs.next()){
			      questionShow.put(rs.getString(1),new Question(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			     
			    }
	    }
    }
      catch(SQLException e){
        e.getMessage();
        }
        
        return questionShow;
        }
    
    public void resultForAdmin(String examId){
    
    String query=SQLQueries.resultForAdmin;                                                                //display ressult
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,examId);
		    try(ResultSet rs=psmt.executeQuery()){
		    System.out.println("exam id       roll no    username       name       contact     mark");
			    while(rs.next()){
			    System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4)+"    "+rs.getLong(5)+"    "+rs.getInt(6));
			    }
		    
		    }
	    }
	      catch(SQLException e){
		e.getMessage();
		}
        }
    
    public String getRollNoByUserName(String userName,String examId){
    String rollNo="";
     String query=SQLQueries.getRollNo;                                                       //get roll number using username and examid
	     try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,userName);
	    psmt.setString(2,examId);
		    try(ResultSet rs=psmt.executeQuery()){
			    if(rs.next()){
			     rollNo=rs.getString(1);
			     return rollNo;
			    }
		    return "none";
		    }
	    }
	      catch(SQLException e){
		e.getMessage();
		}
        return rollNo;
        }
    
    public String showResult(String rollNo){
    int mark=0;;
    String query =SQLQueries.resultForUser;                                                                 //result for user
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,rollNo);
		    try(ResultSet rs=psmt.executeQuery()){
			    if(rs.next()){
			    mark=rs.getInt(1);
			    }
		    }
	    }  catch(SQLException e){
		e.getMessage();
		}
        return "you mark is "+mark;
        }
    
    
    
    public boolean checkUserLogin(String userName,String password){
    String query=SQLQueries.verifyUserLogin;                                                                            // verify user login
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,userName);
	    psmt.setString(2,password);
	  
		    try(ResultSet rs=psmt.executeQuery()){
			    if(rs.next()){
			    return true;
			    }
		    
		    }
	    }
	      catch(SQLException e){
		e.getMessage();
		}
        return false;
        }
    
    public boolean checkAdmin(String userName,String password){
      String query=SQLQueries.verifyAdminLogin;                                                               // verify admin login
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,userName);
	    psmt.setString(2,password);
		    try(ResultSet rs=psmt.executeQuery()){
			    if(rs.next()){
			    return true;
			    }
		   
		    }
	    }
	      catch(SQLException e){
		e.getMessage();
		}
         return false;
        }
    
    public boolean ensureApplication(String rollNo,String examId){
    String query=SQLQueries.verifyRollNoExamId;                                                                // check roll number and examId In application
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,rollNo);
	    psmt.setString(2,examId);
		    try(ResultSet rs=psmt.executeQuery()){
			    if(rs.next()){
			    return true;
			    }
		    
		    }
	    }
	      catch(SQLException e){
		e.getMessage();
		}
        return false;
        }
    
    public boolean checkDate(String examId){
    String examDate=""; 
    String query=SQLQueries.verifyExamDate;                                                                              // check exam date
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,examId);
		    try(ResultSet rs=psmt.executeQuery()){
			    if(rs.next()){
			      examDate=rs.getString(1);
			    }
			    
			    if(examDate.equals(sdf.format(new Date()))){
			    return true;
			    }
		    
		    }
	    }
	      catch(SQLException e){
		e.getMessage();
		}
        return false;
        }
        
    
    public void updateDate(String examId,String date){
    String query=SQLQueries.updateExamDate;                                                                              // date updation
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,date);
	    psmt.setString(2,examId);
	    psmt.executeUpdate();
	    System.out.println();
	    System.out.println("date updated successfully");
	    System.out.println();
	    }
	      catch(SQLException e){
		e.getMessage();
		}
        }
    
    public void statusUpdate(String rollNo){
    String query=SQLQueries.updateStatus;                                                                                  // update exam status
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,"completed");
	    psmt.setString(2,rollNo);
	    psmt.executeUpdate();
	    }  
	      catch(SQLException e){
		e.getMessage();
		}
        }  
    
    public boolean checkStatus(String rollNo) {
    String status="";
     String query=SQLQueries.checkStatus;                                                                                //check exam status
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    
	    psmt.setString(1,rollNo);
		  try(ResultSet rs=psmt.executeQuery()){
			  if(rs.next()){
				status=rs.getString(1);
			  }
			  if(Objects.equals(status,"completed")){
			  return false;
			  }
		  
		    }
	    }
	      catch(SQLException e){
		e.getMessage();
		}
        return true;
        }
        
        public List<Integer> retrieveAnswer(String examId){
          ArrayList <Integer> answerRetrieve =new ArrayList();
           String query=SQLQueries.retrieveAnswer;                                   // retrieve answer from database for correction
		 try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
		    psmt.setString(1,examId);
			 try(ResultSet rs=psmt.executeQuery()){
				 while(rs.next()){
				  answerRetrieve.add(rs.getInt(1));
				   }
			   }
	    }
	    catch(SQLException e){
		e.getMessage();
		}
         return answerRetrieve;
        }
        
        public boolean checkQuestionUpload(String examId) {
        String query=SQLQueries.verifyDuplicateQuestionUpload;                                                                    // check question upload multiple times 
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,examId);
		    try(ResultSet rs=psmt.executeQuery()){
		    
			    if(rs.next()){
			      return true;
			    }   
		    }
	    }
	    catch(SQLException e){
	    e.getMessage();
	    }
    return false;
    }
    
    public List<String> retrieveUserList(){
        String query=SQLQueries.userList;   
        ArrayList<String> listOfUser=new ArrayList();                                                     // display the list of exams
		try(Statement st = connection.createStatement();ResultSet rs = st.executeQuery(query)){
		 
			while(rs.next()){
			listOfUser.add(rs.getString(1));
			}
		}
		catch(SQLException e){
		e.getMessage();
		}
        return listOfUser;
        }
        
        
     public  List<Admin> retrieveAdminList(){
     String query=SQLQueries.adminList;   
        ArrayList<Admin> listOfAdmin=new ArrayList();                                                     // display the list of exams
		try(Statement st = connection.createStatement();ResultSet rs = st.executeQuery(query)){
		 
			while(rs.next()){
			listOfAdmin.add(new Admin(rs.getString(1),rs.getString(2)));
			}
		}
		catch(SQLException e){
		e.getMessage();
		}
        return listOfAdmin;
     
     }
     public boolean checkAttendTest(String rollNo){
     
     String query=SQLQueries.checkAttendTest;                                                                              // check exam attend or not
	    try(PreparedStatement psmt=ConnectionStatement.getPreparedStatement(query)){
	    psmt.setString(1,rollNo);
		    try(ResultSet rs=psmt.executeQuery()){
			    if(rs.next()){
			      return true;
			    }
		    
	    }
	    
     
     
     }
       catch(SQLException e){
		e.getMessage();
		}
        return false;
     
    }
    }
    
