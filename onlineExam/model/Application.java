package onlineExam.model;

public class Application{

private String name;
private String rollNo;
private String email;
private long contact;
private static  Application application=null;
        private Application(){}
        
	public Application(String name,String email,long contact,String rollNo){
	this.name=name;
	this.email=email;
	this.contact=contact;
	this.rollNo=rollNo;
	}
	public static Application getInstance(){
	if(application==null){
	application=new Application();
	}
	return application;
	}
        
        public String getName(){
        return name;
        }
        
        public String getRollNumber(){
        return rollNo;
        }
        
        public String getEmail(){
        return email;
        }
        public long getContact(){
        return contact;
        }
        public String toString(){
        return "  rollno : "+rollNo+"   name : "+name+"   email id : "+email+"   contact : "+contact;
        
        }
        
  }      
