package cn.lanqiao.dao;

import cn.lanqiao.model.User;
import cn.lanqiao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User login(String careNo,String password){
        User user=null;
        Connection conn = DBUtil.getConn();
        String sql="select * from user where card_no=? and password=?";
        PreparedStatement pstm= null ;
        ResultSet rs=null;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,careNo);
            pstm.setString(2,password);
            rs=pstm.executeQuery();
            if(rs.next()){ 
                user=new User();

                user.setBalance(rs.getDouble("balance"));
                user.setBirthday(rs.getString("birthday"));
                user.setCard_no(rs.getInt("Card_no"));
                user.setPassword(rs.getString("password"));
                user.setRealName(rs.getString("real_name"));
                user.setSex(rs.getString("sex"));
                user.setId(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                DBUtil.close2(rs,pstm,conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;

    }

    public void register(User user){
        Connection conn = DBUtil.getConn();
        String sql="insert into user values(null,?,?,?,?,?,now(),?,null)";
        PreparedStatement pstm = null;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,user.getCard_no());
            pstm.setString(2,user.getPassword());
            pstm.setString(3,user.getRealName());
            pstm.setString(4,user.getSex());
            pstm.setDouble(5,user.getBalance());
            pstm.setString(6,user.getBirthday());
            int rs= pstm.executeUpdate();
            if(rs>0){
                System.out.println("Successful registration");
            }else{
                System.out.println("Registration failed");
            }
        } catch (SQLException ex) {
            System.out.println("Registration failed, please see related issues");
            ex.printStackTrace();
        }finally {
            try {
                DBUtil.close2(null,pstm,conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int update(String realname,String newPassword,int userID){
        Connection conn = DBUtil.getConn();
        String sql="update user set real_name=?,password = ? where id=?";
        PreparedStatement pstm = null;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,realname);
            pstm.setString(2,newPassword);
            pstm.setInt(3,userID);

            int r= pstm.executeUpdate();
            return r;
        } catch (SQLException ex) {
            System.out.println("Registration failed, please see related issues");
            ex.printStackTrace();
        }finally {
            try {
                DBUtil.close2(null,pstm,conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int cunKuan(double money,int userID){
        Connection conn = DBUtil.getConn();
        String sql="update user set balance = balance + ? where id=?";
        PreparedStatement pstm = null;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setDouble(1,money);
            pstm.setInt(2,userID);

            int r= pstm.executeUpdate();
            return r;
        } catch (SQLException ex) {
            System.out.println("Deposit failed, please see related issues");
            ex.printStackTrace();
        }finally {
            try {
                DBUtil.close2(null,pstm,conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int quKuan(double money,int userID){
        Connection conn = DBUtil.getConn();
        String sql="update user set balance = balance-? where id=?";
        PreparedStatement pstm = null;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setDouble(1,money);
            pstm.setInt(2,userID);

            int r= pstm.executeUpdate();
            return r;
        } catch (SQLException ex) {
            System.out.println("Withdrawal failed, please see related issues");
            ex.printStackTrace();
        }finally {
            try {
                DBUtil.close2(null,pstm,conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /*
     * money transfer amount
     * cardNo the other party's card number
     * fromUserID the transferor's ID
     * */
    public boolean transterMoney(double money,int cardNo,int fromUserID){
        Connection conn = DBUtil.getConn();
        String sql="update user set balance = balance-? where id=?";
        String sql2="update user set balance = balance+? where card_no=?";
        PreparedStatement pstm = null;
        PreparedStatement pstm2 = null;
        try {
            conn.setAutoCommit(false);
            pstm=conn.prepareStatement(sql);
            pstm.setDouble(1,money);
            pstm.setInt(2,fromUserID);

            int r= pstm.executeUpdate();

            pstm2 = conn.prepareStatement(sql2);
            pstm2.setDouble(1,money);
            pstm2.setInt(2,cardNo);
            int r2= pstm2.executeUpdate();
            if(r>0 && r2>0){
                conn.commit(); 
                System.out.println("Transfer successful");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Transfer failed, please see related issues");
            ex.printStackTrace();
        }finally {
            try {
                DBUtil.close2(null,pstm,conn);
                DBUtil.close2(null,pstm2,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
