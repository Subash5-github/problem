
import java.util.*;

class Book{

    int id;
    String name;
    int count;
    int availableCount;
    String author;
    int timesOfTake=0;
    Book(int id,String name,String author,int count){
        this.id=id;
        this.name=name;
        this.count=count;
        this.author=author;
        availableCount=count;
    }
    public int getId(){
        return id;
    }
    public int getAvailableCount(){
        return availableCount;
    }
    public String getName(){
       return name;
    }
    public String getAuthor(){
    return author;
    }
    public void borrowBook(){
        if(availableCount>0){
            availableCount--;
            timesOfTake++;
           // System.out.println("book borrowed successfully");
        }

    }
    public boolean returnStatus(){
        if(count>availableCount){
            return true;
        }
        else{
            return false;
        }
    }
    public void returnBook(){
        //if(count>availableCount){
           // System.out.println("book returned successfully");
            availableCount++;
    }
    public int timesOfTaken(){
        return timesOfTake;
    }
    public String getHaving(){
    return id+" "+name+" "+author;
    }
    public String toString(){
        return id+" "+name+" "+author+" "+availableCount;
    }
}

class Member{
    int id;
    String name;
    int timesOfTake=0;
    Member(int id,String name){
        this.id=id;
        this.name=name;

    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void borrowMember(){
        timesOfTake++;
    }
    public int timesOfTaken(){
        return timesOfTake;
    }
    public String toString(){
        return id+" "+name;
    }
}

class Transaction{
    Book book;
    Member member;
    int status;
    Transaction(Book book,Member member,int status){
        this.book=book;
        this.member=member;
        this.status=status;
    }
    public Book getBook(){
        return book;
    }
    public Member getMember(){
        return member;
    }
    public void returnBookStatus(){
        status=0;
    }
    public int getStatus(){
        return status;
    }
    public String toString(){
        return "transaction "+member+" " +book;
    }
}
public class Library1 {
    HashMap<Integer ,Book> book;
    HashMap<Integer ,Member> members;
    ArrayList<Transaction> transaction;
    Library1(){
        book=new HashMap();
        members=new HashMap();
        transaction=new ArrayList();
    }
    public void addBook(int id,String name,String author,int count){
        book.put(id,new Book(id,name,author,count));
    }
    public void addMember(int id,String name){
        members.put(id,new Member(id,name));
    }

    public void borrowBook(int bookId,int memId){
        Book b=book.get(bookId);
        Member m=members.get(memId);
        if(b!=null && m!=null && b.getAvailableCount()>0){
            b.borrowBook();
            m.borrowMember();
            transaction.add(new Transaction(b,m,1));
            System.out.println("book borrowed successfully");

        }
        else{
            System.out.println("incorrect id or availability may not be there 1check the availability");
        }
    }
    public void returnBook(int bookId,int memId){
        for(Transaction t:transaction){
            if(t.getBook().getId()==bookId && t.getMember().getId()==memId && t.getBook().returnStatus()){
                t.getBook().returnBook();
                t.returnBookStatus();
               // transaction.remove(t);

                System.out.println("book returned successfully");
                return;
            }
        }
        System.out.println("incorrect id or book is not borrowed yet");
    }

    public void mostBorrowBook(){
        Book most=null;
        int m=0;
        for(Book b: book.values()){
            if(b.getAvailableCount()>m){
                m=b.getAvailableCount();
                most=b;
            }
        }
        System.out.println("The person with id "+most.getId() +" name "+most.getName()+" takes more book");
    }

    public void mostBorrowPerson(){
        Member most=null;
        int m=0;
        for(Member b: members.values()){
            if(b.timesOfTaken()>m){
                m=b.timesOfTaken();
                most=b;
            }
        }
        System.out.println("The person with id "+most.getId() +" name "+most.getName()+" takes more book");
    }

    public void borrowedBooks(){
        for(Transaction t:transaction){
            if(t.getStatus()>0){
                System.out.println(t.getBook().getId()+" name "+t.getBook().getName()+ " borrowed by "+t.getMember().getId() +" name "+t.getMember().getName());
            }
        }
    }

    public void availableBooks(){
        for(Book b:book.values()){
            System.out.println(b.getId()+" "+b.getName()+" "+" "+b.getAuthor()+" "+b.getAvailableCount());
        }
    }

    public void personHavingBooks(int memId){
        Member m;
        for(Transaction t:transaction){
            if(t.getMember().getId()==memId){

                System.out.println(t.getBook().getHaving());
            }
        }

    }
    public static void main(String[] args) {
        Library1 l=new Library1();
        Scanner input=new Scanner(System.in);
        Scanner inp=new Scanner(System.in);
        int a = 0;
        int bookId = 0;
        String bookName = "";
        String author = "";
        int count = 0;
        int memId = 0;
        String memName = "";
        while(true){
            System.out.println("enter your choice");
            System.out.println("------------------------");
            a=input.nextInt();
            switch(a){
                case 1:
                    System.out.println("Available books are");
                    l.availableBooks();
                    break;

                case 2:
                    System.out.println("Add books");
                    System.out.println("enter the book id");
                    bookId=input.nextInt();
                    System.out.println("enter the book name");
                    bookName=inp.nextLine();
                    System.out.println("enter the book author name");
                    author=inp.nextLine();
                    System.out.println("enter the total copies of the book ");
                    count=input.nextInt();
                    l.addBook(bookId,bookName,author,count);
                    break;
                case 3:
                    System.out.println("enter the member details ");
                    System.out.println("enter the member id");
                    memId=input.nextInt();
                    System.out.println("enter the member name");
                    memName=inp.nextLine();
                    l.addMember(memId,memName);
                    break;
                case 4:
                    System.out.println("enter the book id and member id to borrow book");
                    System.out.println("enter the book id");
                    bookId=input.nextInt();
                    System.out.println("enter the member id");
                    memId=input.nextInt();
                    l.borrowBook(bookId,memId);
                    break;
                case 5:
                    System.out.println("enter the book id ad member id to return the book");
                    System.out.println("enter the book id");
                    bookId=input.nextInt();
                    System.out.println("enter the member id");
                    memId=input.nextInt();
                    l.returnBook(bookId,memId);
                    break;
                case 6:
                    System.out.println("borrowed book are");
                    l.borrowedBooks();
                    break;
                case 7:
                    System.out.println("the most borrowed person are");
                    l.mostBorrowPerson();
                    break;
                case 8:
                    System.out.println("the most borrowed book are");
                    l.mostBorrowBook();
                    break;
                case 9:
                    System.out.println("enter memId to check the books you have");
                    memId=input.nextInt();
                    l.personHavingBooks(memId);
                    break;

                case 10:
                    System.exit(0);
            }

        }
    }
    }
