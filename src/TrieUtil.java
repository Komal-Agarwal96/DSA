import java.io.*;
import java.util.*;
class TrieUtil
{
    static class Trie{
        Map<Character,Trie> childNodes=new HashMap<>();
        boolean isEndOfWord=false;
        String value=null;
    }

    static Trie root;

    static void insert(String a)
    {
        Trie current=root;
        for(int i=0;i<a.length();i++)
        {
            Trie node=current.childNodes.get(a.charAt(i));
            if(node==null)
            {
                node=new Trie();
                current.childNodes.put(a.charAt(i),node);
            }
            current=node;
        }
        current.value=a;
        current.isEndOfWord=true;
    }

    static void insertIfNotPrefix(String a)
    {
        Trie current=root;
        for(int i=0;i<a.length();i++)
        {
            Trie node=current.childNodes.get(a.charAt(i));
            if(node==null)
            {
                node=new Trie();
                current.childNodes.put(a.charAt(i),node);
            }
            else if(node.isEndOfWord)
                node.isEndOfWord=false;
            current=node;
        }
        if(current.childNodes.isEmpty())
            current.isEndOfWord=true;
    }

    static boolean search(String a)
    {
        Trie current=root;
        for(int i=0;i<a.length();i++)
        {
            Trie node=current.childNodes.get(a.charAt(i));
            if(node==null)
            {
                return false;
            }
            current=node;
        }
        return current.isEndOfWord;
    }

    static void delete(String a)
    {
        deleteUtil(root,a,0);
    }

    static boolean deleteUtil(Trie node,String a,int index)
    {
        if(a.length()==index)
        {
            if(node.isEndOfWord==false)
                return false;
            node.isEndOfWord=false;
            return node.childNodes.isEmpty();
        }
        Trie nextnode=node.childNodes.get(a.charAt(index));
        if(nextnode==null)
            return false;
       {
            if (deleteUtil(nextnode, a, index + 1)) {
                node.childNodes.remove(a.charAt(index));
                if (node.childNodes.isEmpty() && !node.isEndOfWord)
                    return true;
            }
        }
        return false;
    }




    static void display(String keys[])
    {
        for(String key:keys)
        {
            if(search(key))
                System.out.println(key);
        }
    }

    // main function
    public static void main(String[] args)
    {
        String keys[] = { "apple", "app", "there",
                "the", "like" };
        root=new Trie();
        for(String key:keys)
            insert(key);
        position("\\tsubdir1");

        delete("like");
        display(keys);
    }

    private static int position(String a)
    {
        int count=0;
        for(int i=0;i<a.length()-1;i+=2)
        {
            if(a.charAt(i)=='\\'&&a.charAt(i+1)=='t')
                count++;
            else
                break;
        }
        return count;
    }
}