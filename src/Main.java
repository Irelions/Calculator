import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        Calculator calculator = new Calculator(string);
        try {
            calculator.calculate();
        } catch (NullPointerException e) {
            System.out.print("Ошибка! Введено неверное выражение. ");
        }
    }
}
