import java.util.Scanner;
class students{
  int c;
    static int f[]=new int[5];
  public int student(String h[],int a[],String n[],int l){
   c=0;
  int total=0;
  Scanner input=new Scanner(System.in);
   for(int i=0;i<h.length;i++){
     System.out.println("enter the "+h[i]+" marks");
    a[i]=input.nextInt();
    total=total+a[i];
  if(a[i]<=35){
     f[l]=++c;
  }
  }
 if(c==0){
 return total;
 }
 else{
 return 0;
 }
 }
void rank(String s1[],int ar1[]){
for(int i=0;i<ar1.length;i++){
     for(int j=i;j<ar1.length;j++){
     int temp=0;
     int temp2=0;
     String temp1=" ";
     if(ar1[i]<ar1[j]){
     temp=ar1[i];
     temp2=f[i];
     temp1=s1[i];
     ar1[i]=ar1[j];
     f[i]=f[j];
     s1[i]=s1[j];
     ar1[j]=temp;
     s1[j]=temp1;
     f[j]=temp2;
}
}
}
for(int i=0;i<ar1.length;i++){
if(ar1[i]>0){
System.out.println("the rank " +(i+1)+ " is "+s1[i] +" with total marks of " +ar1[i]);
}
}
System.out.println(" ");
System.out.println("failed students list ");
System.out.println(" ");
for(int i=0;i<ar1.length;i++){
if(ar1[i]==0){
System.out.println("the student "+s1[i] +" was Failed in "+ f[i]+ " subjects");
}
}
}
}
public class database{
public static void main(String[] args){
Scanner input=new Scanner(System.in);
Scanner inp=new Scanner(System.in);
String s[]={"tamil","english","maths","science","social science"};
students p=new students();
int ar[]=new int[s.length];
System.out.println("enter the number of students");
int n=input.nextInt();
String name[]=new String[n];
int ar1[]=new int[name.length];
   students[] s1=new students[n];
for(int i=0;i<n;i++){
   System.out.println(" ");
   System.out.println("enter the student "+(i+1)+" name");
   name[i]=inp.nextLine();
   s1[i]= new students();
   ar1[i]=s1[i].student(s,ar,name,i); 
   System.out.println("===========================================================");
}
p.rank(name,ar1);
}
}


