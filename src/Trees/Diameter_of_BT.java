package Trees;

public class Diameter_of_BT {
//    public static int height(TreeNode root) {
//        if(root == null) return 0;
//        int lh = height(root.left);
//        int rh = height(root.right);
//        return Math.max(lh,rh)+1;
//    }
//
//    public static int diameter(TreeNode root) {
//        if(root == null) return -1;
//        int lh = height(root.left);
//        int rh = height(root.right);
//        int maxi = -1;
//        maxi = Math.max(maxi,lh+rh);
//        diameter(root.left);
//        diameter(root.right);
//        return maxi;
//    }

    //OPTIMAL SOLUTION:-
    static int maxi = 0;
    public static int helper(TreeNode root) {
        if(root == null) return 0;
        int lh = helper(root.left);
        int rh = helper(root.right);
        maxi = Math.max(maxi,lh+rh);
        return 1 + Math.max(lh,rh);
    }
    public static int diameter(TreeNode root) {
        maxi = 0;
        helper(root);
        return maxi;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameter(root));

    }
}
