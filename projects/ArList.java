import java.util.Scanner;
class ArList{
int size;
int capacity;
int[] arr;
int arrLength;
ArList(){
size=0;
capacity=1;
arr=new int[capacity];

}
void expandArray(){
capacity=capacity*2;
arr=java.util.Arrays.copyOf(arr,capacity);
arrLength=arr.length;
}

void add(int val){
  if(size==capacity){
    expandArray();
  }
  arr[size++]=val;
}
void addPosition(int val,int index){
if(size==capacity){
expandArray();
}
for(int i=index;i>1;i--){
  arr[i]=arr[i-1];
}
size++;
arr[index]=val;
}



/*public void display(){
for(int i=0;i<size;i++){
System.out.println(arr[i]);
}
}*/


/*void remove(int index){
for(int i=index;i>

}*/

public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        return "[" + sb.toString() + "]";
    }

public static void main(String[] args){
Scanner input=new Scanner(System.in);
ArList ar=new ArList();
ar.add(10);
ar.add(20);
//ar.display();
System.out.println(ar.arr.length);
System.out.println(ar.size);
ar.add(30);
ar.add(40);
ar.add(50);
//ar.display();
System.out.println(ar.size);
System.out.println(ar.arr.length);
ar.add(30);
System.out.println(ar.size);
System.out.println(ar.arr.length);
System.out.print(ar);

}
}
