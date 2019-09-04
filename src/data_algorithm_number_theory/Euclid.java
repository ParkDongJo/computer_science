package data_algorithm_number_theory;

public class Euclid {
    public static void main(String[] args) {

    }

    public static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a%b);
    }
}
