import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // Runtime 61 ms Beats 6.08%
    // Complexity Memory 59.25 MB Beats 99.87%
    public int minDepth(TreeNode root) {

        // 예외 케이스 처리(root : null)
        if (root == null)
            return 0;

        // 변수 선언
        int depth = 1;

        // 큐 선언
        // Queue<TreeNode> queue = new LinkedList<>();
        Queue<Object[]> queue = new LinkedList<>();
        Object[] queueAndDepth = new Object[2];

        // 루트 노드 넣기
        TreeNode rootNode = new TreeNode(root.val, root.left, root.right);
        queueAndDepth[0] = rootNode;
        queueAndDepth[1] = 1;
        queue.add(queueAndDepth);

        // 큐
        while (true) {
            // TreeNode targetNode = queue.poll();
            Object[] targetObject = queue.poll();
            TreeNode targetNode = (TreeNode) targetObject[0];
            int targetNodeDepth = (int) targetObject[1];

            if (targetNode == null)
                continue;

            // 왼큐 넣기
            Object[] leftObject = new Object[2];
            leftObject[0] = targetNode.left;
            leftObject[1] = targetNodeDepth + 1;
            queue.add(leftObject);

            // 오른큐 넣기
            Object[] rightObject = new Object[2];
            rightObject[0] = targetNode.right;
            rightObject[1] = targetNodeDepth + 1;
            queue.add(rightObject);

            // 자식 노드가 없으면 종료
            if (targetNode.left == null && targetNode.right == null) {
                depth = targetNodeDepth;
                break;
            } else {
                System.out.println("in Node : " + targetNode.val);
                if (targetNode.left != null) {
                    System.out.println("in left : " + targetNode.left.val);
                }
                if (targetNode.right != null) {
                    System.out.println("in right : " + targetNode.right.val);
                }
            }
        }

        return depth;
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

// 이거 쩐다...
public int minDepth(TreeNode root) {
    // Base case...
    // If the subtree is empty i.e. root is NULL, return depth as 0...
    if (root == null)
        return 0;
    // Initialize the depth of two subtrees...
    int leftDepth = minDepth(root.left);
    int rightDepth = minDepth(root.right);
    // If the both subtrees are empty...
    if (root.left == null && root.right == null)
        return 1;
    // If the left subtree is empty, return the depth of right subtree after adding
    // 1 to it...
    if (root.left == null)
        return 1 + rightDepth;
    // If the right subtree is empty, return the depth of left subtree after adding
    // 1 to it...
    if (root.right == null)
        return 1 + leftDepth;
    // When the two child function return its depth...
    // Pick the minimum out of these two subtrees and return this value after adding
    // 1 to it...
    return Math.min(leftDepth, rightDepth) + 1; // Adding 1 is the current node which is the parent of the two
                                                // subtrees...
}