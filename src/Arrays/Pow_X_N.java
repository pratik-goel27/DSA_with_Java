package Arrays;

public class Pow_X_N {
    public static double myPow(double x, int n) {
        //BRUTE FORCE SOLUTION :-
//        if (n == 0 || x == 1.0) return 1;
//
//        long temp = n;
//        if (n < 0) {
//            x = 1 / x;
//            temp = -1L * n;
//        }
//
//        double ans = 1;
//        for (long i = 0; i < temp; i++) {
//            ans *= x;
//        }
//        return ans;

        
        //OPTIMAL SOLUTION :-
        double ans = 1.0;
        long nn = n;
        if(nn < 0) nn = -1 * nn;
        while(nn > 0) {
            if(nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            }else {
                x = x * x;
                nn = nn / 2;
            }
        }

        if(n < 0) return 1.0 / ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -10));
    }
}
