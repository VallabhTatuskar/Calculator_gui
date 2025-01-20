import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class cal_gui {
    public static void main(String[] args) {
        JFrame frame=new JFrame("Calculator");
        frame.setSize(400, 400);
        JPanel panel=new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(0, 1));
        JLabel label=new JLabel("Select an option:");
        panel.add(label);
        JButton bmr=new JButton("BMR Calculator");
        panel.add(bmr);
        JButton conv=new JButton("Binary, Octal, Hexadecimal Converter");
        panel.add(conv);
        JButton num=new JButton("Basic Calculator");
        panel.add(num);
        JButton exit=new JButton("Exit");
        panel.add(exit);
        bmr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BMR();
            }
        });
        conv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conv();
            }
        });
        num.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num();
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
    public static void BMR() {
        JFrame frame=new JFrame("BMR Calculator");
        frame.setSize(400, 300);
        JPanel panel=new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(0, 1));
        JTextField weightT=new JTextField();
        JTextField heightT=new JTextField();
        JTextField ageT=new JTextField();
        JTextField genderT=new JTextField();
        JLabel resultT=new JLabel("Your BMR is: ");
        panel.add(new JLabel("Enter weight in kg:"));
        panel.add(weightT);
        panel.add(new JLabel("Enter height in cm:"));
        panel.add(heightT);
        panel.add(new JLabel("Enter age in years:"));
        panel.add(ageT);
        panel.add(new JLabel("Enter gender (M/F):"));
        panel.add(genderT);
        panel.add(resultT);
        JButton calculate=new JButton("Calculate BMR");
        panel.add(calculate);
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double weight=Double.parseDouble(weightT.getText());
                double height=Double.parseDouble(heightT.getText());
                int age=Integer.parseInt(ageT.getText());
                char gender=genderT.getText().charAt(0);
                double bmr=BMR(weight, height, age, gender);
                resultT.setText("Your BMR is: " + bmr);
            }
        });
        frame.setVisible(true);
    }
    public static void conv() {
        JFrame frame=new JFrame("Number Converter");
        frame.setSize(400, 300);
        JPanel panel=new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(0, 1));
        JTextField numberF=new JTextField();
        JLabel resultL=new JLabel("Conversions will appear here");
        panel.add(new JLabel("Enter a number:"));
        panel.add(numberF);
        panel.add(resultL);
        JButton convert=new JButton("Convert");
        panel.add(convert);
        convert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int number=Integer.parseInt(numberF.getText());
                resultL.setText("Binary: " + Integer.toBinaryString(number) + " | Octal: " + Integer.toOctalString(number) + " | Hexadecimal: " + Integer.toHexString(number).toUpperCase());
            }
        });
        frame.setVisible(true);
    }
    public static void num() {
        JFrame frame=new JFrame("Basic Calculator");
        frame.setSize(400, 300);
        JPanel panel=new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(0, 1));
        JTextField num1F=new JTextField();
        JTextField num2F=new JTextField();
        JTextField resultField=new JTextField();
        resultField.setEditable(false);
        panel.add(new JLabel("Enter first number:"));
        panel.add(num1F);
        panel.add(new JLabel("Enter second number:"));
        panel.add(num2F);
        panel.add(new JLabel("Result:"));
        panel.add(resultField);
        String[] operators={"+", "-", "*", "/"};
        JComboBox Combo=new JComboBox(operators);
        panel.add(Combo);
        JButton calculateButton=new JButton("Calculate");
        panel.add(calculateButton);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1=Double.parseDouble(num1F.getText());
                double num2=Double.parseDouble(num2F.getText());
                String operator=(String) Combo.getSelectedItem();
                double result=calculate(num1, num2, operator.charAt(0));
                resultField.setText(String.valueOf(result));
            }
        });

        frame.setVisible(true);
    }
    public static double BMR(double weight, double height, int age, char gender) {
        double bmr=0;
        if(gender=='M' || gender=='m') {
            bmr=66.5+(13.75*weight)+(5.003*height)-(6.75*age);
        }else if(gender=='F'||gender=='f') {
            bmr=655.1+(9.563*weight)+(1.850*height)-(4.676 * age);
        }
        return bmr;
    }
    public static double calculate(double num1, double num2, char operator) {
        switch(operator){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            case '/':
                if(num2!=0) {
                    return num1/num2;
                }else{
                    JOptionPane.showMessageDialog(null, "Error! Division by zero.");
                }
            default:
                return 0;
        }
    }
}