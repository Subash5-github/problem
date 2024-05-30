import java.util.Scanner;
 class database{
int total=0;
 float average;
 database(int ar[], String str[],String h){
 System.out.println("The "+h+" result are");
   for(int i=0;i<str.length;i++){
   if(ar[i]>=35 && ar[i]<=100){
      System.out.println(ar[i]+"                   pass");
      }
      else if(ar[i]<35 && ar[i]>0){
      System.out.println(ar[i]+"                   fail");}
      else{
      System.out.println(ar[i]+"                   invalid");
      }
 }
 }
 database(int ar[],String str[],int n){
 int temp=0;
 String temp1="";
 for(int i=0;i<str.length;i++){
 total+=ar[i];
 }
  System.out.println("total mark out of "+n+" is "+total);
 average=total/str.length;
 System.out.println("Average mark is "+average);
 for(int i=0;i<str.length;i++){
 for(int j=i+1;j<str.length;j++){
 if(ar[i]<ar[j]){
 temp=ar[i];
 temp1=str[i];
 ar[i]=ar[j];
 str[i]=str[j];
 ar[j]=temp;
 str[j]=temp1;
 }
 }
 }
 System.out.println("\n");
 System.out.println("markwise list");
 System.out.println("\n");
 for(int i=0;i<str.length;i++){
 System.out.println(str[i]+" " + " "+ar[i]);
 }
 }
}
public class student{
public static void main(String[] args){
 Scanner input=new Scanner(System.in);
 Scanner inp=new Scanner(System.in);
 String str1[] = {"tamil","english","maths","science","s.science"};
 String str2[] = {"tamil","english","maths","physics","chemistry","biology"};
 int ar1[]=new int[str1.length];
  int ar2[]=new int[str2.length];
  int or1[]=new int[str1.length];
  int or2[]=new int[str2.length];
 System.out.println("enter the exam name SSLC/HSE in full capital letter");
 String s=inp.nextLine();
 if(s.equals("SSLC")){
   for(int i=0;i<str1.length;i++){
 System.out.println("enter the "+str1[i]+" mark");
 ar1[i]=input.nextInt();
 }
    database d=new database(ar1,str1,s);
   database d1=new database(ar1,str1,500);
 }
 else if(s.equals("HSE")){
 for(int i=0;i<str2.length;i++){
 System.out.println("enter the "+str2[i]+" mark");
 ar2[i]=input.nextInt();
 }
 database d=new database(ar2,str2,s);
   database d1=new database(ar2,str2,600);
 }
  else{
   System.out.println("Invalid exam name");
 }
}
}





