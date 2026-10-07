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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set=new HashSet<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.left != null){
                q.add(current.left);
            }
            if(current.right != null){
                q.add(current.right);
            }

            int  n=k-current.val;
            if(set.contains(n)){
                return true;
            }else{
                set.add(current.val);
            }
        }
        return false;
    }
}