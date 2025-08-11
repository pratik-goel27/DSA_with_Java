//package Trees;
//
//public class Check_If_The_BT_Is_Balanced {
////    public static int depthOfTree(TreeNode root) {
////        if(root == null) {
////            return 0;
////        }
////        int l = depthOfTree(root.left);
////        int r = depthOfTree(root.right);
////        int val = Math.abs(l-r);
////        if(l)
////        if(val <= 1) return Math.max(l,r)+1;
////        return null;
////    }
//
//    public static boolean isBalanced(TreeNode root) {
//        if(root == null) {
//            return true;
//        }
//        int left = depthOfTree(root.left);
//        int right = depthOfTree(root.right);
//        if(left == -1 || right == -1) return false;
//        int val = Math.abs(left-right);
//        if(val > 1) return false;
//        return true;
//    }
//
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(4);
//        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(3);
//        root.right.right.right = new TreeNode(4);
//
//        System.out.println(isBalanced(root));
//    }
//}
