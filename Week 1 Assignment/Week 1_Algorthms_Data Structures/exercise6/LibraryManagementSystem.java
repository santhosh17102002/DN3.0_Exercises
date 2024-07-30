package exercise6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private List<Book> books;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
    }

    public void addBook(int bookId, String title, String author) {
        books.add(new Book(bookId, title, author));
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int compareResult = midBook.getTitle().compareToIgnoreCase(title);
            if (compareResult == 0) {
                return midBook;
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem();

        System.out.println("Library Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Search Book by Title (Linear Search)");
        System.out.println("3. Search Book by Title (Binary Search)");
        System.out.println("4. Exit");
        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    library.addBook(bookId, title, author);
                    break;

                case 2:
                    System.out.print("Enter Book Title to search (Linear Search): ");
                    String linearSearchTitle = scanner.nextLine();
                    Book foundBookLinear = library.linearSearchByTitle(linearSearchTitle);
                    if (foundBookLinear != null) {
                        System.out.println("Book found: " + foundBookLinear);
                    } else {
                        System.out.println("Book not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book Title to search (Binary Search): ");
                    String binarySearchTitle = scanner.nextLine();
                    Book foundBookBinary = library.binarySearchByTitle(binarySearchTitle);
                    if (foundBookBinary != null) {
                        System.out.println("Book found: " + foundBookBinary);
                    } else {
                        System.out.println("Book not found");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
