package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Print_Root_to_Node_Path {
        //root to a node path
//    public static boolean getPath(TreeNode root, ArrayList<Integer> al, int x) {
//        if(root == null) return false;
//
//        al.add(root.val);
//        if(root.val == x) {
//            return true;
//        }
//
//        if( (getPath(root.left, al, x)) || (getPath(root.right, al, x)) ) {
//            return true;
//        }
//
//        al.removeLast();
//        return false;
//    }

    //root to leaf paths:-
    public static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public static void getPath(List<List<Integer>> list, List<Integer> subList, TreeNode root) {
        if(root == null) return;

        subList.add(root.val);
        if(isLeaf(root)){
            list.add(new ArrayList<>(subList));
        }
        else {
            getPath(list, subList, root.left);
            getPath(list, subList, root.right);
        }

        subList.remove(subList.size()-1);
    }

    public static List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        getPath(list,subList,root);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(6);
//        root.left.right.right = new TreeNode(7);

        List<List<Integer>> list = allRootToLeaf(root);
        System.out.println(list);
    }
}