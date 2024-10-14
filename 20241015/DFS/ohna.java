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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        //리프노드면 끈ㅌ난거임
        if(root.left == null && root.right == null){
            //체크
            return root.val ==targetSum;
        }

        //그게아니면계쏙 아래로 가면서 더해야하니까 반ㅂㄱ이다.맞나?
        int remainNum = targetSum - root.val; // 9-5 = 4
        if (root.left != null && hasPathSum(root.left, remainNum)) {
            return true;
        }
        if (root.right != null && hasPathSum(root.right, remainNum)) {
            return true;
        }
        return false;
    }
       

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
       
}