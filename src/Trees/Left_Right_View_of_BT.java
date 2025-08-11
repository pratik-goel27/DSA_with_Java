package Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Left_Right_View_of_BT {

    public static void helperForLeftView(TreeNode root, int levelNum, List<Integer> list) {
        if(root == null) return;

        if(levelNum == list.size()) list.add(root.val);

        helperForLeftView(root.left, levelNum + 1, list);
        helperForLeftView(root.right, levelNum + 1, list);
    }

    public static ArrayList<Integer> leftView(TreeNode root) {
        //Using LEVEL ORDER TRAVERSAL: -

        // ArrayList<Integer> al = new ArrayList<>();
        // if(root == null) return al;
        // Queue<TreeNode> q = new LinkedList<>();
        // q.offer(root);

        // while(!q.isEmpty()) {
        //     int size = q.size();
        //     Integer[] arr = new Integer[size];

        //     for(int i = 0; i < size; i++) {
        //         root = q.poll();
        //         arr[i] = root.val;
        //         if(root.left != null) q.offer(root.left);
        //         if(root.right != null) q.offer(root.right);
        //     }
        //     al.add(arr[0]);
        // }
        // return al;

        //USING RECURSION: -
        ArrayList<Integer> list = new ArrayList<>();
        helperForLeftView(root, 0, list);
        return list;
    }

    public static void helperForRightView(TreeNode root, int levelNum, List<Integer> list) {
        if(root == null) return;

        if(levelNum == list.size()) list.add(root.val);

        helperForRightView(root.right, levelNum + 1, list);
        helperForRightView(root.left, levelNum + 1, list);
    }

    public static ArrayList<Integer> rightView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        helperForRightView(root, 0, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);

        System.out.println("LEFT VIEW: "+ leftView(root));
        System.out.println("RIGHT VIEW: "+rightView(root));
    }
}
