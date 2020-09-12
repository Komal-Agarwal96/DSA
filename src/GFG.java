import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        //code
        Scanner sc=new Scanner(System.in);
        List<String> inputs=new ArrayList<>();
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            String a=sc.next();
            inputs.add(a);
        }
        for(int i=0;i<t;i++)
        {
            findPermutations(inputs.get(i),0,new StringBuilder());
            System.out.println();
        }
    }
    static void findPermutations(String s,int i,StringBuilder sb)
    {
        if(i==s.length())
        {
            System.out.print(sb.toString()+" ");
            return;
        }
        for(int j=0;j<s.length();j++)
        {
            sb.append(s.charAt(j));
            findPermutations(s,i+1,sb);
            sb.setLength(sb.length()-1);
        }
    }
}