package CalculatorApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculatorMain extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField textField;

    private final static int width = 400;
    private final static int height = 520;

    String number1,sign,number3;

    CalculatorMain(){
        number1=sign=number3="";
    }

    public static void main(String[] args) {
        frame = new JFrame("Calculator");

        CalculatorMain c = new CalculatorMain();

        textField = new JTextField(16);

        textField.setEditable(false);

        JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
        JButton bEquals,bA,bS,bD,bM,bEq,bE;

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        bEquals = new JButton("=");
        bA = new JButton("+");
        bS = new JButton("-");
        bD = new JButton("/");
        bM = new JButton("*");
        bEq = new JButton("C");
        bE = new JButton(".");

        //b0.setBounds();

        JPanel panel = new JPanel();

        b0.addActionListener(c);
        b1.addActionListener(c);
        b2.addActionListener(c);
        b3.addActionListener(c);
        b4.addActionListener(c);
        b5.addActionListener(c);
        b6.addActionListener(c);
        b7.addActionListener(c);
        b8.addActionListener(c);
        b9.addActionListener(c);

        bEquals.addActionListener(c);
        bA.addActionListener(c);
        bS.addActionListener(c);
        bD.addActionListener(c);
        bM.addActionListener(c);
        bEq.addActionListener(c);
        bE.addActionListener(c);

        panel.add(b0);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bEquals);
        panel.add(bA);
        panel.add(bS);
        panel.add(bD);
        panel.add(bM);
        panel.add(bEq);
        panel.add(bE);
        panel.add(textField);

        panel.setBackground(Color.black);

        frame.add(panel);
        frame.setSize(width, height);
        frame.show();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.'){
            if(!sign.equals(""))
                number3 += s;
            else
                number1 += s;

            textField.setText(number1 + sign + number3);
        }
        else if(s.charAt(0) == 'C'){
            number1 = number3 = sign = "";
            textField.setText(number1 + sign + number3);
        }
        else if(s.charAt(0) == '='){
            double rez;
            if(sign.equals("+"))
                rez = Double.parseDouble(number1) + Double.parseDouble(number3);
            else if(sign.equals("-"))
                rez = Double.parseDouble(number1) - Double.parseDouble(number3);
            else if(sign.equals("/"))
                rez = Double.parseDouble(number1) / Double.parseDouble(number3);
            else
                rez = Double.parseDouble(number1) * Double.parseDouble(number3);

            textField.setText(number1 + sign + number3 + "=" + rez);

            number1 = Double.toString(rez);

            sign = number3 = "";
        }
        else{
            if(sign.equals("") || number3.equals(""))
                sign = s;
            else{
                double rez;

                if(sign.equals("+"))
                    rez = Double.parseDouble(number1) + Double.parseDouble(number3);
                else if(sign.equals("-"))
                    rez = Double.parseDouble(number1) - Double.parseDouble(number3);
                else if(sign.equals("/"))
                    rez = Double.parseDouble(number1) / Double.parseDouble(number3);
                else
                    rez = Double.parseDouble(number1) * Double.parseDouble(number3);

                number1 = Double.toString(rez);
                sign = s;
                number3 = "";
            }
            textField.setText(number1 + sign + number3);
        }
    }
}
