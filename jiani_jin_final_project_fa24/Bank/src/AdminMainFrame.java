import cn.lanqiao.dao.AdminDao;
import cn.lanqiao.model.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class AdminMainFrame extends JFrame {
    public AdminMainFrame() {
        initComponents();
    }

    private void viewinfo(ActionEvent e) {
        // TODO add your code here
        cardtip.setText("");
        try{
            int no=Integer.parseInt(cardTxT.getText());
            User user = adminDao.showinfo(no);
            if(user == null){
                usernameTxT.setText("To be queried");
                sexTxT.setText("To be queried");
                balanceTxT.setText("To be queried");
                birthdayTxT.setText("To be queried");
                System.out.println("Wrong card number");
                cardtip.setText("The card number is incorrect, please re-enter");
            }else{
                System.out.println("The card number is correct and the query has been completed");
                usernameTxT.setText(user.getRealName());
                sexTxT.setText(user.getSex());
                balanceTxT.setText(String.valueOf(user.getBalance()));
                birthdayTxT.setText(user.getBirthday());

            }
        }catch (NumberFormatException e1){
            e1.printStackTrace();
            cardtip.setText("The card number cannot be empty or please enter a valid card number");
        }


    }

    private void showuserinfo(ActionEvent e) {
        // TODO add your code here
        cardLayout.show(mainPanel,"card1");
    }

    private void countinfo(ActionEvent e) {
        double cunkuan= adminDao.getMoney(1);
        double qukuan = adminDao.getMoney(2);
        double zhuanzhang=adminDao.getMoney(3);

        open.setText(adminDao.getData().get("userCount"));
        accountmoney.setText(adminDao.getData().get("totalMoney"));
        monthinput.setText(cunkuan+"");
        monthoutput.setText(qukuan+"");
        inputmoney.setText((cunkuan-qukuan)+"");
        tranmoneyTxT.setText(zhuanzhang+"");

        cardLayout.show(mainPanel,"card2");

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        userinfoBtn = new JButton();
        countBtn = new JButton();
        mainPanel = new JPanel();
        userPanel = new JPanel();
        label2 = new JLabel();
        cardTxT = new JTextField();
        viewinfo = new JButton();
        label3 = new JLabel();
        usernameTxT = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        sexTxT = new JLabel();
        balanceTxT = new JLabel();
        label9 = new JLabel();
        birthdayTxT = new JLabel();
        cardtip = new JLabel();
        countPanel = new JPanel();
        label1 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        open = new JLabel();
        monthinput = new JLabel();
        monthoutput = new JLabel();
        inputmoney = new JLabel();
        label16 = new JLabel();
        accountmoney = new JLabel();
        label17 = new JLabel();
        tranmoneyTxT = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(500, 400));
        var contentPane = getContentPane();

        //---- userinfoBtn ----
        userinfoBtn.setText("\u67e5\u770b\u8d26\u6237\u4fe1\u606f");
        userinfoBtn.addActionListener(e -> showuserinfo(e));

        //---- countBtn ----
        countBtn.setText("\u7edf\u8ba1\u4fe1\u606f");
        countBtn.addActionListener(e -> countinfo(e));

        //======== mainPanel ========
        {
            mainPanel.setLayout(cardLayout);

            //======== userPanel ========
            {

                //---- label2 ----
                label2.setText("\u8bf7\u8f93\u5165\u5361\u53f7");

                //---- viewinfo ----
                viewinfo.setText("\u67e5\u770b");
                viewinfo.addActionListener(e -> viewinfo(e));

                //---- label3 ----
                label3.setText("\u7528\u6237\u540d");

                //---- usernameTxT ----
                usernameTxT.setText("\u8bf7\u67e5\u8be2");

                //---- label5 ----
                label5.setText("\u4f59\u989d");

                //---- label6 ----
                label6.setText("\u6027\u522b");

                //---- sexTxT ----
                sexTxT.setText("\u8bf7\u67e5\u8be2");

                //---- balanceTxT ----
                balanceTxT.setText("\u8bf7\u67e5\u8be2");

                //---- label9 ----
                label9.setText("\u751f\u65e5");

                //---- birthdayTxT ----
                birthdayTxT.setText("\u8bf7\u67e5\u8be2");

                //---- cardtip ----
                cardtip.setForeground(Color.red);

                GroupLayout userPanelLayout = new GroupLayout(userPanel);
                userPanel.setLayout(userPanelLayout);
                userPanelLayout.setHorizontalGroup(
                    userPanelLayout.createParallelGroup()
                        .addGroup(userPanelLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(userPanelLayout.createParallelGroup()
                                .addGroup(userPanelLayout.createSequentialGroup()
                                    .addGroup(userPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(label9, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                        .addComponent(label3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                        .addComponent(label6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                        .addComponent(label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(34, 34, 34)
                                    .addGroup(userPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(usernameTxT, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                        .addComponent(sexTxT, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                        .addComponent(birthdayTxT, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                        .addComponent(balanceTxT, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
                                .addGroup(userPanelLayout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(userPanelLayout.createParallelGroup()
                                        .addComponent(cardtip, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(userPanelLayout.createSequentialGroup()
                                            .addComponent(cardTxT, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(viewinfo)))))
                            .addContainerGap(1, Short.MAX_VALUE))
                );
                userPanelLayout.setVerticalGroup(
                    userPanelLayout.createParallelGroup()
                        .addGroup(userPanelLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(userPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cardTxT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(viewinfo))
                            .addGap(18, 18, 18)
                            .addGroup(userPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(usernameTxT))
                            .addGap(22, 22, 22)
                            .addGroup(userPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(sexTxT)
                                .addComponent(label6))
                            .addGap(18, 18, 18)
                            .addGroup(userPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(balanceTxT))
                            .addGap(28, 28, 28)
                            .addGroup(userPanelLayout.createParallelGroup()
                                .addComponent(label9)
                                .addComponent(birthdayTxT))
                            .addGap(26, 26, 26)
                            .addComponent(cardtip)
                            .addContainerGap(33, Short.MAX_VALUE))
                );
            }
            mainPanel.add(userPanel, "card1");
            {

                //---- label1 ----
                label1.setText("\u5f00\u6237\u4eba\u6570");

                //---- label10 ----
                label10.setText("\u672c\u6708\u5b58\u6b3e\u91d1\u989d");

                //---- label11 ----
                label11.setText("\u672c\u6708\u53d6\u6b3e\u91d1\u989d");

                //---- label12 ----
                label12.setText("\u672c\u6708\u51c0\u5b58\u6b3e");

                //---- open ----
                open.setText("text");

                //---- monthinput ----
                monthinput.setText("text");

                //---- monthoutput ----
                monthoutput.setText("text");

                //---- inputmoney ----
                inputmoney.setText("text");

                //---- label16 ----
                label16.setText("\u5b58\u6b3e\u603b\u91d1\u989d");

                //---- accountmoney ----
                accountmoney.setText("text");

                //---- label17 ----
                label17.setText("\u8f6c\u8d26\u603b\u91d1\u989d");

                //---- tranmoneyTxT ----
                tranmoneyTxT.setText("text");

                GroupLayout countPanelLayout = new GroupLayout(countPanel);
                countPanel.setLayout(countPanelLayout);
                countPanelLayout.setHorizontalGroup(
                    countPanelLayout.createParallelGroup()
                        .addGroup(countPanelLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(countPanelLayout.createParallelGroup()
                                .addGroup(countPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label1)
                                    .addComponent(label11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label12))
                                .addComponent(label17))
                            .addGap(38, 38, 38)
                            .addGroup(countPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(open, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addComponent(monthinput, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addComponent(monthoutput, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addComponent(inputmoney, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addComponent(accountmoney, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addComponent(tranmoneyTxT, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                            .addContainerGap(139, Short.MAX_VALUE))
                );
                countPanelLayout.setVerticalGroup(
                    countPanelLayout.createParallelGroup()
                        .addGroup(countPanelLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(countPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(open))
                            .addGap(18, 18, 18)
                            .addGroup(countPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label10)
                                .addComponent(monthinput))
                            .addGap(18, 18, 18)
                            .addGroup(countPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label11)
                                .addComponent(monthoutput))
                            .addGap(18, 18, 18)
                            .addGroup(countPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label12)
                                .addComponent(inputmoney))
                            .addGap(18, 18, 18)
                            .addGroup(countPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label16)
                                .addComponent(accountmoney))
                            .addGap(18, 18, 18)
                            .addGroup(countPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label17)
                                .addComponent(tranmoneyTxT))
                            .addContainerGap(62, Short.MAX_VALUE))
                );
            }
            mainPanel.add(countPanel, "card2");
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(userinfoBtn)
                            .addGap(60, 60, 60)
                            .addComponent(countBtn))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(24, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(userinfoBtn)
                        .addComponent(countBtn))
                    .addGap(18, 18, 18)
                    .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JButton userinfoBtn;
    private JButton countBtn;
    private JPanel mainPanel;
    private JPanel userPanel;
    private JLabel label2;
    private JTextField cardTxT;
    private JButton viewinfo;
    private JLabel label3;
    private JLabel usernameTxT;
    private JLabel label5;
    private JLabel label6;
    private JLabel sexTxT;
    private JLabel balanceTxT;
    private JLabel label9;
    private JLabel birthdayTxT;
    private JLabel cardtip;
    private JPanel countPanel;
    private JLabel label1;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel open;
    private JLabel monthinput;
    private JLabel monthoutput;
    private JLabel inputmoney;
    private JLabel label16;
    private JLabel accountmoney;
    private JLabel label17;
    private JLabel tranmoneyTxT;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private  CardLayout cardLayout = new CardLayout();
    private  AdminDao adminDao=new AdminDao();
}
