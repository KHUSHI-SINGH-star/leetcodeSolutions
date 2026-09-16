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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();

        if(root ==null){
            return ans;
        }
       Queue <TreeNode> q=new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
        List<Integer> list=new ArrayList<>();
        int size=q.size();
        for(int i=0;i<size;i++){
            TreeNode current =q.remove();
            list.add(current.val);
            if(current.left != null){
                q.add(current.left);
            }
            if(current.right != null){
                q.add(current.right);
            }
        }
        ans.add(list.get(list.size() - 1));
       }
        return ans;
    }
}