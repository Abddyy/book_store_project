package com.mycompany.bookstoreproject;

import java.util.Scanner;

public class BookStoreProject {

    public static void main(String[] args) {
        BookStore bs = new BookStore();
        ISBNValidator iv = new ISBNValidator();
        TextValidator tv = new TextValidator();

        Scanner in = new Scanner(System.in);
        System.out.print("1-Add a book.\n2-Delete a book by it's ISBN.\n"
                + "3-Search for a book by it's ISBN.\n4-Display all books in Database.\nYour choice : ");
        int choice;

        do {
            choice = in.nextInt();
            if (!(choice >= 1 && choice <= 4)) {
                System.out.print("\nEnter choice between 1 and 4 reEnter : ");
            }
        } while (!(choice >= 1 && choice <= 4));

        if (choice == 1) {
            System.out.print("Enter the ISBN of the book : ");
            String isbn = in.next();

            if (!iv.validate(isbn)) {
                System.out.println("Bad Input.");
                return;
            }

            System.out.print("Enter the title of the book : ");
            String title = in.next();
            if (!tv.validate(title)) {
                System.out.println("Bad Input.");
                return;
            }

            System.out.print("Enter the author's name  : ");
            String author = in.next();
            if (!tv.validate(author)) {
                System.out.println("Bad Input.");
                return;
            }

            System.out.print("Enter the books's price : ");
            double price = in.nextDouble();
           
            if (price < 0) {
                System.out.println("Bad Input.");
                return;
            }

            Book b = new Book(isbn, title, author, price);
            bs.addBook(b);

        } else if (choice == 2) {

            System.out.print("Enter the ISBN of the book : ");
            String isbn = in.next();

            Book b = new Book();
            b.setIsbn(isbn);

            if (bs.deleteByISBN(isbn)) {
                System.out.print("Book with ISBN " + isbn + " deleted successfully");
            } else {
                System.out.print("Book with ISBN " + isbn + " it dosen't even exist");
            }

        } else if (choice == 3) {
            System.out.print("Enter the ISBN of the book : ");
            String isbn = in.next();

            Book b = new Book();
            b.setIsbn(isbn);

            if (bs.searchByISBN(isbn) != null) {
                System.out.print(bs.searchByISBN(isbn));
            } else {
                System.out.print("Book with ISBN : " + isbn + " it dosen't exist");
            }

        } else if (choice == 4) {
            bs.displayBooks();
        }

    }
}
