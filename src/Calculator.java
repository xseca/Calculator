import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueCalculation = true;
        while (continueCalculation) {
            System.out.println("Введите операцию (например, '2 + 3') или 'exit' для выхода:");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                continueCalculation = false;
                System.out.println("Программа завершена.");
            } else {
                try {
                    int result = calculate(input);
                    System.out.println("Результат: " + result);
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                    continueCalculation = false; // Завершение приложения после ошибки
                }
            }
        }
    }

    public static int calculate(String input) throws Exception {
        String[] tokens = input.split(" ");

        if (tokens.length != 3 || tokens[1].length() != 1 || !"+-*/".contains(tokens[1])) {
            throw new Exception("Некорректный формат операции");
        }

        int a;
        int b;
        try {
            a = Integer.parseInt(tokens[0]);
            b = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Неверный формат чисел");
        }

        if ((a < 1 || a > 10) || (b < 1 || b > 10)) {
            throw new Exception("Числа должны быть от 1 до 10");
        }

        int result;
        switch (tokens[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new Exception("Деление на ноль");
                }
                result = a / b; // Результатом является только целая часть от деления
                break;
            default:
                throw new Exception("Некорректная операция");
        }

        return result;
    }
}

