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
    // brute-force search
    // int index = 0;
    // public int search(int[] inorder, int index, int left, int right) {
    //     for (int i = left; i <= right; i++) {
    //         if (inorder[i] == index) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // public TreeNode bstFromPreorder(int[] preorder) {
    //     int[] inorder = preorder.clone();
    //      Arrays.sort(inorder);
    //     return helper(preorder, inorder, 0, preorder.length - 1);
    // }

    // public TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
    //     if (left > right) {
    //         return null;
    //     }

    //     TreeNode root = new TreeNode(preorder[index]);
    //     index++;

    //     int current = search(inorder, root.val, left, right);
    //     root.left = helper (preorder, inorder,left, current-1);
    //     root.right = helper(preorder,inorder,  current+1, right);
    //     return root;
    // }
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);

    }

    public TreeNode helper(int[] preorder, int max) {
        if (index == preorder.length || preorder[index] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);

        root.left = helper(preorder, root.val);
        root.right = helper(preorder, max);
        return root;
    }
}