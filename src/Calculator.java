import java.util.Scanner;

public class Calculator

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        System.out.println("Калькулятор");
        System.out.print("Введите первое число: ");
        num1 = input.nextDouble();

        System.out.print("Введите оператор (+, -, *, /): ");
        operator = input.next().charAt(0);

        System.out.print("Введите второе число: ");
        num2 = input.nextDouble();

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
                if (num2 == 0) {
                    System.out.println("Ошибка: деление на ноль");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Некорректный оператор");
                return;
        }

        System.out.println("Результат: " + result);
    }
}
