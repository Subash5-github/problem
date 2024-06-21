package onlineExam.view;

import java.util.Scanner;
import onlineExam.controller.ConnectionOperations;
import onlineExam.model.Exam_User;
public class ExamPortalMenu extends OnlineExamination implements Exam_User{
//static Scanner sc=new Scanner(System.in);
//static ConnectionOperations connection=ConnectionOperations.getInstance();


public void userMenu(String userName,String password)throws Exception{
  
	
		         
		         
		         String examId="";
		         while(true){
				 System.out.println("enter your choice \n 1.Exam list \n 2.Exam application  \n 3.view profile \n 4.view result \n 5.start test \n 6.back");
				 int choice=scanner.nextInt();
				 scanner.nextLine();
		         
		         
		         switch(choice){
		         
		         case 1:
		         
		           displayExams(connection.examList());
		           break;
		         
		         case 2:
		         
		       
		         System.out.println("enter the correct id shown in above list which you want to apply");
		         boolean isValid =true;
		         
		         while(isValid){
		         examId=scanner.nextLine();
		         if(connection.checkExamId(examId)){
		           isValid=false;
		           continue;
		         }
		         System.out.println("enter the correct id");
		         }
		         
		         applicationDetails(examId,userName);
		         
		         
		         break;
		         
		         case 3:
		         displayProfile(connection.applicantProfile(userName));
		         break;
		         
		         case 4:
		         System.out.println("enter the examId");
		         examId=scanner.nextLine();
		         if(connection.getRollNoByUserName(userName,examId).equals("none")){
		         System.out.println("enter correct examId ");
		         }
		         else{
		         if(connection.checkAttendTest(connection.getRollNoByUserName(userName,examId))){
		         System.out.println(connection.showResult(connection.getRollNoByUserName(userName,examId)));
		         }
		         else{
		         System.out.println("you have not attend the test yet");
		         }
		         }
		         break;
		         
		         case 5:
		         System.out.println("enter the examId");
		         examId=scanner.nextLine();
		         if(connection.ensureApplication(connection.getRollNoByUserName(userName,examId),examId)){
		           if(connection.checkDate(examId)){
		            if(connection.checkStatus(connection.getRollNoByUserName(userName,examId))){
		           
		           evaluation(connection.getRollNoByUserName(userName,examId),connection.attendTest(examId),connection.retrieveAnswer(examId));
		           }
				else{
				     System.out.println("you response have been received , you cant change or edit your response");
				   }
		           }
		           else{
		           System.out.println("check the exam date");
		           }
		         
		         }
		         else{
		         System.out.println("invaild examId");
		         }
		         break;
		         
		         case 6:
		         return;
		         
		         default:
		         System.out.println("invalid choice");
		         break;
		         }
}

}

public void adminMenu() throws Exception{
                   boolean isValid=true;
                   String examId="";
                   String questionId="";
                   
                   while(true){
                    System.out.println("enter your choice    \n 1.Add exam  \n 2.Exam list \n 3.Application history using examId \n 4.show question and answer \n 5.set question for exam \n 6.question update  \n 7.update answer\n 8.view result  \n 9.update exam date \n 10.users list \n 11.Back");
                    int choice=scanner.nextInt();
		   scanner.nextLine();
		   
		   switch(choice){
		  
		     
		   case 1:
		     addExam(); 
		     break;
		     
		     
		     case 2:
		     displayExams(connection.examList());
		     break;
		     
		   case 3:
		   System.out.println("enter the examId for which you want to check the history of application");
		   examId=scanner.nextLine();
		   if(connection.checkExamId(examId)){
		   displayApplicationHistory(connection.applicantHistory(examId));
		   }
		   else{
		   System.out.println("exam id does not exists");
		   }
		   break;
		   
		   case 4:
		   System.out.println("enter the examId for which you want to see the question and answer");
		   examId=scanner.nextLine();
		   if(connection.checkExamId(examId)){
		   showQuestionAnswer(connection.showQuestions(examId),connection.retrieveAnswer(examId));
		   
		   }
		   else{
		   System.out.println("exam id does not exists");
		   }
		   break;
		   
		   case 5:
		   System.out.println("enter the examId for which you want to set question");
		    examId=scanner.nextLine();
		   if(connection.checkExamId(examId)){
		   if(!(connection.checkQuestionUpload(examId))){
		   addQuestion(examId);
		   }
		   else{
		   System.out.println("questions are already uploaded, you can only update the question");
		   }
		   }
		   
		  
		   else{
		   System.out.println("exam id does not exists");
		   }
		   break;
		   
		   case 6:
		   System.out.println("enter the question id in which you want to make update");
		   questionId=scanner.nextLine();
		   if(connection.checkQuestionId(questionId)){
		   updateQuestionDetails(questionId);
		   }
		   else{
		   System.out.println("question id does not exists");
		   }
		   break;
		   
		   case 7:
		   
		   int answer=0;
		   System.out.println("enter the question id in which you want to change the answer");
		   questionId=scanner.nextLine();
		   if(connection.checkQuestionId(questionId)){
		   System.out.println("enter the answer");
		   
		   while(isValid){
		   answer=scanner.nextInt();
		   scanner.nextLine();
		   if(answer>0 && answer<5){
		   isValid=false;
		   }
		   
		   System.out.println("enter the valid option between 1 and 4");
		   }
		   connection.updateAnswer(questionId,answer);
		   }
		   else{
		   System.out.println("question id does not exists");
		   }
		   break;
		   
		   
		   case 8:
		   
		   System.out.println("enter the examId for which you want to see the result");
		   examId=scanner.nextLine();
		   if(connection.checkExamId(examId)){
		   connection.resultForAdmin(examId);
		   }
		   else{
		   System.out.println("exam id does not exists");
		   }
		   break;
		   
		   case 9:
		   System.out.println("enter the examId for which you want to update the date");
		   examId=scanner.nextLine();
		  
		   if(connection.checkExamId(examId)){
		    System.out.println("enter the new date");
		   String date=scanner.nextLine();
		   connection.updateDate(examId,date);
		   }
		   else{
		   System.out.println("exam id does not exists");
		   }
		   break;
		   
		   case 10:
		   displayUser(connection.retrieveUserList());
		   break;
		   
		   case 11:
		   return;
		   
		  default:
		  System.out.println("invalid choice");
		  break;
                    }
                   }
                    

}

public void newUser() throws Exception{


  System.out.println("enter your username(userName must contains 5 to 25 characters contains both alphabets and number and staring character should be an alphabet)");
  String userName=scanner.nextLine();
  System.out.println("enter your password(password must contains 6 to 15 characters that include alphabets ,numbers,special characters and starting character should be an alphabet)");
  String password=scanner.nextLine();
  connection.userLoginDetails(userName,password);

               

}

public void rootAdminMenu(){

int choice=0;
                while(true){
                System.out.println("enter your choice \n 1.Add Admin \n 2.show Admin list  \n 3.back");
                choice = scanner.nextInt();
                switch(choice){
                
             case 1:
		    
		    connection.addAdminDetails();
		     break;
		     
            case 2:
            
                  displayAdmin(connection.retrieveAdminList());
                   break;
	    case 3:
	  
	           return;
	           
	     default:
	     System.out.println("invalid choice");     
}
}
}


}
