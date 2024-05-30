 import java.util.Scanner;
 class Except extends RuntimeException{
 Except(String message){
 super(message);
 }
 }
 class Nun{
 int y=0;
 int g=0;
  int[] a={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
 public void availability(){
 for(int i=0;i<a.length;i++){
   if(i%8==0){
   System.out.println();
   }
   System.out.print(a[i]+" ");
   if(i<9){
   System.out.print(" ");
   }
 }
 }
 public void book(int h) throws Except{
g=0;
 if(h>a.length || h<=0){
 throw new Except("Invalid seat number");
 //System.out.println("invalid seat number");
 }
 else{
 for(int i=0;i<a.length;i++){
 if(a[i]==h && h>0 && h<=a.length){
 a[i]=0;
 g=1;
 break;
 }
 else if(a[i]!=h && h<=a.length && h>0){
 g=2;
 }
 }
 }
 bookMessage(g);
 }
 public void bookMessage(int f) throws Except{
 if(f==1){
 throw new Except("Seat booked successfully");
  //System.out.println("seat booked successfully");
 }
 else if(f==2){
  throw new Except("seat number you enter was already booked");
 //System.out.println("seat already booked");
 }
 }
 public void cancel(int j){
 y=0;
  if(j==0 || j>a.length){
  throw new Except("Invalid seat number");
 //System.out.println("invalid seat number");
 }
else{
 for(int i=0;i<a.length;i++){
 if(j-1==i && a[i]!=j){
 a[i]=j;
 y=1;
 break;
 }
 else if(a[i]==j){
 y=2;
 }
  }
 }
 message(y);
 }
public void message(int m) throws Except{
if(m==1){
throw new Except("Ticket cancelled successfully");
//System.out.println("ticket cancelled successfully");
}
else if(m==2){
throw new Except("This ticket is not booked yet");
//System.out.println("this ticket is not booked yet");
}
}
 }
class Movie{
public static void main(String[] args){
Scanner input=new Scanner(System.in);
Nun n=new Nun();
//Joker j=new Joker();
while(true){
System.out.println();
System.out.println("=====================================================================");
System.out.println("Welcome to BOOK - YOUR - SHOW");
System.out.println("enter 1 to check the availability of tickets for joker movie");
System.out.println("enter 2 to book tickets for joker movie");
System.out.println("enter 3 to cancel booked tickets for joker");
System.out.println("enter 4 to exit from the application");
System.out.println("=====================================================================");
System.out.println();
System.out.println("enter your choice ");
int ch=input.nextInt();
switch(ch){
case 1:
n.availability();
break;
case 2:
System.out.println();
System.out.println("enter the seat number to be booked");
int k=input.nextInt();
try{
n.book(k);
}
catch(Except e){
System.out.println(e.getMessage());
}
break;
case 3:
System.out.println("enter the seat number to be cancel");
int c=input.nextInt();
try{
n.cancel(c);
}
catch(Except e){
System.out.println(e.getMessage());
}
break;
case 4:
    System.out.println("=================================================");
    System.out.println("Thank you for visiting, enjoy your movie");
    System.out.println("=================================================");
    System.exit(0);
    break;
default:
    System.out.println("Invalid choice");
}
}
}
}
