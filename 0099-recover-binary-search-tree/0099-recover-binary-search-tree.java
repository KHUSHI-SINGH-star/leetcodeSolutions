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
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode sec = null;

    public void recoverTree(TreeNode root) {
        helper(root);

        int temp = first.val;
        first.val = sec.val;
        sec.val = temp;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        if (pre != null && root.val < pre.val) {
            if (first == null) {
                first = pre;
            }
            sec = root;
        }
        pre = root;

        helper(root.right);
    }

}