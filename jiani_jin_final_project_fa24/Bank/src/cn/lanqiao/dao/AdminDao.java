package cn.lanqiao.dao;

import cn.lanqiao.model.Admin;
import cn.lanqiao.model.User;
import cn.lanqiao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AdminDao {
    public Admin login(String username, String password){
        Admin admin=null;
        Connection conn = DBUtil.getConn();
        String sql="select * from admin where username=? and password=?";
        PreparedStatement pstm= null ;
        ResultSet rs=null;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,username);
            pstm.setString(2,password);
            rs=pstm.executeQuery();
            if(rs.next()){ 
                admin=new Admin();


                admin.setBirthday(rs.getDate("birthday"));

                admin.setPassword(rs.getString("password"));
                admin.setReal_name(rs.getString("real_name"));
                admin.setSex(rs.getString("sex"));
                admin.setId(rs.getInt("id"));
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
        return admin;

    }
    public User showinfo(int cardNo){
        User user=null;
        Connection conn = DBUtil.getConn();
        String sql="select * from user where card_no=?";
        PreparedStatement pstm= null ;
        ResultSet rs=null;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,cardNo);

            rs=pstm.executeQuery();
            if(rs.next()){ 
                user=new User();

                user.setBalance(rs.getDouble("balance"));
                user.setBirthday(rs.getString("birthday"));
                user.setCard_no(rs.getInt("Card_no"));
                user.setRealName(rs.getString("real_name"));
                user.setSex(rs.getString("sex"));

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
    public void countinfo(){

    }

    public double getMoney(int type){
        Connection conn = DBUtil.getConn();
        String sql="select sum(money)  from history where type=? and "+
                "DATE_FORMAT(time,'%Y%m') = DATE_FORMAT(now(),'%Y%m')";
        PreparedStatement pstm= null ;
        ResultSet rs=null;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,type);

            rs=pstm.executeQuery();
            if(rs.next()){
                return  rs.getDouble(1);
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
        return 0;
    }

    public Map<String,String> getData(){
        Connection conn = DBUtil.getConn();
        Map<String,String> map = new HashMap<>();
        String sql="select count(*) as totalUser,sum(balance) as sumMoney from `user`";
        PreparedStatement pstm= null ;
        ResultSet rs=null;
        try {
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            if(rs.next()){
                String totalUser = rs.getString("totalUser");
                String sumMoney = rs.getString(2);

                map.put("userCount",totalUser);
                map.put("totalMoney",sumMoney);
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
        return map;
    }
}
