import java.util.Scanner;

public class Heap {
    int n;
    Integer a[];
    int i=0;
    Heap(int n)
    {
      this.n=n;
      a=new Integer[n];
    }
    void insert(int x)
    {
        a[i]=x;
        swim(i++);
    }

    void deleteMax()
    {
        int t=a[0];
        a[0]=a[--i];
        a[i]=null;
        sink(0);

    }
    void swim(int k)
    {
        while(k/2>=0&&a[k]>a[k/2])
        {

           swap(k,k/2);
           k=k/2;
        }
    }

    void sink(int k)
    {
        while(2*k<i)
        {
            int j=2*k;
            if(j+1<n&&a[j+1]>a[j]) j++;
            if(a[k]<a[j])
            swap(k,j);
            k=j;
        }
    }

    void swap(int x,int y)
    {
        int t=a[x];
        a[x]=a[y];
        a[y]=t;
    }
    public static void main (String[] args) {
        Heap heap=new Heap(5);

        heap.insert(5);

        heap.insert(6);
        heap.insert(1);
        heap.deleteMax();
        System.out.println("ok");
    }


}
