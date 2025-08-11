package Arrays.Easy;

public class Maximum_Consecutive_Ones {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1,0,1,1};
        int count = 0;
        int max = 0;
        for(int num : arr) {
            if(num == 1) {
                count++;
                max = Math.max(count,max);
            }else {
                count = 0;
            }
        }
        System.out.println(max);
    }
}
