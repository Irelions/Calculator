
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
                    System.out.print(new Converter(this.result).convert());
                } else if (!operationSign.equals("/")) {
                    System.out.print((int)this.result);
                } else {
                    System.out.print(this.result);
                }
            }
        }
    }
}