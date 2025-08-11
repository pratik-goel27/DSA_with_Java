package Trees;

import java.util.HashMap;

public class Construct_BT_From_Preorder_Inorder {

    public static TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = helper(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = helper(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);

        return root;
    }

    public static void main(String[] args) {

    }
}
