package arrays;


import java.lang.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/* Name of the class has to be "Main" only if the class is public. */
class MergeSort
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your arrays goes here
        int a[]={2,5,9,1,0};
        int b[]={3,3,3,3,3,1,3};
        groupThePeople(b);
        mergeSort(a);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }

    static void	mergeSort(int a[])
    {
        int aux[]=new int[a.length];
        mergeSortUtil(a,0,a.length-1,aux);

    }

    static void	mergeSortUtil(int a[],int l, int r, int aux[] )

    {
       // System.out.println(">>>>>>"+l+" "+r);
        if(l>=r)
            return ;
        int m=l+(r-l)/2;
        //sort first half
        mergeSortUtil(a,l,m,aux);

        //sort second half
        mergeSortUtil(a,m+1,r,aux);


        int i=l,j=m+1,k=l;
        for( i=l;i<=r;i++){
            aux[i]=a[i];
        }
         i=l;
        while(i<=m&&j<=r) {
          //  System.out.println(">>>>>>   k= "+k+" i= "+i+" j="+j);
            if (aux[i] <= aux[j]) {
                a[k++] = aux[i++];
            } else
                a[k++] = aux[j++];

/*
            for (int x = l; x <= r; x++) {
                System.out.print(a[x] + " ");
            }*/
        }
        while(i<=m)
            a[k++]=aux[i++];
        while(j<=r)
            a[k++]=aux[j++];
       /* System.out.println("Sorted Array");
        for( i=l;i<=r;i++){
            System.out.print(a[i]+" ");
        }*/

    }

    static List<List<Integer>> groupThePeople(int[] a) {

        Map<Integer,List<Integer>> map=new HashMap<>();
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0;i<a.length;i++)
        {
            List<Integer> temp=map.computeIfAbsent(a[i], ArrayList::new);
            temp.add(i);
            if(temp.size()==a[i])
            {
                result.add(temp);
                map.remove(a[i]);
            }
        }
        return result;
    }
}