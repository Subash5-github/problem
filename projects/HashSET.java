import java.util.*;
//import java.util.HashSet;
class HashNode<T>{
T val;
HashNode next;
HashNode(T val){
this.val=val;
}

}
class Hashset<T>{
    HashNode buckets[];
    int size=0;
    int bucketIndex;
Hashset(){
    this(10);
}
Hashset(int capacity){
    buckets=new HashNode[capacity];
}
int getBuckets(T val){
if(val==null){
return 0;
}
return Math.abs(val.hashCode())% buckets.length;
}
   void add(T val){
	bucketIndex=getBuckets(val);
	HashNode head=buckets[bucketIndex];
		if(head==null){
		buckets[bucketIndex]=new HashNode(val);
		size++;
		return;
		}
	while(head!=null){
		if(Objects.equals(head.val,val)){
		head.val=val;
		return;
		}
	          head=head.next;
	}
	size++;
	HashNode newNode=new HashNode(val);
	head=buckets[bucketIndex];
	
	while(head.next!=null){
		head=head.next;
	}
		head.next=newNode;
	}
   void remove(T val){
	bucketIndex=getBuckets(val);
	HashNode head=buckets[bucketIndex];
	HashNode previous=null;
	while(head!=null){
		if(Objects.equals(head.val,val)){
		break;
		}
		previous=head;
		head=head.next;
	}
	if(head==null){
		System.out.println("head is null");
	}
	else if(previous!=null){
	         size--;
		previous.next=head.next;
	}
	else{
		buckets[bucketIndex]=head.next;
		size--;
	}

}
   void clear(){
	Arrays.fill(buckets,null);
	size=0;
}
   int size(){
   return size;
   
   }	
   
   public String toString(){
   StringBuilder s=new StringBuilder();
   for(HashNode hash:buckets){
   while(hash!=null){
   s.append(hash.val).append(" ");
   hash=hash.next;
   }
   }
   return s.toString();
   }
   void display(){
   for(HashNode hash:buckets){
	while(hash!=null){
          System.out.println(hash.val);
          hash=hash.next;
	}
       }
}

public Hashset<T> clone(){
   Hashset<T> s=new Hashset(buckets.length);
   for(HashNode<T> h:buckets){
   //HashNode<T> h=buckets[i];
   while(h!=null){
   s.add(h.val);
   h=h.next;
   }
   
   }
   
   return s;
   }
 
   /*public Hashset<T> clone(){
   Hashset<T> s=new Hashset(buckets.length);
   for(int i=0;i<buckets.length;i++){
   HashNode<T> h=buckets[i];
   while(h!=null){
   if(h!=null){
   s.add(h.val);
   
   }
   h=h.next;
   }
   }
   return s;
   }    */
}

class HashSET{
public static void main(String[] args){
Hashset h=new Hashset();

h.add(10);
h.add(8.9);
h.add(10);
h.add(null);
h.add(null);
//h.remove(null);
//h.remove(8.9);
//h.display();
/*System.out.println(h.size());
h.clear();
System.out.println("after clear");
System.out.println(h.size());
//h.display();*/
Hashset h1=h.clone();
System.out.println(h);

h1.add("SUBASH");
System.out.println(h1);
h.display();
//System.out.println(h);

}
}
