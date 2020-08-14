public class Number {
    private int value;
    private boolean romeFlag = false;

    Number (String string) {
        RomeNumber[] romeNumbers = RomeNumber.values();
        for(RomeNumber v : romeNumbers) {
            if (v.name().equals(string)) {
                this.romeFlag = true;
                break;
            }
        }
        if(this.romeFlag){
            this.value = RomeNumber.valueOf(string).getNumber();
        } else {
            try {
                this.value = Integer.parseInt(string);
            } catch (Exception e) {
                System.out.printf("Ошибка. %s не верный формат вводимого числа. ", string);
            }
        }
    }

    public int getValue() {
        return this.value;
    }

    public boolean isRomeFlag() {
        return this.romeFlag;
    }
}
