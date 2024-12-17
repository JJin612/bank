import cn.lanqiao.dao.AdminDao;
import cn.lanqiao.dao.UserDao;
import cn.lanqiao.model.Admin;
import cn.lanqiao.model.User;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

public class LoginFrame extends JFrame {
    UserDao userDao =new UserDao();
    AdminDao adminDao=new AdminDao();
    public LoginFrame() {
        initComponents();
    }

    private void login(ActionEvent e) {
        if(userBtn.isSelected()){
            System.out.println("Normal user is logging in");
            User user= userDao.login(usernameText.getText(),pwdText.getText());
            if(user!=null){
                System.out.println("Login successful");
                this.setVisible(false);
                new MainFrame(user).setVisible(true);
            }else{
                msg.setText("Wrong username or password");
                System.out.println("Login Failed");
            }
        }else{
            System.out.println("Administrator is logging in");
            Admin admin= adminDao.login(usernameText.getText(),pwdText.getText());
            if(admin!=null){
                System.out.println("Login successful");
                this.setVisible(false);
                new AdminMainFrame().setVisible(true);
            }else{
                msg.setText("Wrong username or password");
                System.out.println("Login Failed");
            }
        }

    }

    private void register(ActionEvent e) {
        new RegisterFrame().setVisible(true);  
    }

    private void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        usernameText = new JTextField();
        pwdText = new JTextField();
        label3 = new JLabel();
        msg = new JLabel();
        userBtn = new JRadioButton();
        adminBtn = new JRadioButton();
        buttonBar = new JPanel();
        loginbutton = new JButton();
        registerButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
                label3.setText("\u94f6\u884c\u7ba1\u7406\u7cfb\u7edf");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 16f));

                //---- msg ----
                msg.setForeground(Color.red);

                //---- userBtn ----
                userBtn.setText("\u666e\u901a\u7528\u6237");
                userBtn.setSelected(true);

                //---- adminBtn ----
                adminBtn.setText("\u7ba1\u7406\u5458");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label1))
                            .addGap(48, 48, 48)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(pwdText)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap(82, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(96, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(userBtn)
                                    .addGap(49, 49, 49)
                                    .addComponent(adminBtn))
                                .addComponent(label3))
                            .addGap(99, 99, 99))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(131, 131, 131)
                            .addComponent(msg)
                            .addContainerGap(243, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3)
                            .addGap(29, 29, 29)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(pwdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))
                            .addGap(8, 8, 8)
                            .addComponent(msg)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(userBtn)
                                .addComponent(adminBtn))
                            .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- loginbutton ----
                loginbutton.setText("\u767b\u5f55");
                loginbutton.setMinimumSize(new Dimension(340, 200));
                loginbutton.addActionListener(e -> login(e));
                buttonBar.add(loginbutton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- registerButton ----
                registerButton.setText("\u6ce8\u518c");
                registerButton.addActionListener(e -> register(e));
                buttonBar.add(registerButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(userBtn);
        buttonGroup1.add(adminBtn);
    }

    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JTextField usernameText;
    private JTextField pwdText;
    private JLabel label3;
    private JLabel msg;
    private JRadioButton userBtn;
    private JRadioButton adminBtn;
    private JPanel buttonBar;
    private JButton loginbutton;
    private JButton registerButton;

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}
