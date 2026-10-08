public final class Fraction extends Number {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator){
        if (denominator == 0){
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        if (denominator < 0){
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public Fraction sum(Fraction other){
        return new Fraction(numerator * other.denominator + other.numerator * denominator,
                denominator * other.denominator);
    }

    public Fraction sum(int n){
        return sum(new Fraction(n, 1));
    }

    public Fraction minus(Fraction other){
        return new Fraction(numerator * other.denominator - other.numerator * denominator,
                denominator * other.denominator);
    }

    public Fraction minus(int n){
        return minus(new Fraction(n, 1));
    }

    public Fraction mul(Fraction other){
        return new Fraction(numerator * other.numerator, denominator * other.denominator);
    }

    public Fraction mul(int n){
        return mul(new Fraction(n, 1));
    }

    public Fraction div(Fraction other){
        return new Fraction(numerator * other.denominator, denominator * other.numerator);
    }

    public Fraction div(int n){
        return div(new Fraction(n, 1));
    }

    @Override
    public int intValue(){
        return numerator / denominator;
    }
    @Override
    public long longValue(){
        return (long) numerator / denominator;
    }
    @Override
    public float floatValue(){
        return (float) numerator / denominator;
    }
    @Override
    public double doubleValue(){
        return (double) numerator / denominator;
    }



    @Override
    public String toString(){
        return numerator + "/" + denominator;
    }
}
