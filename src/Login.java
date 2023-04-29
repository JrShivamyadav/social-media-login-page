
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JFrame frame;
    JTextField username;
    JPasswordField password;
    JButton btnlogin, btnCancel;

    Login() {
        frame = new JFrame();
        frame.setBounds(250, 50, 700, 550);
        frame.setVisible(true);
        Container c = frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("k.jpg"));
        Image i1 = icon.getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(270, 10, 170, 170);
        c.add(image);


        JLabel User = new JLabel("Username");
        User.setBounds(130, 200, 150, 30);
        Font font = new Font("Arial", Font.PLAIN, 20);
        User.setFont(font);
        c.add(User);


        username = new JTextField();
        username.setBounds(270, 200, 250, 30);
        c.add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(130, 270, 150, 30);
        pass.setFont(font);
        c.add(pass);

        password = new JPasswordField();
        password.setBounds(270, 270, 250, 30);
        c.add(password);


        JLabel forget = new JLabel("forget password??");
        forget.setBounds(400, 310, 150, 30);
        forget.setFont( new Font("Arial", Font.PLAIN, 16));
        c.add(forget);


        btnlogin = new JButton("Login");
        btnlogin.setBounds(170, 380, 150, 40);
        Font btnfont = new Font("Arial", Font.BOLD, 15);
        btnlogin.setFont(btnfont);
        btnlogin.setBackground(Color.BLACK);
        btnlogin.setForeground(Color.WHITE);
        btnlogin.addActionListener(this);
        c.add(btnlogin);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(350, 380, 150, 40);
        btnCancel.setFont(btnfont);
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(this);

        c.add(btnCancel);



        frame.setResizable(false);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnlogin) {
            String user = username.getText();
            String pass=password.getText();
            try{
                conn cn=new conn();

                String query ="select * from login where username='"+user+"' and password ='"+ pass+"'";

                ResultSet rs = cn.s.executeQuery(query);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login Sucessfully");
                    frame.setVisible(false);

                }

                else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    frame.setVisible(false);
                }
            }catch (Exception ae){
                ae.printStackTrace();
            }
        } else if (e.getSource() == btnCancel)
        {
            frame.setVisible(false);

        }
    }
}
