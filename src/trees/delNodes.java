package trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public List<TreeNode> delNodes(TreeNode root, List<Integer> to_delete) {

        Set<Integer> delete=new HashSet<>(to_delete);
        Queue<TreeNode> rootNodes=new LinkedList<>();
        List<TreeNode> result =new ArrayList<>();
        rootNodes.offer(root);
        x: while(!rootNodes.isEmpty())
        {
            TreeNode currRoot=rootNodes.poll();
            if(!delete.contains(currRoot.val))
            {
                result.add(currRoot);
                Queue<TreeNode> temp=new LinkedList<>();
                temp.offer(currRoot);
                while(!temp.isEmpty())
                {
                    TreeNode current=temp.poll();
                    if(!delete.contains(current.val))
                    {
                        if(current.left!=null)
                            temp.offer(current.left);
                        if(current.right!=null)
                            temp.offer(current.right);
                    }
                    else
                    {
                        if(current.left!=null)
                            rootNodes.offer(current.left);
                        if(current.right!=null)
                            rootNodes.offer(current.right);
                        continue x;
                    }

                }

            }
            else
            {
                if(currRoot.left!=null)
                    rootNodes.offer(currRoot.left);
                if(currRoot.right!=null)
                    rootNodes.offer(currRoot.right);

            }



        }
        return result;
    }
    }

