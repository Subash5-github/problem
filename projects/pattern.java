class pattern{
public static void main(String[] args){
int k=0;
for(int i=0;i<6;i++){
for(int j=0;j<6;j++){

if(i+j>=5 && j<=5 || i==5){
k++;

System.out.print(k);

}
else{
System.out.print(" ");
}
System.out.print(" ");
}
System.out.println();

}

}


}
