class Node{
int value;
Node next;
Node(int value){
this.value=value;

}
}

class Deque{
Node head,tail;

void addFirst(int val){
Node newNode =new Node(val);
if(head==null){
head=newNode;
tail=newNode;
}
else{
tail=head;
head=newNode;
head.next=tail;
}

}

void addLast(int val){
Node temp=head;
Node newNode=new Node(val);
while(temp.next!=null){
temp=temp.next;

}
temp.next=newNode;

}

void removeFirst(){
Node temp=head;
temp=temp.next;
temp=head;
}

void removeLast(){
Node temp=head;
Node prev=null;
while(temp.next.next!=null){
prev=temp;
temp=temp.next;
}
prev.next=null;
}

void display(){
Node temp=head;
while(temp!=null){
System.out.println(temp.value);
temp=temp.next;
}
}
public String toString(){
Node temp=head;
StringBuilder sb=new StringBuilder();
while(temp!=null){
sb.append(temp.value).append(" ");
temp=temp.next;
}
return "["+sb.toString()+"]";
}

}

class Deq{
public static void main(String[] args){
Deque d=new Deque();
d.addFirst(10);
d.addFirst(20);
d.addLast(30);
d.addLast(40);
d.display();
System.out.println(d);

}

}
