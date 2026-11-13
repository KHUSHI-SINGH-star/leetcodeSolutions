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
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {
        makeParent(root, null);
        TreeNode node = findNode(root, start);
        int count = 0;
        return time(node, count);
    }

    public TreeNode findNode(TreeNode root, int start) {
        if (root == null) {
            return null;
        }
        if (root.val == start) {
            return root;
        }

        TreeNode left = findNode(root.left, start);
        if (left != null) {
            return left;
        }

        TreeNode right = findNode(root.right, start);
        if (right != null) {
            return right;
        }
        return null;
    }

    public int time(TreeNode root, int count) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (current.left != null && !visited.contains(current.left)) {
                    q.add(current.left);
                    visited.add(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    q.add(current.right);
                    visited.add(current.right);
                }
                TreeNode p = parent.get(current);
                if (p != null && !visited.contains(p)) {
                    q.add(p);
                    visited.add(p);
                }
            }
            count++;
        }
        return count - 1;
    }

    public void makeParent(TreeNode root, TreeNode par) {
        if (root == null) {
            return;
        }
        parent.put(root, par);
        makeParent(root.left, root);
        makeParent(root.right, root);
    }
}