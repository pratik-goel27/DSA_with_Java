package Trees;

import java.util.ArrayList;
import java.util.List;

public class Max_Path_Sum_of_BT {
    static int maxi = 0;
    public static int helper(TreeNode root) {
        if(root == null) return 0;
        int lst = helper(root.left);
        int rst = helper(root.right);
        maxi = Math.max((lst+rst+root.val),maxi);
        return Math.max(lst,rst) + root.val;
    }

    public static int maxPathSum(TreeNode root) {
        helper(root);
        return maxi;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));

        List<Integer> list = new ArrayList<>();
    }
}
