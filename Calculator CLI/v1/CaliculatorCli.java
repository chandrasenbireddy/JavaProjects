package v1;

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
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if(num2 == 0){
                    System.out.println("Error: Division by zero");
                    scanner.close();
                    return;
                }
                result = num1/num2;
                break;
            default:
            System.out.println("Error: Invalid operator");
            scanner.close();
            return;
        }
        System.out.println("The result is:" + result);
        scanner.close();
    }
}