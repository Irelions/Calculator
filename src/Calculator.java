
public class Calculator {

    private Number numberOne;
    private Number numberTwo;
    private double result = -101;
    private String operationSign;
    private final String string;

    Calculator (String string) {
        this.string = string;
    }

//Разделение строки на элемены и занесение в массив
    private void splitString (String string) {
        String[] splitString;
        splitString = string.trim().split(" ");
        if (splitString.length == 3) {
            numberOne = new Number(splitString[0]);
            numberTwo = new Number(splitString[2]);
            this.operationSign = splitString[1];
        }
    }

//Конвертация римского числа в арабское
    String convertRomeToArab(double arabNumber) {

        String[] romeNumbers = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        if (arabNumber < 0) {
            System.out.print("Ошибка. Число в римской системе счисления не может быть отрицательным. ");
            return "";
        } else if ((arabNumber * 10) % 10 > 0) {
            System.out.print("Ошибка. Дробная часть не предусмотрена. ");
            return "";
        } else {
        return romeNumbers[(int)arabNumber];
        }
    }

//Вычисления
    public void calculate() {
        splitString(this.string);
        if (numberOne.getValue() > 10 || numberTwo.getValue() > 10 || numberOne.getValue() == 0 || numberTwo.getValue() == 0) {
            System.out.print("Ошибка! Введите числа от 1 до 10. ");
        } else {
            if (this.numberOne.isRomeFlag() != this.numberTwo.isRomeFlag()){
                System.out.print("Ошибка! Неверно введены значения аргументов. ");
            } else {
                switch (operationSign) {
                    case "+":
                        this.result =  this.numberOne.getValue() + this.numberTwo.getValue();
                        break;
                    case "-":
                        this.result = this.numberOne.getValue() - this.numberTwo.getValue();
                        break;
                    case "*":
                        this.result = this.numberOne.getValue() * this.numberTwo.getValue();
                        break;
                    case "/":
                        if(this.numberTwo.getValue() != 0) {
                            this.result = (double) this.numberOne.getValue() / this.numberTwo.getValue();
                        } else {
                            System.out.print("Ошибка! Деление на ноль запрещено. ");
                        }
                        break;
                    default:
                        System.out.print("Ошибка! Не верный знак операции. ");
                        break;
                }
            }
            if (this.result != -101) {
                if (numberOne.isRomeFlag() && numberTwo.isRomeFlag()) {
                    System.out.print(convertRomeToArab(this.result));
                } else if (!operationSign.equals("/")) {
                    System.out.print((int)this.result);
                } else {
                    System.out.print(this.result);
                }
            }
        }
    }
}