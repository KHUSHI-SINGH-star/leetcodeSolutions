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
    int postIndex;
    public int search(int[] inorder,int val,int left,int right){
        for(int i=right;i>=left;i--){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
    public TreeNode helper(int[] inorder, int[] postorder,int left,int right){
        if(left > right){
            return null;
        }

        TreeNode root=new TreeNode(postorder[postIndex]);
        postIndex--;

        int index=search(inorder,root.val,left,right);
        root.right=helper(inorder,postorder,index+1,right);
        root.left=helper(inorder,postorder,left,index-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         postIndex = postorder.length - 1;
       return helper(inorder,postorder,0,inorder.length-1);
    }
}