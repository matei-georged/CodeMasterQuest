// Given a binary tree, determine if it is height-balanced.
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        mIsBalanced = true;
        isBalancedHelper(root, 0);
        return mIsBalanced;
    }

    public int isBalancedHelper(TreeNode root, int depth) {

        if (root == null || mIsBalanced == false) {
            return depth;
        }

        int depthLF = isBalancedHelper(root.left, depth + 1);
        int depthRG = isBalancedHelper(root.right, depth + 1);

        mIsBalanced = mIsBalanced && (Math.abs(depthRG - depthLF) <= 1);

        return Math.max(depthLF, depthRG);
    }

    static boolean mIsBalanced;
}