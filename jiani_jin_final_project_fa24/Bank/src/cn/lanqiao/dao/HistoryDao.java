package cn.lanqiao.dao;

import cn.lanqiao.model.History;
import cn.lanqiao.model.User;
import cn.lanqiao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryDao {
    /*
    * * 0 Modify personal information
    * 1 Deposit
    * 2 Withdraw
    * 3 Transfer
    * 4 Log in
    * */
    public void updateinfo(int userID){
        History history=new History();
        Connection conn = DBUtil.getConn();
        String sql = "insert into history values(null,?,0,null,now(),null)";
        PreparedStatement pstm= null ;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,userID);
            int rs=pstm.executeUpdate();
            if(rs>0){
                System.out.println("The details table was updated successfully");
            }else{
                System.out.println("Details table update failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void giro(int userID,int cardNo,double money){
        Connection conn = DBUtil.getConn();
        String sql = "insert into history values(null,?,3,?,now(),?)";
        PreparedStatement pstm= null ;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,userID);
            pstm.setInt(2,cardNo);
            pstm.setDouble(3,money);
            int rs=pstm.executeUpdate();
            if(rs>0){
                System.out.println("The details table was updated successfully");
            }else{
                System.out.println("Details table update failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void savemoney(int userID,double money){
        Connection conn = DBUtil.getConn();
        String sql = "insert into history values(null,?,1,null,now(),?)";
        PreparedStatement pstm= null ;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,userID);
            pstm.setDouble(2,money);
            int rs=pstm.executeUpdate();
            if(rs>0){
                System.out.println("The details table was updated successfully");
            }else{
                System.out.println("Details table update failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void takemoney(int userID,double money){
        Connection conn = DBUtil.getConn();
        String sql = "insert into history values(null,?,2,null,now(),?)";
        PreparedStatement pstm= null ;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,userID);

            pstm.setDouble(2,money);
            int rs=pstm.executeUpdate();
            if(rs>0){
                System.out.println("The details table was updated successfully");
            }else{
                System.out.println("Details table update failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
