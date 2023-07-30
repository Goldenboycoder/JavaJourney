package Exercises.Algo2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;



class Solution2 {

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


    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        int result = 0;
        queue.add(root);

        while(!queue.isEmpty()){

            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode currNode = queue.poll();

                if(i==0){
                    result = currNode.val;
                }
                
                if(currNode.left!= null){
                    queue.add(currNode.left);
                }

                if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }
        }
        return result;
    }
}
