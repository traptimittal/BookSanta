package com.booksanta.DAO;

import com.booksanta.Models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trapti on 2/7/2015.
 */
public class BookDAO {
    private final String jdbcDriverStr;
    private final String jdbcURL;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    enum BookColumns{
        Id,Title;
    }

    public BookDAO(String jdbcDriverStr, String jdbcURL){
        this.jdbcDriverStr = jdbcDriverStr;
        this.jdbcURL = jdbcURL;
    }

    public List<Book> getBooks() throws Exception {
        try {
            List<Book> books = new ArrayList<Book>();
            Class.forName(jdbcDriverStr);
            connection = DriverManager.getConnection(jdbcURL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from books;");
            while(resultSet.next()){
                Integer id = resultSet.getInt(BookColumns.Id.toString());
                String title = resultSet.getString(BookColumns.Title.toString());
                books.add(new Book(id, title));
            }
            return books;
            /*preparedStatement = connection.prepareStatement("insert into books values (3,1,'The BookSanta Story')");
            preparedStatement.setString(1,"insert test from java");
            preparedStatement.executeUpdate();*/
        }finally{
            close();
        }
    }

    public Book getBook(int bookId) throws Exception {
        try {
            Book book = new Book();
            Class.forName(jdbcDriverStr);
            connection = DriverManager.getConnection(jdbcURL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from books where id=" + bookId + ";");
            resultSet.next();
            Integer id = resultSet.getInt(BookColumns.Id.toString());
            String title = resultSet.getString(BookColumns.Title.toString());
            book = new Book(id, title);
            return book;
            /*preparedStatement = connection.prepareStatement("insert into books values (3,1,'The BookSanta Story')");
            preparedStatement.setString(1,"insert test from java");
            preparedStatement.executeUpdate();*/
        }finally{
            close();
        }
    }

    private void close(){
        try {
            if(resultSet!=null) resultSet.close();
            if(statement!=null) statement.close();
            if(connection!=null) connection.close();
        } catch(Exception e){}
    }
}
