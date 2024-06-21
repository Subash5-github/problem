package onlineExam.controller;

public final class SQLQueries{


public static final String addQuestion="insert into question values(?,?,?,?,?,?,?,?)";

public static final String retrieveQuestion="select description,option1,option2,option3,option4 from question where examid=?";

public static final String retrieveAnswer="select answer from question where examid=?";

public static final String storeResult="insert into result values(?,?)";

public static final String examList="select * from exam";

public static final String addExam="insert into exam(examid,examname,examdate) values(?,?,?)";

public static final String setApplication="insert into registeration values(?,?,?,?,?,?)";

public static final String getRollNoByUserName="select rollno from registeration where rollno=?";

public static final String checkExamid="select examid from exam where examid=?";

public static final String verifyDuplicates="select examid,username,email,contact from registeration where examid=? AND username=? OR email=? OR contact=?"; 

public static final String viewProfile="select registeration.name,exam.examname,registeration.email,registeration.contact,registeration.rollno from registeration join exam on exam.examid=registeration.examid where registeration.userName=?";


public static final String verifyQuestionId="select questionid from question where questionid=?";

public static final String questionUpdate="update question set description=?,option1=?,option2=?,option3=?,option4=? where questionid=?"; 

public static final String answerUpdate="update question set answer=? where questionid=?";

public static final String duplicateUsername="select username from userdetails where username=?";


public static final String newUser="insert into userDetails values(?,?)";

public static final String newAdmin="insert into admin values(?,?)";

public static final String applicationHistory="select rollno,username,name,email,contact from registeration where examid=?";

public static final String showQuestionAnswer="select questionid,description,option1,option2,option3,option4,answer from question where examid=?";

public static final String resultForAdmin="select registeration.examid,result.rollno,registeration.username,registeration.name,registeration.contact,result.mark from         registeration join result on registeration.rollno=result.rollno where registeration.examid=?";

public static final String getRollNo="select rollno from registeration where username=? AND examid=?";

public static final String resultForUser="select mark from result where rollno=?";

public static final String verifyUserLogin="select username,password from userDetails where username=? AND password=?";

public static final String verifyAdminLogin="select username,password from admin where username=? AND password=?";

public static final String verifyRollNoExamId="select rollno,examid from registeration where rollno=? AND examid=?";

public static final String verifyExamDate="select examdate from exam where examid=?";

public static final String updateExamDate="update exam set examdate=? where examid=?";

public static final String updateStatus="update result set status=? where rollNo=?";

public static final String checkStatus="select status from result where rollno=?";
    
public static final String verifyDuplicateQuestionUpload= "select examid from question where examid=?";  

public static final String userList="select username from userdetails";

public static final String adminList="select * from admin";

public static final String checkAttendTest="select rollno from result where rollno=?";
}
