import java.util.*;
import java.lang.*;
import java.io.*;

class SlidingWindow {
    public static void main (String[] args) {


       /* Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=0;j<t;j++)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[]=new int[n];

            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
            }
            maxSubArrayK(a,k);
        }*/

        int arr[] = {2, 5, -1, 7, -3, -1, -2} ;
        int k = 3;
        maxSubArrayK(arr, k);
        //code
    }
    static void  maxSubArrayK(int[] a,int k)
    {
        int n=a.length,i=0;
        Deque<Integer> max=new LinkedList<Integer>();
        Deque<Integer> min=new LinkedList<Integer>();

        for( i=0;i<k;i++)
        {
            while(!max.isEmpty()&&a[max.peekLast()]<=a[i]){
                max.pollLast();
            }
            while(!min.isEmpty()&&a[min.peekLast()]>=a[i]){
                min.pollLast();
            }
            max.offer(i);
            min.offer(i);
        }
        for(;i<n;i++)
        {
            int z=a[max.peek()]+a[min.peek()];
            System.out.print(z+" ");
            while(!max.isEmpty()&&max.peekFirst()<=i-k){
                max.pollFirst();
            }
            while(!max.isEmpty()&&a[max.peekLast()]<=a[i]){
                max.pollLast();
            }
            max.offer(i);

            while(!min.isEmpty()&&min.peekFirst()<=i-k){
                min.pollFirst();
            }
            while(!min.isEmpty()&&a[min.peekLast()]>=a[i]){
                min.pollLast();
            }
            min.offer(i);
        }
        int z=a[max.peek()]+a[min.peek()];
        System.out.print(z+" ");

        System.out.println();
    }
}