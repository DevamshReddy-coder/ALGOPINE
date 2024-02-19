import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class NumberGuessingGame extends JFrame
{
private JTextField guessField;
private JLabel feedbackLabel;
private JButton guessButton;
private int randomNumber;
public NumberGuessingGame()
{
    setTitle("NUMBER GAME:");
    setSize(500,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new FlowLayout());
    guessField=new JTextField(10);
    guessField.setFont(new Font("Arial", Font.PLAIN, 70)); 
    feedbackLabel=new JLabel("enter your guess");
    feedbackLabel.setFont(new Font("Arial", Font.PLAIN, 70));
    guessButton=new JButton("guess");
    guessButton.setFont(new Font("Arial", Font.PLAIN, 70));
    randomNumber = generateRandomNumber();
    add(feedbackLabel);
    add(guessField);
    add(guessButton);
    guessButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            checkGuess();
        }
    });
}
private int generateRandomNumber()
{
    Random r=new Random();
    return r.nextInt(100)+1;
}
private void checkGuess()
{
    try{
        int guess=Integer.parseInt(guessField.getText());
        if(guess<randomNumber)
        {
            feedbackLabel.setText("Too Low!Please Try Again");
        }
        else if(guess >randomNumber)
        {
            feedbackLabel.setText("Too High!Please Try Again");
        }
        else
        {
            feedbackLabel.setText("Congratulations! You Guessed The Correct Number");
            guessButton.setEnabled(false);
        }
    }
    catch(NumberFormatException e)
    {
        feedbackLabel.setText("Please Enter A Valid Number:");
    }
}
public static void main(String [] args)
{
   SwingUtilities.invokeLater(new Runnable() {
    public void run()
    {
        new NumberGuessingGame().setVisible(true);
    }
   });
}

}
