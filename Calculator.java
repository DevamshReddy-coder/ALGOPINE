import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator
 {
    private JFrame frame;
    private JTextField numField1, numField2, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, clearButton;
    public Calculator()
     {
        frame = new JFrame("Simple Calculator");
        frame.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        numField1 = new JTextField();
        numField2 = new JTextField();
        topPanel.add(new JLabel("Number 1:"));
        topPanel.add(numField1);
        topPanel.add(new JLabel("Number 2:"));
        topPanel.add(numField2);
        JPanel centerPanel = new JPanel(new GridLayout(4, 1));
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        centerPanel.add(addButton);
        centerPanel.add(subtractButton);
        centerPanel.add(multiplyButton);
        centerPanel.add(divideButton);
        JPanel bottomPanel = new JPanel(new FlowLayout());
        resultField = new JTextField("Result", 20);
        resultField.setEditable(false);
        clearButton = new JButton("Clear");
        bottomPanel.add(resultField);
        bottomPanel.add(clearButton);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        addButton.addActionListener(new ButtonClickListener());
        subtractButton.addActionListener(new ButtonClickListener());
        multiplyButton.addActionListener(new ButtonClickListener());
        divideButton.addActionListener(new ButtonClickListener());
        clearButton.addActionListener(new ButtonClickListener());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private class ButtonClickListener implements ActionListener
     {
        public void actionPerformed(ActionEvent e)
         {
            if (e.getSource() == clearButton) 
            {
                numField1.setText("");
                numField2.setText("");
                resultField.setText("Result");
            } else 
            {
                try 
                {
                    double num1 = Double.parseDouble(numField1.getText());
                    double num2 = Double.parseDouble(numField2.getText());
                    double result = 0;
                    if (e.getSource() == addButton)
                     {
                        result = num1 + num2;
                    } else if (e.getSource() == subtractButton) 
                    {
                        result = num1 - num2;
                    } else if (e.getSource() == multiplyButton)
                     {
                        result = num1 * num2;
                    } else if (e.getSource() == divideButton)
                     {
                        if (num2 == 0)
                         {
                            resultField.setText("Error! Division by zero.");
                            return;
                        } else 
                        {
                            result = num1 / num2;
                        }
                    }

                    resultField.setText(Double.toString(result));
                } catch (NumberFormatException ex) {
                    resultField.setText("Invalid input");
                }
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() 
            {
                new Calculator();
            }
        });
    }
}
