package trees;



class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Check_BST
{
    int isBST(Node root)
    {
        // Your arrays here
        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }

    int isBSTUtil(Node root, int min, int max)
    {
        if(root==null)
            return 1;
        if(root.data<min||root.data>max)
            return 0;
        return isBSTUtil(root.left,min,root.data-1)&isBSTUtil(root.right,root.data+1,max);
    }
}