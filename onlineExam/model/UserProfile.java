package onlineExam.model;

public class UserProfile{

private String name="";
private String examName="";
private String email="";
private long contact=0;
private String rollNo="";
private UserProfile userProfile=null;

private UserProfile(){}

public UserProfile(String name,String examName,String email,long contact,String rollNo){
this.name=name;
this.examName=examName;
this.email=email;
this.contact=contact;
this.rollNo=rollNo;
}
public UserProfile getInstance(){
if(userProfile==null){
userProfile=new UserProfile();
}
return userProfile;
}

public String getName(){
return name;
}

public String getExamName(){
return examName;
}

public String getEmail(){
return email;
}

public long getContact(){
return contact;
}

public String toString(){
return "   name : "+name+"   email id : "+email+"   contact : "+contact +"  exam name : "+examName +"  rollNo:"+rollNo;
}
}
