package Arrays.Medium;

import java.util.ArrayList;

public class Rearrange_Array_Elements_by_Sign {

    public static ArrayList<Integer> rearrange(ArrayList<Integer> arr) {
           //If the No. of +ves and -ves are the same :-
//        //BRUTE SOLUTION:-
//        int[] pos = new int[arr.length/2];
//        int[] neg = new int[arr.length/2];
//        int j = 0;
//        int k = 0;
//        for(int i = 0; i < arr.length; i++) {
//            if(arr[i] > 0) {
//                pos[j] = arr[i];
//                j++;
//            }else {
//                neg[k] = arr[i];
//                k++;
//            }
//        }
//
//        for(int i = 0; i < pos.length; i++) {
//            arr[2*i] = pos[i];
//            arr[2*i+1] = neg[i];
//        }
//        System.out.println(Arrays.toString(arr));


        //OPTIMAL SOLUTION:-
//        int[] ans = new int[arr.length];
//        int pos = 0;
//        int neg = 1;
//        for(int i = 0; i < arr.length; i++) {
//            if(arr[i] > 0) {
//                ans[pos] = arr[i];
//                pos = pos + 2;
//            }else {
//                ans[neg] = arr[i];
//                neg = neg + 2;
//            }
//        }
//
//        System.out.println(Arrays.toString(ans));


        //If the No. of +ves and -ves are not equal (If equal then also the code will work) :-
        //OPTIMAL cannot be used here we have to use the BRUTE Soln :-
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) >= 0) pos.add(arr.get(i));
            else neg.add(arr.get(i));
        }

        arr.clear();
        if(pos.size() > neg.size()) {
            for(int i = 0; i < neg.size(); i++) {
                arr.add(2*i, pos.get(i));
                arr.add(2*i+1, neg.get(i));
            }

            int index = neg.size() * 2;
            for(int i = neg.size(); i < pos.size(); i++) {
                arr.add(index, pos.get(i));
                index++;
            }
        }else {
            for(int i = 0; i < pos.size(); i++) {
                arr.add(2*i, pos.get(i));
                arr.add(2*i+1, neg.get(i));
            }

            int index = pos.size() * 2;
            for(int i = pos.size(); i < neg.size(); i++) {
                arr.add(index, neg.get(i));
                index++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr = {3,1,-2,-5,2,-4};
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(9);
        numbers.add(4);
        numbers.add(-2);
        numbers.add(-1);
        numbers.add(5);
        numbers.add(0);
        numbers.add(-5);
        numbers.add(-3);
        numbers.add(2);

        System.out.println(rearrange(numbers));
    }
}
