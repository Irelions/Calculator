public enum RomeNumber {
    M(1000), D(500), C(100), L(50), X(10), V(5), I(1), II(2), III(3), IV(4), VI(6), VII(7), VIII(8), IX(9);

    private final int number;

    RomeNumber(int number){
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}
