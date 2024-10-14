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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int depth = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int cnt = que.size();
            depth++;

            for (int i = 0; i < cnt; i++) {
                TreeNode tn = que.poll();

                if (tn.left == null && tn.right == null)
                    return depth;
                if (tn.left != null)
                    que.offer(tn.left);
                if (tn.right != null)
                    que.offer(tn.right);
            }
        }

        return depth;
    }
}