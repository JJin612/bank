import cn.lanqiao.dao.HistoryDao;
import cn.lanqiao.dao.UserDao;
import cn.lanqiao.model.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class MainFrame extends JFrame {

    public MainFrame() {

        initComponents();
    }
    public MainFrame(User user){

        this.user=user;
        initComponents();
        realnameTxT.setText(user.getRealName());
        pwdTxT.setText(user.getPassword());
        sexTxT.setText(user.getSex());
        loginnameTxt.setText(String.valueOf(user.getCard_no()));
        moneyTxt.setText(String.valueOf(user.getBalance()));
        birthdayTxt.setText(user.getBirthday());
        updateBtn.setVisible(false);
    }

    private void showmoney(ActionEvent e) {
        takemoneyTxT.setText("");
        tip.setText("");
        money.setText(String.valueOf(user.getBalance()));
        button7.setVisible(false);
        surecunkuan.setVisible(true);
        cardLayout.show(mainpanel,"cunkuanPanle");
        moneylab.setText("Please enter the deposit amount");

    }

    private void showzhuanzhang(ActionEvent e) {
        yourcard.setText("");
        zhuanmoney.setText("");
        okmoney.setText(String.valueOf(user.getBalance()));
        cardLayout.show(mainpanel,"zhuanzhangPanel");
    }

    private void showInfo(ActionEvent e) {
        cardLayout.show(mainpanel,"infoPanel");
        updateBtn.setVisible(false);
        realnameTxT.setEditable(false);
        pwdTxT.setEditable(false);
    }

    private void returnlogin(ActionEvent e) {
        this.setVisible(false);
        new LoginFrame().setVisible(true);
    }

    private void showUpdate(ActionEvent e) {
        realnameTxT.setEditable(true);
        pwdTxT.setEditable(true);
        updateBtn.setVisible(true);
        cardLayout.show(mainpanel,"infoPanel");
    }

    private void sureupdate(ActionEvent e) {
        System.out.println("Modification successful");
        userDao.update(realnameTxT.getText(),pwdTxT.getText(),user.getId());
        historyDao.updateinfo(user.getId());

    }

    private void showqukuan(ActionEvent e) {
        takemoneyTxT.setText("");
        tip.setText("");
        surecunkuan.setVisible(false);
        button7.setVisible(true);
        cardLayout.show(mainpanel,"cunkuanPanle");
        money.setText(String.valueOf(user.getBalance()));
        moneylab.setText("Please confirm the withdrawal amount");
    }

    private void updatemoney(ActionEvent e) {
        try{
            Double m=Double.parseDouble(takemoneyTxT.getText());

            if(m<=0){
                tip.setText("The withdrawal amount cannot be negative or zero");
                System.out.println("Withdrawal failed");
            }
            else{
                if(m<user.getBalance() && m>0){
                    userDao.quKuan(m,user.getId());
                    historyDao.takemoney(user.getId(),m);
                    System.out.println("Withdrawal successful");
                    tip.setText("Withdrawal successful");
                    user.setBalance(user.getBalance()-m);
                    money.setText(user.getBalance()+"");
                    moneyTxt.setText(String.valueOf(user.getBalance()));
                }else{
                    tip.setText("Insufficient user balance");
                }
            }
        }catch (NumberFormatException eb){
            eb.printStackTrace();
            tip.setText("Please enter the correct withdrawal amount");
        }

    }

    private void trantermoney(ActionEvent e) {
        double m=Double.parseDouble(zhuanmoney.getText());
        int carNo =Integer.parseInt(yourcard.getText());
        int fromUserID = user.getId();  

        if(m<=0){
            zztip.setText("The transfer amount cannot be negative or 0");
        }
        else{
            boolean f=userDao.transterMoney(m,carNo,fromUserID);
            historyDao.giro(fromUserID,carNo,m);
            if(f){
                zztip.setText("Transfer successful");
                okmoney.setText(String.valueOf(user.getBalance()-m));
                user.setBalance(user.getBalance()-m);
                moneyTxt.setText(String.valueOf(user.getBalance()));
            }else {
                zztip.setText("Transfer fail");
            }
        }

    }

    private void sureCunkuan(ActionEvent e) {
        double n=Double.parseDouble(takemoneyTxT.getText());
        if(n<=0){
            tip.setText("The deposit amount cannot be negative or 0");
        }
        else{
            if(n>0){
                userDao.cunKuan(n,user.getId());
                historyDao.savemoney(user.getId(),n);
                System.out.println("Deposit successful");
                tip.setText("Deposit successful");
                user.setBalance(user.getBalance()+n);
                money.setText(user.getBalance()+"");
                moneyTxt.setText(String.valueOf(user.getBalance()));
            }else{
                tip.setText("Deposit fail");
            }
        }
    }


    private void initComponents() {
        button1 = new JButton();
        showUpdateBtn = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        mainpanel = new JPanel();
        infoPanel = new JPanel();
        label1 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        realnameTxT = new JTextField();
        pwdTxT = new JTextField();
        sexTxT = new JTextField();
        moneyTxt = new JTextField();
        loginnameTxt = new JTextField();
        birthdayTxt = new JTextField();
        updateBtn = new JButton();
        cunkuanPanle = new JPanel();
        moneylab = new JLabel();
        takemoneyTxT = new JTextField();
        button7 = new JButton();
        label2 = new JLabel();
        money = new JLabel();
        tip = new JLabel();
        surecunkuan = new JButton();
        zhuanzhangPanel = new JPanel();
        totalmoney = new JLabel();
        okmoney = new JLabel();
        label10 = new JLabel();
        yourcard = new JTextField();
        label11 = new JLabel();
        zhuanmoney = new JTextField();
        button8 = new JButton();
        zztip = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(500, 380));
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("\u67e5\u770b\u8d26\u6237");
        button1.addActionListener(e -> showInfo(e));

        //---- showUpdateBtn ----
        showUpdateBtn.setText("\u4fee\u6539\u4e2a\u4eba\u4fe1\u606f");
        showUpdateBtn.addActionListener(e -> showUpdate(e));

        //---- button3 ----
        button3.setText("\u5b58\u6b3e");
        button3.addActionListener(e -> showmoney(e));

        //---- button4 ----
        button4.setText("\u53d6\u6b3e");
        button4.addActionListener(e -> showqukuan(e));

        //---- button5 ----
        button5.setText("\u8f6c\u8d26");
        button5.addActionListener(e -> showzhuanzhang(e));

        //---- button6 ----
        button6.setText("\u91cd\u65b0\u767b\u5f55");
        button6.addActionListener(e -> returnlogin(e));

        //======== mainpanel ========
        {
            mainpanel.setLayout(cardLayout);

            //======== infoPanel ========
            {

                //---- label1 ----
                label1.setText("\u4fe1\u606f\u754c\u9762");

                //---- label4 ----
                label4.setText("\u771f\u5b9e\u59d3\u540d");

                //---- label5 ----
                label5.setText("\u5bc6\u7801");

                //---- label6 ----
                label6.setText("\u6027\u522b");

                //---- label7 ----
                label7.setText("\u767b\u5f55\u540d");

                //---- label8 ----
                label8.setText("\u4f59\u989d");

                //---- label9 ----
                label9.setText("\u751f\u65e5");

                //---- realnameTxT ----
                realnameTxT.setEditable(false);

                //---- pwdTxT ----
                pwdTxT.setEditable(false);

                //---- sexTxT ----
                sexTxT.setEditable(false);

                //---- moneyTxt ----
                moneyTxt.setEditable(false);

                //---- loginnameTxt ----
                loginnameTxt.setEditable(false);

                //---- birthdayTxt ----
                birthdayTxt.setEditable(false);

                //---- updateBtn ----
                updateBtn.setText("\u786e\u5b9a\u4fee\u6539");
                updateBtn.addActionListener(e -> sureupdate(e));

                GroupLayout infoPanelLayout = new GroupLayout(infoPanel);
                infoPanel.setLayout(infoPanelLayout);
                infoPanelLayout.setHorizontalGroup(
                    infoPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addGap(140, 140, 140))
                        .addGroup(infoPanelLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(infoPanelLayout.createParallelGroup()
                                .addComponent(label4)
                                .addComponent(label5)
                                .addComponent(label6))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(realnameTxT, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(pwdTxT, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(sexTxT, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(infoPanelLayout.createParallelGroup()
                                .addGroup(infoPanelLayout.createSequentialGroup()
                                    .addComponent(label9)
                                    .addGap(18, 18, 18)
                                    .addComponent(birthdayTxt, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                                .addGroup(infoPanelLayout.createSequentialGroup()
                                    .addGroup(infoPanelLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                                            .addComponent(label7)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                            .addComponent(label8)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(loginnameTxt, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                        .addComponent(moneyTxt, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))))
                            .addGap(15, 15, 15))
                        .addGroup(infoPanelLayout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(updateBtn)
                            .addContainerGap(120, Short.MAX_VALUE))
                );
                infoPanelLayout.setVerticalGroup(
                    infoPanelLayout.createParallelGroup()
                        .addGroup(infoPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(label7)
                                .addComponent(realnameTxT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(loginnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(label8)
                                .addComponent(moneyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pwdTxT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(label9)
                                .addComponent(birthdayTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sexTxT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(updateBtn)
                            .addContainerGap(38, Short.MAX_VALUE))
                );
            }
            mainpanel.add(infoPanel, "infoPanel");

            //======== cunkuanPanle ========
            {

                //---- moneylab ----
                moneylab.setText("\u8bf7\u8f93\u5165\u53d6\u6b3e\u91d1\u989d");

                //---- button7 ----
                button7.setText("\u786e\u5b9a\u53d6\u6b3e");
                button7.addActionListener(e -> updatemoney(e));

                //---- label2 ----
                label2.setText("\u53ef\u7528\u4f59\u989d");

                //---- money ----
                money.setMinimumSize(new Dimension(20, 12));

                //---- tip ----
                tip.setForeground(Color.red);

                //---- surecunkuan ----
                surecunkuan.setText("\u786e\u5b9a\u5b58\u6b3e");
                surecunkuan.addActionListener(e -> sureCunkuan(e));

                GroupLayout cunkuanPanleLayout = new GroupLayout(cunkuanPanle);
                cunkuanPanle.setLayout(cunkuanPanleLayout);
                cunkuanPanleLayout.setHorizontalGroup(
                    cunkuanPanleLayout.createParallelGroup()
                        .addGroup(cunkuanPanleLayout.createSequentialGroup()
                            .addGroup(cunkuanPanleLayout.createParallelGroup()
                                .addGroup(cunkuanPanleLayout.createSequentialGroup()
                                    .addGroup(cunkuanPanleLayout.createParallelGroup()
                                        .addGroup(cunkuanPanleLayout.createSequentialGroup()
                                            .addGap(17, 17, 17)
                                            .addComponent(moneylab))
                                        .addGroup(cunkuanPanleLayout.createSequentialGroup()
                                            .addGap(31, 31, 31)
                                            .addComponent(label2)))
                                    .addGap(29, 29, 29)
                                    .addGroup(cunkuanPanleLayout.createParallelGroup()
                                        .addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(takemoneyTxT, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(cunkuanPanleLayout.createSequentialGroup()
                                    .addGap(204, 204, 204)
                                    .addComponent(tip, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                .addGroup(cunkuanPanleLayout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(surecunkuan)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button7)))
                            .addContainerGap(24, Short.MAX_VALUE))
                );
                cunkuanPanleLayout.setVerticalGroup(
                    cunkuanPanleLayout.createParallelGroup()
                        .addGroup(cunkuanPanleLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(cunkuanPanleLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(cunkuanPanleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(moneylab)
                                .addComponent(takemoneyTxT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(39, 39, 39)
                            .addGroup(cunkuanPanleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(surecunkuan)
                                .addComponent(button7))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tip)
                            .addContainerGap(81, Short.MAX_VALUE))
                );
            }
            mainpanel.add(cunkuanPanle, "cunkuanPanle");

            //======== zhuanzhangPanel ========
            {

                //---- totalmoney ----
                totalmoney.setText("\u53ef\u8f6c\u91d1\u989d");

                //---- okmoney ----
                okmoney.setText("lab");

                //---- label10 ----
                label10.setText("\u5bf9\u65b9\u5361\u53f7");

                //---- label11 ----
                label11.setText("\u8f6c\u8d26\u91d1\u989d");

                //---- button8 ----
                button8.setText("\u786e\u5b9a\u8f6c\u8d26");
                button8.addActionListener(e -> trantermoney(e));

                //---- zztip ----
                zztip.setForeground(Color.red);

                GroupLayout zhuanzhangPanelLayout = new GroupLayout(zhuanzhangPanel);
                zhuanzhangPanel.setLayout(zhuanzhangPanelLayout);
                zhuanzhangPanelLayout.setHorizontalGroup(
                    zhuanzhangPanelLayout.createParallelGroup()
                        .addGroup(zhuanzhangPanelLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(zhuanzhangPanelLayout.createParallelGroup()
                                .addComponent(totalmoney)
                                .addComponent(label10)
                                .addComponent(label11))
                            .addGap(34, 34, 34)
                            .addGroup(zhuanzhangPanelLayout.createParallelGroup()
                                .addComponent(okmoney, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(yourcard)
                                .addComponent(zhuanmoney, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                            .addGap(124, 124, 124))
                        .addGroup(zhuanzhangPanelLayout.createSequentialGroup()
                            .addGap(135, 135, 135)
                            .addGroup(zhuanzhangPanelLayout.createParallelGroup()
                                .addComponent(zztip)
                                .addComponent(button8))
                            .addContainerGap(134, Short.MAX_VALUE))
                );
                zhuanzhangPanelLayout.setVerticalGroup(
                    zhuanzhangPanelLayout.createParallelGroup()
                        .addGroup(zhuanzhangPanelLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(zhuanzhangPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(totalmoney)
                                .addComponent(okmoney))
                            .addGap(18, 18, 18)
                            .addGroup(zhuanzhangPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(yourcard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label10))
                            .addGap(18, 18, 18)
                            .addGroup(zhuanzhangPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label11)
                                .addComponent(zhuanmoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(button8)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(zztip)
                            .addContainerGap(15, Short.MAX_VALUE))
                );
            }
            mainpanel.add(zhuanzhangPanel, "zhuanzhangPanel");
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(mainpanel, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(46, 46, 46)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(button5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(showUpdateBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(30, 30, 30)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button3)
                                .addComponent(button6, GroupLayout.Alignment.TRAILING))))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button3)
                        .addComponent(showUpdateBtn)
                        .addComponent(button1))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button6)
                        .addComponent(button5)
                        .addComponent(button4))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(mainpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JButton button1;
    private JButton showUpdateBtn;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel mainpanel;
    private JPanel infoPanel;
    private JLabel label1;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField realnameTxT;
    private JTextField pwdTxT;
    private JTextField sexTxT;
    private JTextField moneyTxt;
    private JTextField loginnameTxt;
    private JTextField birthdayTxt;
    private JButton updateBtn;
    private JPanel cunkuanPanle;
    private JLabel moneylab;
    private JTextField takemoneyTxT;
    private JButton button7;
    private JLabel label2;
    private JLabel money;
    private JLabel tip;
    private JButton surecunkuan;
    private JPanel zhuanzhangPanel;
    private JLabel totalmoney;
    private JLabel okmoney;
    private JLabel label10;
    private JTextField yourcard;
    private JLabel label11;
    private JTextField zhuanmoney;
    private JButton button8;
    private JLabel zztip;
 
    private CardLayout cardLayout = new CardLayout();
    private static User user;
    UserDao userDao=new UserDao();
    HistoryDao historyDao=new HistoryDao();
    public static void main(String[] args) {
        new MainFrame(user).setVisible(true);
    }
}
