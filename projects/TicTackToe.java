import java.util.Scanner;
class TicTackToe{
static private int r=0;
int print(char ar[][]){
for(int i=0;i<3;i++){
for(int j=0;j<3;j++){
System.out.print(ar[i][j]);
System.out.print(" ");
}
System.out.println("\n");
}
for(int i=0;i<3;i++){
if(ar[i][1]==ar[i][0] && ar[i][1]==ar[i][2]){
System.out.println("=======================");
System.out.println(" player "+ar[i][0]+" is a winner");
System.out.println("=======================");
return 1;
}
else if(ar[0][i]==ar[1][i] && ar[1][i]==ar[2][i]){
System.out.println("=======================");
System.out.println(" player "+ar[0][i]+" is a winner");
System.out.println("=======================");
return 1;
}
else if(ar[0][0]==ar[1][1] && ar[1][1]==ar[2][2]){
System.out.println("=======================");
System.out.println(" player "+ar[0][0]+" is a winner");
System.out.println("=======================");
return 1;
}
else if(ar[0][2]==ar[1][1] && ar[1][1]==ar[2][0]){
System.out.println("=======================");
System.out.println(" player "+ar[1][1]+" is a winner");
System.out.println("=======================");
return 1;
}
else{
    r++;
}
}
if(r>27){
System.out.println("=================");
System.out.println("  Game is draw");
System.out.println("=================");
}
return 0;
}
public static void main(String[] args){
char l;
int r=0;
Scanner input=new Scanner(System.in);
char[][] a={{'1','2','3'},{'4','5','6'},{'7','8','9'}};
TicTackToe t=new TicTackToe();
t.print(a);
v:
for(int i=0;i<9;i++){
if(r==0){
if(i%2==0){
System.out.println("player X can play");
l='X';
}
else{
System.out.println("player O can play");
l='O';
}
int c= input.nextInt();
a:
switch(c){
case 1:
a[0][0]=l;
r=t.print(a);
break a;
case 2:
a[0][1]=l;
r=t.print(a);
break a;
case 3:
a[0][2]=l;
r=t.print(a);
break a;
case 4:
a[1][0]=l;
r=t.print(a);
break a;
case 5:
a[1][1]=l;
r=t.print(a);
break a;
case 6:
a[1][2]=l;
r=t.print(a);
break a;
case 7:
a[2][0]=l;
r=t.print(a);
break a;
case 8:
a[2][1]=l;
r=t.print(a);
break a;
case 9:
a[2][2]=l;
r=t.print(a);
break a;
default:
System.out.println("illegal entry");
System.out.println("restart the game");
break v;
}
}
else{
break v;
}
}
}
}
