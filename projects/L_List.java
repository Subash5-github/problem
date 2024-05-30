class Node<T>{
    T data;
    Node next;
    Node(T d){
        data =d;
    }
}
class list<T>{
    Node head,tail;
    void insertAtbeg(T d){
        Node newNode=new Node(d);
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

    void insertAtlast(T a){
        Node newNode=new Node(a);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;

    }
    void insertAtmid(T val,int index){
        Node newNode=new Node(val);
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;

        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    void removebydata(T a){
        Node temp=head;
        if(head.data==a){
            head=head.next;
        }
        temp=head;
        while(temp.next!=null){
            if(temp.next.data==a){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        
    }
    void removebypos(int a){
        Node temp=head;
        for(int i=0;i<a-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}

public class L_List{
    public static void main(String[] args) {
        list l=new list();
        l.insertAtbeg(1);
        l.insertAtbeg(2);
        l.insertAtbeg(3);
        
        l.insertAtlast(98);
        l.insertAtlast(655);
        l.insertAtmid(56,3);
        l.insertAtmid(96,3);
        l.insertAtmid(3,6);
        l.insertAtlast(null);
        l.insertAtlast(null);
        l.display();
        
        l.removebydata(655);
        l.removebypos(2);
        System.out.println("after remove");
        l.display();
    }
}
