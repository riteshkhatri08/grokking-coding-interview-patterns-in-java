// https://leetcode.com/problems/validate-binary-search-tree/
// https://leetcode.com/problems/validate-binary-search-tree/submissions/1174599253

package dfs;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return validate(root.left, Long.MIN_VALUE, root.val)
                && validate(root.right, root.val, Long.MAX_VALUE);
    }

    // [0,-1]
    public boolean validate(TreeNode node, long lowerBoundForLeftValue, long upperBoundForRightValue) {
        if (node == null)
            return true;
        // System.out.println("curnode = " + node.val);
        if (node.left != null) {
            // System.out.println("compare " + node.left.val + " <= " + node.val +",lb = " +
            // lowerBoundForLeftValue + ", ub="+upperBoundForRightValue);
            if (node.left.val < node.val && node.left.val > lowerBoundForLeftValue) {
                if (!validate(node.left, lowerBoundForLeftValue, node.val)) {
                    return false;
                }
            } else {
                // YAHA pe jhol hai
                return false;
            }
        }
        if (node.right != null) {
            // System.out.println("compare " + node.right.val + " >= " + node.val+",lb = " +
            // lowerBoundForLeftValue + ", ub="+upperBoundForRightValue);
            if (node.right.val > node.val && node.right.val < upperBoundForRightValue) {

                if (!validate(node.right, node.val, upperBoundForRightValue)) {
                    return false;
                }
            } else {
                // YAHA pe jhol hai
                return false;
            }
        }
        return true;
    }

    public class TreeNode {
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

}