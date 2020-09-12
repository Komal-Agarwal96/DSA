package arrays;

import java.util.Scanner;

public class Alchemy {
    static StringBuilder sb;


    public static void main(String args[])
    {
        sb=new StringBuilder();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            sc.nextInt();
            String shards=sc.next();
            boolean isPossible=isShardPossible(shards);
            if(isPossible) {
                sb.append(String.format("Case #%s: Y\n",i+1));
            } else {
                sb.append(String.format("Case #%s: N\n",i+1));
            }
        }
        System.out.println(sb.toString());
    }

    private static Character getReducedCharacter(String a)
    {
        int a_count=0,b_count=0;
        for(int i=0;i<3;i++)
        {
            if(a.charAt(i)=='A')
                a_count++;
            else
                b_count++;
        }
        if(b_count==0||a_count==0)
            return null;
        if(a_count>b_count)
            return 'A';
        return 'B';
    }


    private static boolean isShardPossible(String shards) {

        while(shards.length()>0) {
            if(shards.length()==1)
                return true;
            String a=shards;
            for (int i = 0; i <= shards.length() - 3; i++) {
                Character replaced = getReducedCharacter(shards.substring(i, i + 3));
                if (replaced == null)
                    continue;

                shards=shards.substring(0, i) + replaced + shards.substring(i + 3);
                break;
                }
            if(a.equals(shards))
                break;
            }
        return false;


    }

}



