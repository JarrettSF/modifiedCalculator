import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

JFrame frame;
JTextField textField;
JButton[] numberButtons = new JButton[10];
JButton[] functionButtons = new JButton[8];
JButton addButton, subButton, multiplyButton, divideButton;
JButton decimalButton, equalsButton, deleteButton, clearButton;
JPanel panel;

Font font = new Font("SansSerif", Font.BOLD, 30);
double num1 = 0, num2 = 0, num3 = 0;
char operator;



Calculator() {

    frame = new JFrame("Calculator", null);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setSize(420, 540);
    frame.setLayout(null);

    textField = new JTextField();
    textField.setBounds(50, 25, 300, 50);
    textField.setFont(font);
    textField.setEditable(false);

    addButton = new JButton("+");
        subButton = new JButton("-");
            multiplyButton = new JButton("*");
                divideButton = new JButton("/");
                    decimalButton = new JButton(".");
                        deleteButton = new JButton("delete");
                            equalsButton = new JButton("=");
                                clearButton = new JButton("clear");


    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = multiplyButton;
    functionButtons[3] = divideButton;
    functionButtons[4] = decimalButton;
    functionButtons[5] = equalsButton;
    functionButtons[6] = deleteButton;
    functionButtons[7] = clearButton;

    for (int i = 0; i < 8; i++){

            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
           

    }


for (int i = 0; i < 10; i++){

            numberButtons[i] = new JButton(String.valueOf(i));
             numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);

    }

    deleteButton.setBounds(50, 430, 145, 50);
   clearButton.setBounds(205, 430, 145, 50);

   panel = new JPanel();
   panel.setBounds(50, 100, 300, 300);
   panel.setLayout(new GridLayout(4, 4, 10, 10));
   panel.setBackground(Color.GRAY);

    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(addButton);
     panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(subButton);
     panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(multiplyButton);
    panel.add(decimalButton);
    panel.add(numberButtons[0]);
    panel.add(equalsButton);
    panel.add(divideButton);

   frame.add(panel);
    frame.add(deleteButton);
    frame.add(clearButton);
    frame.add(textField);
    frame.setVisible(true);

}
    public static void main(String[] args) throws Exception {
        
        Calculator calc = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double result = 0;
        for (int i = 0; i < 10; i++){

            if(e.getSource() == numberButtons[i]){

                textField.setText(textField.getText().concat(String.valueOf(i)));
            }

        }

        if (e.getSource() == decimalButton){
                textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton){

            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

          if (e.getSource() == subButton){

            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

          if (e.getSource() == multiplyButton){

            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

          if (e.getSource() == divideButton){

            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equalsButton){
            num2 = Double.parseDouble(textField.getText());

            
            switch (operator){
                case '+': 
                   result = num1 + num2; 
                   break;
             case '-': 
                   result = num1 - num2; 
                   break;
            case '*': 
                   result = num1 * num2; 
                   break;
            case '/': 
                   result = num1 / num2; 
                   break;
            } textField.setText(String.valueOf(result));
            num1 = result;

        }

            if (e.getSource() == clearButton){
                    textField.setText("");
            }

            if (e.getSource() == deleteButton){
             
                String string = textField.getText();
                textField.setText("");
                for (int i = 0; i < string.length()-1; i++){
                    textField.setText(textField.getText()+string.charAt(i));
                }

            }

    }

}
