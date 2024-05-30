class merge{
public static void main(String[] args){
int a1[]={1,5,6,11,-9};
int a2[]={2,3,7,4};
int b[]=new int[a1.length+a2.length];
int temp=0;
int i=0;
while(i<b.length){
if(i<a1.length){
b[i]=a1[i];
}
else{
b[i]=a2[i-a1.length];
}
i++;
}
int k=0;
while(k<b.length){      
int j=k;                                 //(int i=0;i<b.length;i++)
 while(j<b.length){
 if(b[j]<b[k]){
 temp=b[j];
 b[j]=b[k];
 b[k]=temp;
 }
  j++;
 }
 k++;
}
int w=0;
while(w<b.length){
System.out.println(b[w]);
w++;
}
}
}




