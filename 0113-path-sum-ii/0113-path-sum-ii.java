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
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum,0,new ArrayList<>());
        return ans;
    }

    public void helper(TreeNode root,int TargetSum,int sum,List<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.val);
        sum += root.val;
         if (root.left==null && root.right ==null &&sum == TargetSum) {
            ans.add(new ArrayList<>(list));
        }

        helper(root.left,TargetSum,sum,list);
        helper(root.right,TargetSum,sum,list);
        list.remove(list.size()-1);
    }
}