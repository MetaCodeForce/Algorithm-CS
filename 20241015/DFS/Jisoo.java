/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        ArrayList<Integer> ans = new ArrayList<>();
        pathSum(root, 0, targetSum, ans);

        if (ans.size() > 0)
            return true;

        return false;
    }

    private static void pathSum(TreeNode root, int sum, int targetSum, List<Integer> ans) {

        if (root.left == null && root.right == null) {
            if (targetSum == sum + root.val)
                ans.add(targetSum);
        }

        if (root.left != null)
            pathSum(root.left, sum + root.val, targetSum, ans);
        if (root.right != null)
            pathSum(root.right, sum + root.val, targetSum, ans);

    }
}