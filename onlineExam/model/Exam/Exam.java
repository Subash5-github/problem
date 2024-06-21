package onlineExam.model;

public class Exam{
private String examId;
private String examName;
private String date;
private static Exam exam=null;
private Exam(){}
public Exam getInstance(){
	if(exam==null){
	exam=new Exam();
	}
	return exam;
	}
	
 	public Exam(String examId,String examName,String date){
 	this.examId=examId;
 	this.examName=examName;
 	this.date=date;
 	}
 	
 	public String getExamId(){
 	return examId;
 	}
 	public String getExamName(){
 	return examName;
 	}

	public String getDate(){
	return date;
	}

        public String toString(){
        return  examId+"       "+examName+"        "+date;
        }
}
