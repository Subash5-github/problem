import java.util.*;
class LinkedNode<T>{
LinkedNode next;
T key,value;

  LinkedNode(T key,T value){
   this.key=key;
   this.value=value;

   }
   }
class LinkedHashMap<T>{
    LinkedNode[] buckets;
    int numBuckets;
    int bucketIndex;
    LinkedHashMap(){
     this(10);
    }


    LinkedHashMap(int numOfBuck){
         numBuckets=numOfBuck;
         buckets=new LinkedNode[numBuckets];
    }


     int getbucket(T key){
      if(key==null){
      return 0;
      }
       return Math.abs(key.hashCode()) % numBuckets ;
     }


void put(T key,T value){

bucketIndex=getbucket(key);
LinkedNode head=buckets[bucketIndex];
LinkedNode temp=head;
if(head==null){
LinkedNode newNode=new LinkedNode(key,value);
buckets[bucketIndex]=newNode;

return;
}
while(temp!=null){
if(Objects.equals(temp.key,key)){
temp.value=value;
return;
}
temp=temp.next;
}
LinkedNode newNode=new LinkedNode(key,value);
temp=head;
while(temp.next!=null){
temp=temp.next;
}
temp.next=newNode;
}

void remove(T k){

   bucketIndex=getbucket(k);
   LinkedNode head=buckets[bucketIndex];
    LinkedNode previous=null;
    while(head!=null){
    if(Objects.equals(head.key,k)){
    break;
    }
    previous=head;
    head=head.next;
    }
    if(head==null){
     System.out.println("null");
    }
    else if(previous!=null){
    previous.next=head.next;
    }
    else{
      buckets[bucketIndex]=head.next;
    }

}

boolean set(T k,T val){
bucketIndex=getbucket(k);
LinkedNode head=buckets[bucketIndex];
while(head!=null){
if(Objects.equals(head.key,k)){
head.value=val;
return true;
}
head=head.next;
}
return false;
}

void display(){
for(LinkedNode l:buckets){
while(l!=null){
System.out.println(l.key +"="+l.value);
l=l.next;
}

}

}
}



class LinkedHMap{
public static void main(String[] args){
LinkedHashMap l=new LinkedHashMap();
l.put(1,"subash");
l.put(2,"hello");
l.put(2,"hell");
l.put(null,"hello");
l.put(null,"ho");
l.put("subash",1);
l.remove(1);
System.out.println(l.set(3,"hellooooo"));
l.display();
}
}
