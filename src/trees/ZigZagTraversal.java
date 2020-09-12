package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
}

class TreeNode {
   int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class ZigZagSolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        boolean rightToLeft=false;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> tempList=new ArrayList<>();
        while(!q.isEmpty())

        {
            TreeNode temp=q.poll();
            if(temp==null)
            {

                if(rightToLeft)
                    Collections.reverse(tempList);
                rightToLeft=!rightToLeft;
                result.add(new ArrayList<>(tempList));
                tempList.clear();
                if(!q.isEmpty())
                {
                    q.offer(null);
                }
            }
            else
            {
                tempList.add(temp.val);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);

            }

        }
        return result;
    }
}