package arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Timber {

    static StringBuilder sb;

    static Integer max=0;
   static class Tree
   {
       int position;
       int height;
       Tree()
       {

       }
   }
    public static void main(String args[]) throws FileNotFoundException {
        sb=new StringBuilder();
      Scanner sc=new Scanner(new FileInputStream("/Users/komal.agarwal/zoom/DSA/src/arrays/timber_input.txt"));
       // Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();


            List<Tree> trees=new ArrayList<>();

            for(int j=0;j<n;j++)
            {
                Tree tree=new Tree();
                tree.position=sc.nextInt();
                tree.height=sc.nextInt();
                trees.add(tree);
            }
            trees.sort(
                    (o1, o2) -> o1.position - o2.position);
            max=0;
            getCombinedTimberInterval(trees);
            sb.append(String.format("Case #%s: %s\n",i+1,max));
            max=0;
        }
        System.out.println(sb.toString());
    }

    private static void getCombinedTimberInterval(List<Tree> trees) {



        TreeMap<Integer,Integer> rightFallMap=new TreeMap<>();
        TreeMap<Integer,Integer> leftFallMap=new TreeMap<>();

        for (Tree tree : trees) {
            int p = tree.position;

            int v = rightFallMap.getOrDefault(tree.position, 0) + tree.height;
            rightFallMap.put(p + tree.height, Math.max(rightFallMap.getOrDefault(p + tree.height, Integer.MIN_VALUE), v));
        }

        for(int i=trees.size()-1;i>=0;i--)
        {
            int p=trees.get(i).position;

            int v=leftFallMap.getOrDefault(trees.get(i).position,0)+trees.get(i).height;
            leftFallMap.put(p-trees.get(i).height, Math.max(leftFallMap.getOrDefault(p - trees.get(i).height, Integer.MIN_VALUE), v));
        }
        TreeSet<Integer> positions=new TreeSet<>();
        positions.addAll(rightFallMap.keySet());
        positions.addAll(leftFallMap.keySet());
        for(int p:positions)
        {
            max=Math.max(rightFallMap.getOrDefault(p,0)+leftFallMap.getOrDefault(p,0),max);
        }
    }


}
