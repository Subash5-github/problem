import java.util.Scanner;
 class Miamond{
public static void main(String[] args){
int n;
Scanner input = new Scanner(System.in);
System.out.println("enter the number of rows");
n=input.nextInt();
for(int i=0;i<(2*n-1);i++){
for(int j=0;j<(2*n-1);j++){
//if( j==n-1-i || j==i-n+1|| j== n-1+i || j==3*(n-1)-i){                                   // hollow diamond
if( j>=n-1-i && j>=i-n+1 && j<= n-1+i && j<=3*(n-1)-i){                                 //full diamond
   System.out.print("*");
   }
   else{
    System.out.print(" ");
}
}
System.out.print("\n");
}
}
}

