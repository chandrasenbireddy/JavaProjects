package v2;

import java.util.Scanner;
public class CaliculatorCli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        double num1 = scanner.nextDouble();
        System.out.println("Enter the second number:");
        double num2 = scanner.nextDouble();
        System.out.println("Enter an operator (+, -, *, /):");
        char operator = scanner.next().charAt(0);
        double result;
        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = substract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                    if(Double.isNaN(result)){
                        scanner.close();
                        return;
                    }
                break;
            default:
            System.out.println("Error: Invalid operator");
            scanner.close();
            return;
        }
        System.out.println("The result is: " + result);
        scanner.close();
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