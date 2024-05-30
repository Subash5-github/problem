import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    public Book(int id, String title, String author, int totalCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void borrowCopy() {
        if (availableCopies > 0) {
            availableCopies--;
        } else {
            System.out.println("No available copies of this book.");
        }
    }

    public void returnCopy() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Available Copies: " + availableCopies + "/" + totalCopies;
    }
}

class Member {
    private int id;
    private String name;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member ID: " + id + ", Name: " + name;
    }
}

class Transaction {
    private Member member;
    private Book book;
    private Date borrowDate;
    private Date returnDate;

    public Transaction(Member member, Book book, Date borrowDate) {
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void returnBook(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Transaction [Member=" + member + ", Book=" + book + ", Borrow Date=" + borrowDate + ", Return Date=" + returnDate + "]";
    }
}

public class LibraryManagementSystem {
    private HashMap<Integer, Book> books;
    private HashMap<Integer, Member> members;
    private ArrayList<Transaction> transactions;

    public LibraryManagementSystem() {
        books = new HashMap<>();
        members = new HashMap<>();
        transactions = new ArrayList<>();
    }

    public void addBook(int id, String title, String author, int totalCopies) {
        books.put(id, new Book(id, title, author, totalCopies));
    }

    public void addMember(int id, String name) {
        members.put(id, new Member(id, name));
    }

    public void borrowBook(int memberId, int bookId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book != null && member != null && book.getAvailableCopies() > 0) {
            book.borrowCopy();
            transactions.add(new Transaction(member, book, new Date()));
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available or invalid member/book ID.");
        }
    }

    public void returnBook(int memberId, int bookId) {
        for (Transaction transaction : transactions) {
            if (transaction.getMember().getId() == memberId && transaction.getBook().getId() == bookId && transaction.getReturnDate() == null) {
                transaction.returnBook(new Date());
                transaction.getBook().returnCopy();
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("No such transaction found.");
    }

    public void listAvailableBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void listBorrowedBooks() {
        for (Transaction transaction : transactions) {
            if (transaction.getReturnDate() == null) {
                System.out.println("Borrowed Book: " + transaction.getBook() + ", Borrowed by: " + transaction.getMember());
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBook(1, "The Great Gatsby", "F. Scott Fitzgerald", 3);
        library.addBook(2, "1984", "George Orwell", 2);
        library.addBook(3, "To Kill a Mockingbird", "Harper Lee", 1);

        library.addMember(1, "Alice");
        library.addMember(2, "Bob");
        library.addMember(3, "Charlie");

        library.borrowBook(1, 1);
        library.borrowBook(2, 2);
        library.borrowBook(1, 3);
        library.returnBook(1, 1);

        System.out.println("\nList of available books:");
        library.listAvailableBooks();

        System.out.println("\nList of borrowed books:");
        library.listBorrowedBooks();
    }
}

