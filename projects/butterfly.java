import java.util.Scanner;
class butterfly{
public static void main(String[] args){
int n;
Scanner input=new Scanner(System.in);
System.out.println("enter the row number");
n=input.nextInt();
for(int i=0;i<2*n-1;i++){
for(int j=0;j<2*n-1;j++){
if(j+i<2*n-1 && j<=i || i+j>=2*n-2 && j>=i  ){             
System.out.print("*");
}
else{
System.out.print(" ");
}
}
System.out.println("");
}
}

}


