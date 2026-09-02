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
    int preIndex=0;
    public int search(int[] inorder, int preIndex,int left,int right){
        for(int i=left;i<=right;i++){
            if(inorder[i] == preIndex){
                return i;
            }
        }
        return 0;
    }
    public TreeNode helper(int[] preorder, int[] inorder,int left,int right){
        if(left >right){
            return null;
        }
         TreeNode root=new TreeNode(preorder[preIndex]);
        preIndex++;

        int index=search(inorder,root.val,left,right);
        root.left=helper(preorder,inorder,left,index-1);
        root.right=helper(preorder,inorder,index+1,right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
         return  helper(preorder,inorder,0,preorder.length-1);
    }
}