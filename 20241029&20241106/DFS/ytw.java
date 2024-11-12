//Runtime 0 ms Beats 100.00% Analyze Complexity 
// Memory 50.64 MB Beats 95.13% Analyze Complexity

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        // if(root.val < low || root.val > high){
        //     return 0;
        // }
        if(root.val < low){
            return rangeSumBST(root.right, low, high);
        }
        if(root.val > high){
            return rangeSumBST(root.left, low, high);
        }

        if(root.val >= low && root.val <= high){
            return root.val+rangeSumBST(root.left, low, high)+rangeSumBST(root.right, low, high);
        }

        return 0;
    }
}
// Runtime 0 ms Beats 100.00% Analyze Complexity Memory 41.73 MB Beats 5.22%
// 재귀 풀이
class MyStack {

    MyStack myTop;
    Boolean isOpen = false; // 자기 자신을 어케 나타내냐;;
    int val;

    public MyStack() {
    }
    
    public void push(int x) {
        if(!this.isOpen){
            this.myTop = new MyStack();
            this.myTop.val = x;
            this.isOpen = true;
        }else {
            this.myTop.push(x);
        }
    }
    
    public int pop() {
        if(!this.myTop.isOpen){
            // this = null;
            // super.finalize();
            // this.myBottom.myTop = null; // 자기 자신을 어케 나타내냐;;
            this.isOpen = false;
            return this.myTop.val;
        }
        return !this.isOpen ? this.val : this.myTop.pop();
    }
    
    public int top() {
        return !this.isOpen ? this.val : this.myTop.top();
    }
    
    public boolean empty() {
        return !this.isOpen;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */