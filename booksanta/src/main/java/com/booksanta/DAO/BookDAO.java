package com.booksanta.DAO;

import com.booksanta.Models.Book;

import java.sql.*;

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

    public Book readData(int bookId) throws Exception {
        try {
            Class.forName(jdbcDriverStr);
            connection = DriverManager.getConnection(jdbcURL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from books;");
            return getResultSet(resultSet, bookId);
            /*preparedStatement = connection.prepareStatement("insert into books values (3,1,'The BookSanta Story')");
            preparedStatement.setString(1,"insert test from java");
            preparedStatement.executeUpdate();*/
        }finally{
            close();
        }
    }

    private Book getResultSet(ResultSet resultSet, int bookId) throws Exception {
        while(resultSet.next()){
            Integer id = resultSet.getInt(BookColumns.Id.toString());
            if (id == bookId)
                break;
        }
        String title = resultSet.getString(BookColumns.Title.toString());
        return new Book(bookId,title);
    }

    private void close(){
        try {
            if(resultSet!=null) resultSet.close();
            if(statement!=null) statement.close();
            if(connection!=null) connection.close();
        } catch(Exception e){}
    }
}
