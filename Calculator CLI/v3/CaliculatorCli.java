package v3;

import java.util.Scanner;
public class CaliculatorCli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter first number:");
            double num1 = scanner.nextDouble();
            System.out.println("Enter the second number:");
            double num2 = scanner.nextDouble();
            System.out.println("Enter an operator (+, -, *, /):");
            char operator = scanner.next().charAt(0);
            try{
                double result = calculate(num1, num2, operator);
                System.out.println("Result: " + result);
                }
                catch(IllegalArgumentException e){
                    System.out.println("Error: Invalid operator " + e.getMessage());
                }
            System.out.println("Do you want to perform another calculation? (yes/no)");
            String choice = scanner.next();
            while(!choice.equalsIgnoreCase("yes") && !(choice.equalsIgnoreCase("no"))){
                System.out.println("Invalid choice, choose again");
                choice = scanner.next();
            }
            if(choice.equalsIgnoreCase("no")) {
                scanner.close();
                break;
            }
        }
    }
    private static double calculate(double num1, double num2, char operator) {
        switch (operator) {
                case '+':
                    return add(num1, num2);
                case '-':
                    return substract(num1, num2);
                case '*':
                    return multiply(num1, num2);
                case '/':
                    return divide(num1, num2);
                default:
                throw new IllegalArgumentException("send a proper operator +, -, /, * you have entrered: " + operator);
            }
    }
    private static double add(double a, double b) {
            return a+b;
        }
    private static double substract(double a, double b) {
        return a-b;
    }
    private static double multiply(double a, double b){
        return a*b;
    }
    private static double divide(double a, double b) {
        if(b == 0){
                    System.out.println("Error: Division by zero");
                    return Double.NaN;
                }
        return a/b;
    }
}
