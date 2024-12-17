import cn.lanqiao.dao.UserDao;
import cn.lanqiao.model.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

public class RegisterFrame extends JFrame {
    UserDao userDao = new UserDao();
    public RegisterFrame() {
        initComponents();
    }

    private void ok(ActionEvent e) {
        User user=new User();
        int careNo=Integer.parseInt(usernameText.getText());
        user.setCard_no(careNo);
        user.setPassword(pwdText.getText());
        user.setSex(sexText.getText());
        user.setBirthday(birthdayText.getText());
        double b=Double.parseDouble(balanceText.getText());
        user.setBalance(b);
        user.setRealName(nameText.getText());

        userDao.register(user);
        this.setVisible(false);

    }

    private void loginreturn(ActionEvent e) {
        this.setVisible(false);
    }

    private void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        usernameText = new JTextField();
        label2 = new JLabel();
        pwdText = new JTextField();
        label3 = new JLabel();
        nameText = new JTextField();
        label4 = new JLabel();
        sexText = new JTextField();
        label5 = new JLabel();
        balanceText = new JTextField();
        label6 = new JLabel();
        birthdayText = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("\u7528\u6237\u540d");

                //---- label2 ----
                label2.setText("\u5bc6\u7801");

                //---- label3 ----
                label3.setText("\u771f\u5b9e\u59d3\u540d");

                //---- label4 ----
                label4.setText("\u6027\u522b");

                //---- label5 ----
                label5.setText("\u4f59\u989d");

                //---- label6 ----
                label6.setText("\u751f\u65e5");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label5)
                                .addComponent(label4)
                                .addComponent(label6)
                                .addComponent(label3)
                                .addComponent(label2))
                            .addGap(84, 84, 84)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(pwdText, GroupLayout.Alignment.LEADING)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(nameText, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(usernameText)
                                .addComponent(sexText)
                                .addComponent(balanceText)
                                .addComponent(birthdayText))
                            .addGap(91, 91, 91))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(19, 19, 19)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(pwdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(sexText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(balanceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(birthdayText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("\u4fdd\u5b58");
                okButton.addActionListener(e -> ok(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\u8fd4\u56de");
                cancelButton.addActionListener(e -> loginreturn(e));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField usernameText;
    private JLabel label2;
    private JTextField pwdText;
    private JLabel label3;
    private JTextField nameText;
    private JLabel label4;
    private JTextField sexText;
    private JLabel label5;
    private JTextField balanceText;
    private JLabel label6;
    private JTextField birthdayText;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
}
