package Arrays.Medium;

public class Pascals_Triangle {
    public static int function(int n, int r) {
        int res = 1;
        for(int i = 0; i < r; i++) {
            res = res * (n-i);
            res = res / (i+1);
        }

        return res;
    }

    public static int generate(int n, int r) {
        return function(n-1, r-1);
    }

    public static void main(String[] args) {
        System.out.println(generate(6,3));
    }
}
