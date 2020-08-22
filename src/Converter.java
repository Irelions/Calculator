import java.util.ArrayList;

public class Converter {
    private int intNumber = 0;
    private String strNumber = "";
    ArrayList<String> arrayList = new ArrayList();

    Converter (double number){
        if (number < 0) {
            System.out.print("Ошибка. Число в римской системе счисления не может быть отрицательным. ");
        } else if ((number * 10) % 10 > 0) {
            System.out.print("Ошибка. Дробная часть не предусмотрена. ");
        } else {
            this.intNumber = (int) number;
        }

    }
    //Конструктор для конвертации Римских чисел в Арабские - не реализованно
    Converter (String string) {
        this.strNumber = string;
    }

    private void add (String str, int col) {
        for (int i = 0; i < col; i++) {
            arrayList.add(str);
        }
    }

    private void add (String str1, String str2) {
        arrayList.add(str1);
        arrayList.add(str2);
    }

    private void add (String str) {
        arrayList.add(str);
    }

    public String convert() {
        int[] arrayTemp = new int[4];
        RomeNumber[] romeEnums = RomeNumber.values();

        //Создание массива количества 1000, 100, 10, 1
        int k = 1000;
        for (int i = 0; i < arrayTemp.length; i++) {
            arrayTemp[i] = this.intNumber / k;
            this.intNumber -= arrayTemp[i] * k;
            k /= 10;
        }


        //Добавление к arrayList количесво 1000 римскими числами
        if (arrayTemp[0] > 0) {
            add(romeEnums[0].name(), arrayTemp[0]);
        }

        //Цикл. Добавление к arrayList количесва 100, 10, 1 римскими числами
       for (int i = 1; i < arrayTemp.length ; i++) {
            if (arrayTemp[i] >= 0 && arrayTemp[i] <= 3) {
                add(romeEnums[i * 2].name(), arrayTemp[i]);
            } else if (arrayTemp[i] == 4) {
                add(romeEnums[i * 2].name(), romeEnums[(i * 2) - 1].name());
            } else if (arrayTemp[i] == 5) {
                add(romeEnums[(i * 2) - 1].name());
            } else if (arrayTemp[i] >= 6 && arrayTemp[i] <= 8) {
                add(romeEnums[(i * 2) - 1].name());
                add(romeEnums[i * 2].name(), arrayTemp[i] - 5);
            } else {
                add(romeEnums[i * 2].name(), romeEnums[(i * 2) - 2].name());
            }
        }

       //Формирование результирующей строки
       for (String str : this.arrayList) {
           this.strNumber += str;
       }
       return this.strNumber;
    }
}
