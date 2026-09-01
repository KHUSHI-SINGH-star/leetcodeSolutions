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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean isNull=false;

        while(!q.isEmpty()){
            TreeNode current=q.remove();
            if(current == null){
               if(isNull == false){
                isNull=true;
               }
            }
            if(current != null){
                if(isNull == true){
                    return false;
                }
            }
            if (current != null) {
                q.add(current.left);
                q.add(current.right);
            }
            }
        
        return true;
    }
}