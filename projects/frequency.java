import java.util.Arrays;

public class frequency
{
	public static void main(String[] args){
	String s="abcAbc";
	/*Scanner input=new Scanner(System.in);
	System.out.println("enter the string to be convert to defined form");
	s=input.next();*/
		char[] c=s.toCharArray();
		char[] d=new char[c.length];
		int a1[]=new int[c.length];
		char temp=0;
		int t=0;
		int k=0;
		int m=0;
		for(int i=0;i<c.length;i++){
		for(int j=i;j<c.length;j++){
		if(c[i]>c[j]){
		temp=c[i];
		c[i]=c[j];
		c[j]=temp;
		}
		}
		}
		for(int i=1;i<c.length;i++){
		if(c[i]!=c[i-1]){
		d[k]=c[i-1];
		k++;
		a1[m]++;
		m++;
		}
		else{
		    a1[m]++;
		}
		}
		if(c[c.length-2]!=c[c.length-1]){
		d[k]=c[c.length-1];
		a1[m]++;
		}
		else if(c[c.length-2]==c[c.length-1]){
		d[k]=c[c.length-1];
		a1[m]++;
		}
		else{
		//System.out.println("hello"+c[c.length-2] +" "+ c[c.length-1]);
		}
		for(int i=0;i<c.length;i++){
		for(int j=i;j<c.length;j++){
		if(a1[i]<a1[j]){
		t=a1[i];
		temp=d[i];
		a1[i]=a1[j];
		d[i]=d[j];
		a1[j]=t;
		d[j]=temp;
		}
		else if(a1[i]==a1[j]){
		if(d[i]>d[j]){
		t=a1[i];
		temp=d[i];
		a1[i]=a1[j];
		d[i]=d[j];
		a1[j]=t;
		d[j]=temp;
		}
		}
		}
		}
		for(int i=0;i<a1.length;i++){
		for(int j=0;j<a1[i];j++){
		System.out.print(d[i]);
		}
		}
		System.out.println();
	}
	}

