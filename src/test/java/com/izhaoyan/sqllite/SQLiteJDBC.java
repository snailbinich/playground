package com.izhaoyan.sqllite;

import org.junit.Test;

import java.sql.*;
import java.util.Random;

/**
 * Created by Rockyan on 2016/5/8.
 */
public class SQLiteJDBC {

    public  Connection getConnection(){
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return conn;
    }

    @Test
    public void testConnection(){
        {
            Connection c = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Opened database successfully");
        }
    }


    @Test
    public void testCreateTable(){

        Connection conn = getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String sql = "CREATE TABLE USER (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME CHAR(50) NOT NULL," +
                    "AGE INT NOT NULL," +
                    "ADDRESS CHAR (50)" +
                    ")";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void  testInsert(){
        Connection conn = getConnection();
        Statement statement = null;
        Random random = new Random();
        try {
            statement = conn.createStatement();
            conn.setAutoCommit(false);

            String sql = "INSERT INTO USER ( NAME, AGE, ADDRESS) " +
                         "values ( 'ZHAOYAN"+ random.nextInt(1000)+"',30,'BEIJING');";
            statement.executeUpdate(sql);
            statement.close();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testSelect(){
        Connection conn = getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            conn.setAutoCommit(false);

            String sql = "SELECT * FROM USER ;";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");

                System.out.print("id = "+ id);
                System.out.print("age = "+ age);
                System.out.print("name = "+ name);
                System.out.print("address = "+ address);
                System.out.println();
            }
            statement.executeUpdate(sql);
            statement.close();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
