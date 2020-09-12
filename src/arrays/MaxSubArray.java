package arrays;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MaxSubArray {
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=0;k<t;k++)
        {
            int n=sc.nextInt();
            List<Integer> data =new ArrayList<>();
            for(int i=0;i<n;i++)
                data.add(sc.nextInt());
            int m=sc.nextInt();
            System.out.println(getMaxLengthSubList(data,m));
        }
    }

    static int getMaxLengthSubList(List<Integer> a, int m)
    {

        int i;
        for(i=0;i<a.size();i++) {
            if (a.get(i) == 1)
                break;
        }
        if(i==a.size())
            return m;
        int start=i;
        int end=i;
        int zeroCount=0;
        int maxCount=1;
        while(start<=end&&end<a.size()-1)
        {
            if(a.get(end+1)==1)
            end++;
            else if(zeroCount<m)
                {
                    zeroCount++;
                    end++;
                }
            else {
                    while(a.get(start)==1)
                        start++;
                    start++;
                    zeroCount--;
                }

            maxCount=Math.max(end-start+1,maxCount);

        }
        return maxCount;
    }
}