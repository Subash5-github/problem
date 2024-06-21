package onlineExam.view;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Scanner;
import onlineExam.controller.ConnectionOperations;
import onlineExam.model.Admin;
import onlineExam.model.Question;
import onlineExam.model.UserProfile;
import onlineExam.model.Exam;
import onlineExam.model.Application;

class OnlineExamination{
ConnectionOperations connection=ConnectionOperations.getInstance();
Scanner scanner=new Scanner(System.in);

	public void displayProfile(List<UserProfile> profile){
	       for(UserProfile userProfile : profile){
	       System.out.println(userProfile);
	       }
	}


	public void displayExams(List<Exam> examList){
	        System.out.println("Exam Id         Exam name         Exam date");
	        for(Exam exam:examList){
	         System.out.println(exam);
	          }
	          System.out.println();
	}

	public void displayApplicationHistory(Map<String,Application>  apply){
	  for(Map.Entry<String,Application> application: apply.entrySet()){
	  
	   
	    System.out.println("userName : "+application.getKey()+application.getValue());
             System.out.println();
		  
	     }
	    

	}
	public void showQuestionAnswer(Map<String,Question> question,List<Integer> answer){
	int count=0;
	
	Iterator itr=answer.iterator();
	  
	  for(Map.Entry<String,Question> quest: question.entrySet()){
	  count=count+1;
	   System.out.println();
	    System.out.println(count+") "+"("+quest.getKey()+")"+" "+quest.getValue());
	    System.out.println();
	    
	    }

          
     }




	public void evaluation(String rollNo,List<Question> examQuestion,List<Integer> answer){
	int option=0;
	System.out.println("enter the valid options");
	ArrayList<Integer> userAnswer=new ArrayList();
	boolean isValid;
 		for (Question question:examQuestion){
                isValid=true;
                System.out.println(question);
                System.out.println("enter your options");
                 while(isValid){
                 
                 option=scanner.nextInt();
                 if(option>0 && option<5){
                  userAnswer.add(option);
                  isValid=false;
                   continue;
                 }
                   //isValid=false;
                System.out.println("give valid option");
                }
            }
            scanner.nextLine();
        result(rollNo,answer,userAnswer);

    }
    
    
    
    public void result(String rollNo, List<Integer> answer,List<Integer> userAnswer){
    int totalQuestions=0;
    int correctAnswer=0;
       Iterator itr1=answer.iterator();
        Iterator itr2=userAnswer.iterator();
        while(itr1.hasNext()){
            if (itr1.next().equals(itr2.next())) {
                correctAnswer++;
            }
            totalQuestions++;
        }
        try{
        connection.setResult(rollNo,correctAnswer);
        }
        catch(Exception e){
        e.getMessage();
        }
        //System.out.println("your score is"+correctAnswer+"out of"+totalQuestions);
        
        }
        
        
    
     public void addExam() throws Exception{
        System.out.println("enter the examId");
        String examId=scanner.nextLine();
        if(!(connection.checkExamId(examId))){
        System.out.println("enter the exam name");
        String examName=scanner.nextLine();
        System.out.println("enter the exam date");
        String examDate=scanner.nextLine();
        connection.setExam(examId,examName,examDate);
         }
	else{
	System.out.println();
	System.out.println("exam id already exists");
	System.out.println();
         }
        
        }
        
  public void updateQuestionDetails(String questionId) throws Exception{
    System.out.println("enter the question description");
    String description=scanner.nextLine();
    System.out.println("enter the question option1");
    String op1=scanner.nextLine();
    System.out.println("enter the question option2");
    String op2=scanner.nextLine();
    System.out.println("enter the question option3");
    String op3=scanner.nextLine();
    System.out.println("enter the question option4");
    String op4=scanner.nextLine();
    
    connection.updateQuestion(questionId,new Question(description,op1,op2,op3,op4));
    
    }
    
    

public void applicationDetails(String examId,String userName) throws Exception{
        
         boolean isValidEmail=true;
         String email="";
         long contact=0l;
         boolean isValidContact=true;
        System.out.println("enter the name");
        String name=scanner.nextLine();
        
        while(!(connection.validateName(name))){
        System.out.println("enter the correct name that contains only alphabets name and initial should seperated by single space");
         name=scanner.nextLine();
        }
        
        while(isValidEmail){
        System.out.println("enter your email");
        email=scanner.nextLine();
        if(email.endsWith("@gmail.com")&&email.length()>13){
        isValidEmail=false;
        continue;
        }
        System.out.println("enter the emailId in correct format of ------@gmail.com and email should have 13 characters including @gmail.com");
        }
        
       System.out.println("enter your contact number");
         contact=scanner.nextLong();
        scanner.nextLine();
        while(!(connection.validateNumber(contact))){
         System.out.println("enter the contact number in correct format of 10 digits");
         contact=scanner.nextLong();
         scanner.nextLine();
        }
        
        
        
        
        String rollNo=connection.rollNumGeneration(examId);
        if(connection.checkDuplicateRegisteration(userName,examId,email,contact)){
          connection.setApplication(examId,userName,new Application(name,email,contact,rollNo));
        }
        else{
          System.out.println("duplicate username or contact or email id for same exam exists!!! \n be aware before enter");
        }
        
    }

public void addQuestion(String examId) throws Exception{
     //ArrayList<Integer> answer=new ArrayList();
   TreeMap<String,Question> quest=new TreeMap();
    
    
    int count=0;
        System.out.println("enter the number of question to be added, once you added you can update but can add new question be aware before enter the number of question");
       int noOfQestions=scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < noOfQestions; i++) {
            count=count+1;
            String questionId = "q_"+examId+"_"+(count);
            System.out.println("enter the question");
            String question = scanner.nextLine();
            System.out.println("enter the option1");
            String op1 = scanner.nextLine();
            System.out.println("enter the  option2");
            String op2 = scanner.nextLine();
            System.out.println("enter the  option3");
            String op3 = scanner.nextLine();
            System.out.println("enter the  option4");
            String op4 = scanner.nextLine();
            System.out.println("enter the  answer");
            int answer = scanner.nextInt();
            scanner.nextLine();
            quest.put(questionId, new Question(question, op1, op2, op3, op4,answer));
           // q.setQuestionId(q);
            //answer.add(ans);
            //System.out.println(questionId);
            //
        }
        connection.setQuestion(examId,quest);
    }
    
    
    
    public void displayUser(List<String> user){
    Iterator itr=user.iterator();
    System.out.println();
    System.out.println("user list");
    System.out.println("----------");
	    while(itr.hasNext()){
	    System.out.println(itr.next());
	    }
   System.out.println();
    }
    
    public void displayAdmin(List<Admin> userAdmin){
    
   
    System.out.println();
    System.out.println("Admin list");
    System.out.println("------------");
    System.out.println("username       password");
	   for(Admin admin:userAdmin){
	   System.out.println(admin);
	   System.out.println();
	   }
   
    }

}




















