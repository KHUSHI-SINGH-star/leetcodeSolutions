/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Brust force approach
    // public boolean isValidBST(TreeNode root) {
    //      ArrayList<Integer> list=new ArrayList<>();
    //      inorder(root,list);

    //      for (int i = 0; i < list.size() - 1; i++) {
    //         if (list.get(i) > list.get(i + 1)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public void inorder(TreeNode root,ArrayList list){
    //     if(root == null){
    //         return ;
    //     }

    //      inorder(root.left,list);
    //      list.add(root.val);
    //      inorder(root.right,list);

    // }

    // Optimal approach
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);

    }
}