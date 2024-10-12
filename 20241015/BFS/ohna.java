import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        //큐에 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //뎁스체크 - 루트는 1
        int depth =1 ;
       
        while(!queue.isEmpty()){
             //큐사이즈
            int qSize = queue.size();

            for(int i=0;i<qSize;i++){//큐를확인....
                
                //큐 하나 빼고 그 다음거
                TreeNode next = queue.poll();

                //자식없는 리프노드 확인 
                if(next.left == null && next.right ==null){
                    return depth;
                }

                //왼 오 있나 확인
                if(next.left !=null){
                    //큐에 다시 담아
                    queue.offer(next.left);
                }
                if(next.right !=null){
                    queue.offer(next.right);
                } 

            }
            depth++;
        }        
        return depth; //어차피 우ㅣ에서 될걸?

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
    }

}