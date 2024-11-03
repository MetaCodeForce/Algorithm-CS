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
    // 1. 큐
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        int sum = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int cnt = que.size();

            for (int i = 0; i < cnt; i++) {
                TreeNode tn = que.poll();

                if (tn.val >= low && tn.val <= high) {
                    sum += tn.val;
                }

                if (tn.left != null)
                    que.offer(tn.left);
                if (tn.right != null)
                    que.offer(tn.right);
            }
        }

        return sum;
    }

    // 2. 재귀
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        int[] sum = new int[1];
        rangeSum(root, low, high, sum);

        return sum[0];
    }

    private static void rangeSum(TreeNode root, int low, int high, int[] sum) {
        if (root.val >= low && root.val <= high) {
            sum[0] += root.val;
        }

        if (root.left != null)
            rangeSum(root.left, low, high, sum);
        if (root.right != null)
            rangeSum(root.right, low, high, sum);
    }
}