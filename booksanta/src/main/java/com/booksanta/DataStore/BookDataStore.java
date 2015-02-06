package com.booksanta.DataStore;

import com.booksanta.DAO.BookDAO;
import com.booksanta.Models.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trapti on 2/7/2015.
 */
public class BookDataStore {
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String MYSQL_URL = "jdbc:mysql://localhost/booksanta?"
            + "user=trapti&password=trapti";

    public static List<Book> getBooks(){
        BookDAO dao = new BookDAO(MYSQL_DRIVER,MYSQL_URL);
        List<Book> books = new ArrayList<Book>();
        try {
            books = dao.getBooks();
        } catch (Exception e){

        }
        return books;
    }

    public static Book getBook(int id){
        BookDAO dao = new BookDAO(MYSQL_DRIVER,MYSQL_URL);
        Book book = new Book();
        try {
            book = dao.getBook(id);
        } catch (Exception e){

        }
        return book;
    }
}
