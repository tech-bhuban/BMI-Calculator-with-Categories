
import javax.swing.*;
import java.awt.*;

public class BMICalculator extends JFrame {
    private JTextField heightField, weightField;
    private JLabel resultLabel;
    
    public BMICalculator() {
        setTitle("BMI Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));
        
        // Input fields
        add(new JLabel("Height (cm):"));
        heightField = new JTextField();
        add(heightField);
        
        add(new JLabel("Weight (kg):"));
        weightField = new JTextField();
        add(weightField);
        
        // Buttons
        JButton calculateButton = new JButton("Calculate BMI");
        JButton clearButton = new JButton("Clear");
        add(calculateButton);
        add(clearButton);
        
        // Result
        resultLabel = new JLabel("", JLabel.CENTER);
        add(resultLabel);
        add(new JLabel(""));
        
        calculateButton.addActionListener(e -> calculate());
        clearButton.addActionListener(e -> {
            heightField.setText("");
            weightField.setText("");
            resultLabel.setText("");
        });
    }
    
    private void calculate() {
        try {
            double height = Double.parseDouble(heightField.getText()) / 100;
            double weight = Double.parseDouble(weightField.getText());
            
            double bmi = weight / (height * height);
            String category;
            
            if(bmi < 18.5) category = "Underweight";
            else if(bmi < 25) category = "Normal weight";
            else if(bmi < 30) category = "Overweight";
            else category = "Obese";
            
            String result = String.format("BMI: %.1f\nCategory: %s", bmi, category);
            resultLabel.setText("<html>" + result.replace("\n", "<br>") + "</html>");
            
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter valid numbers!");
        }
    }
    
    public static void main(String[] args) {
        new BMICalculator().setVisible(true);
    }
}
