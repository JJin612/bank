package cn.lanqiao.util;

import java.sql.*;

public class DBUtil {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/Bank";

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            System.out.println("The database is trying to connect");
        }
    }
    public static Connection getConn(){
        Connection conn = null;
        try{
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Database connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed");
        }
        return conn;
    }
    public static void close(ResultSet rs, Statement stm, Connection con)throws SQLException{
        if(rs !=null) rs.close();
        if(stm!=null) stm.close();
        if(con != null) con.close();
        System.out.println("The database connection is released successfully");
    }

    public static void close2(ResultSet rs, PreparedStatement pstm, Connection con)throws SQLException{
        if(rs !=null) rs.close();
        if(pstm!=null) pstm.close();
        if(con != null) con.close();
        System.out.println("The database connection is released successfully");
    }
}
