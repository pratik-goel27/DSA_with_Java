package Arrays.Easy;

public class Missing_Number {
    public static void main(String[] args) {
        int[] arr = {1,2,5,4};
        int N = 5;

        //BRUTE FORCE:-
        for (int i = 1; i <= N; i++) {
            int flag = 0;    //to check whether a particular i is present in the array or not.
            for (int j : arr) {
                if (j == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("The number does not exist is: " + i);
            }
        }
    }
}
