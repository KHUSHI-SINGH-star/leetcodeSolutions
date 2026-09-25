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
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return helper(root, ans);
    }

    public List<List<Integer>> helper(TreeNode root, List<List<Integer>> ans) {
        if (root == null) {
            return ans;
        }
        boolean rev = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                list.add(current.val);
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            if (rev) {
               Collections.reverse(list);
            } 
                ans.add(new ArrayList<>(list));
                rev = !rev;
        }
        return ans;
    }
}