// Write a program in Java to manage a library system with classes representing books and library members.

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        Scanner sc = new Scanner(System.in);
        int ch;

        while(1) {
            System.out.println("\n--- Library Menu ---\n");
            System.out.println("1. Add a new book");
            System.out.println("2. Add a new member");
            System.out.println("3. Display all books");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Display borrowed books for a member");
            System.out.println("7. Exit");
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();

            switch(ch) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = sc.nextInt();
                    Book newBook = new Book(title, author, year);
                    library.addBook(newBook);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter member name: ");
                    String memberName = sc.nextLine();
                    System.out.print("Enter member ID: ");
                    int memberId = sc.nextInt();
                    Member newMember = new Member(memberName, memberId);
                    library.addMember(newMember);
                    break;
                    
                case 3:
                    library.displayBookStatus();
                    break;

                case 4:
                    System.out.print("Enter member ID: ");
                    int borrowMemberId = sc.nextInt();
                    Member borrowMember = findMemberById(borrowMemberId, library);

                    if(borrowMember != null) {
                        sc.nextLine();
                        System.out.print("ENter the title of the book to borrow: ");
                        String borrowTitle = sc.nextLine();
                        Book borrowBook = findBookByTitle(borrowTitle, library);

                        if(borrowBook != null) 
                            library.borrowBook(borrowMember, borrowBook);
                        else
                            System.out.println("Book not found.");
                    } else {
                        System.out.println("Member not found. You must be a registered member to borrow a book.");
                    }
                    break;

                case 5:
                    System.out.print("Enter member ID: ");
                    int returnMemberId = sc.nextInt();
                    Member returnMember = findMemberById(returnMemberId, library);

                    if(returnMember != null) {
                        sc.nextLine();
                        System.out.print("Enter the title of the book to return: ");
                        String returnTitle = sc.nextLine();
                        Book returnBook = findBookByTitle(returnTitle, library);

                        if(returnBook != null)
                            library.returnBook(returnMember, returnBook);
                        else
                            System.out.println("Book not found.");
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter member ID: ");
                    int displayMemberId = sc.nextInt();
                    Member displayMember = findMemberById(displayMemberId, library);

                    if(displayMember != null)
                        displayMember.displayBorrowedBooks();
                    else
                        System.out.println("Member not found.");
                    break;

                case 7:
                    System.out.println("Exiting the library system...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } sc.close();
    } 

    public static Member findMemberById(int id, Library library) {
        for(Member member : library.getMembers()) 
            if(member.getId() == id)
                return member;
        return null;
    }

    public static Book findBookByTitle(String title, Library library) {
        for(Book book : library.getBooks()) 
            if(book.getTitle().equalsIgnoreCase(titel))
                return book;
        return null;
    }
}
