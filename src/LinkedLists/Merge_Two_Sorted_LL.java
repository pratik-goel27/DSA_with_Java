package LinkedLists;

public class Merge_Two_Sorted_LL {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //BRUTE FORCE (Using extra space) :-
//        ListNode temp1 = list1;
//        ListNode temp2 = list2;
//        ArrayList<Integer> al = new ArrayList<>();
//
//        while(temp1 != null) {
//            al.add(temp1.data);
//            temp1 = temp1.next;
//        }
//
//        while(temp2 != null) {
//            al.add(temp2.data);
//            temp2 = temp2.next;
//        }
//
//        Collections.sort(al);
//
//        ListNode dummy =  new ListNode(-1);
//        ListNode temp = dummy;
//        for(int num : al) {
//            temp.next = new ListNode(num);
//            temp = temp.next;
//        }
//
//        return dummy.next;

        //OPTIMAL SOLUTION (In place) :-
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.data > list2.data) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        ListNode res = list1;

        while(list1 != null && list2 != null) {
            ListNode tmp = null;
            while(list1 != null && list1.data <= list2.data) {
                tmp = list1;
                list1 = list1.next;
            }
            tmp.next = list2;

            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,3,4};
        ListNode list1 = LLUtils.createSinglyLL(arr1);
        ListNode list2 = LLUtils.createSinglyLL(arr2);
        ListNode head = mergeTwoLists(list1, list2);
        LLUtils.displaySinglyLL(head);
    }
}
