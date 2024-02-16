import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class PasswordLoginSystem extends JFrame
{
private static final String PASSWORD="DevamshReddy143";
public static void main(String [] args)
{
    JFrame frame=new JFrame ("Login System");
    JPanel panel=new JPanel();
    JLabel label=new JLabel("Enter Your Password:");
    label.setFont(new Font("Arial", Font.PLAIN, 16)); 
    JPasswordField passwordfield=new JPasswordField(15);
    passwordfield.setFont(new Font("Arial", Font.PLAIN, 16));
    JButton loginbutton=new JButton("Login");
    loginbutton.setFont(new Font("Arial", Font.PLAIN, 16));
    loginbutton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
           char[] enteredPassword=passwordfield.getPassword();
           if(isPasswordCorrect(enteredPassword))
           {
            JOptionPane.showMessageDialog(frame, "Access granted. Welcome!");
           }
           else{
            JOptionPane.showMessageDialog(frame, "Wrong password. Try again.");
            passwordfield.setText("");
           }
        }
    });
    panel.add(label);
    panel.add(passwordfield);
    panel.add(loginbutton);
    frame.add(panel);
    frame.setSize(300,150);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

}
private static boolean isPasswordCorrect(char[] enteredPassword) {
    String password = new String(enteredPassword);
    return password.equals(PASSWORD);
}
}