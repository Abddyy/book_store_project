package com.mycompany.bookstoreproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookStore {

    private ArrayList<Book> books;

    public BookStore() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO \"BookStoreSchema\".\"Book\" (isbn, title, author, price)\n VALUES (?,?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setDouble(4, book.getPrice());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Book searchByISBN(String isbn) {
        String sql = "SELECT * FROM \"BookStoreSchema\".\"Book\" WHERE isbn = ?";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void displayBooks() {
        String sql = "SELECT * FROM \"BookStoreSchema\".\"Book\"";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"))+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteByISBN(String isbn) {
        String sql = "DELETE FROM \"BookStoreSchema\".\"Book\" WHERE isbn = ?";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, isbn);
            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
