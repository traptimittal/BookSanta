package com.booksanta.DataStore;

import com.booksanta.DAO.BookDAO;
import com.booksanta.Models.Book;

/**
 * Created by Trapti on 2/7/2015.
 */
public class BookDataStore {
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String MYSQL_URL = "jdbc:mysql://localhost/booksanta?"
            + "user=trapti&password=trapti";

    public static Book getBook(int id){
        BookDAO dao = new BookDAO(MYSQL_DRIVER,MYSQL_URL);
        Book b = new Book();
        try {
            b = dao.readData(id);
        } catch (Exception e){

        }
        return b;
    }
}
