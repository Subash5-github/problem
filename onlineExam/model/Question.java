package onlineExam.model;

import java.util.Set;
public class Question{

private String description;
private String option_1;
private String option_2;
private String option_3;
private String option_4;
private int answer;

private static Question question=null;
private Question(){}
public static Question getInstance(){
	if(question==null){
	question=new Question();
	}
	return question;
	}


	public Question(String description,String option_1,String option_2,String option_3,String option_4,int answer){
	this.description=description;
	this.option_1=option_1;
	this.option_2=option_2;
	this.option_3=option_3;
	this.option_4=option_4;
	this.answer=answer;
	}
	
	public Question(String description,String option_1,String option_2,String option_3,String option_4){
	this.description=description;
	this.option_1=option_1;
	this.option_2=option_2;
	this.option_3=option_3;
	this.option_4=option_4;
	
	}
	
	
        
	public String getDescription(){
	return description;
	}
	
	public String getOption1(){
	return option_1;
	}
	
	public String getOption2(){
	return option_2;
	}
	
	public String getOption3(){
	return option_3;
	}
	
	public String getOption4(){
	return option_4;
	}
	
	public int getAnswer(){
	return answer;
	}
	
	
	public String toString(){
	return description +"\n"+"1. "+option_1+"  "+"2. "+option_2+"  "+"3. "+option_3+"  "+"4. "+option_4+"\n"+"Answer - "+answer;
	}

}
