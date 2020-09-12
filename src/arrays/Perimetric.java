package arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Perimetric
{


    public static void main(String args[]) throws FileNotFoundException {
        //Scanner sc=new Scanner(new FileInputStream("/Users/komal.agarwal/zoom/DSA/src/arrays/timber_input.txt"));
         Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {

            /**Get all inputs**/
            int prevWPosition=0;
            int prevPerimeter=0;
            int product=1;
            int n=sc.nextInt();
            int k=sc.nextInt();
            int w=sc.nextInt();
            int l[]=new int [n+1];
            for(int j=1;j<=k;j++)
                l[j]=sc.nextInt();
            int al=sc.nextInt();
            int bl=sc.nextInt();
            int cl=sc.nextInt();
            int dl=sc.nextInt();

            int h[]=new int [n+1];
            for(int j=1;j<=k;j++)
                h[j]=sc.nextInt();
            int ah=sc.nextInt();
            int bh=sc.nextInt();
            int ch=sc.nextInt();
            int dh=sc.nextInt();
            for(int j=k+1;j<=n;j++) {
                l[j]=((al*l[j-2]+bl*l[j-1]+cl)%dl)+1;
                h[j] =((ah*h[j-2]+bh*h[j-1]+ch)%dh)+1;
            }

            /**Calculate perimeter*/

            for(int index=1;index<=n;index++)
            {
                int currPerimeter=0;
                if(index==1||l[index]>prevWPosition)
                {
                     currPerimeter=(prevPerimeter%1000000007+2*(w+h[index])%1000000007)%1000000007;

                }

                else
                {
                    int height=getHeight(l,h,l[index],w,index);
                    if (h[index]>=height)
                    {
                        currPerimeter=(prevPerimeter%1000000007+2*(l[index]-l[index-1])%1000000007+2*(h[index]-height)%1000000007)%1000000007;
                    }
                    else
                        currPerimeter=(prevPerimeter%1000000007+2*(l[index]-l[index-1])%1000000007)%1000000007;
                }
                product=(int)((long)(product%1000000007)*(currPerimeter%1000000007)%1000000007l);

                prevPerimeter=currPerimeter;
                prevWPosition=l[index]+w;
            }

            System.out.println("Case #"+(i+1)+": "+product);
        }

    }

    static int getHeight(int l[],int h[],int x,int w,int index)
    {
        int max=0;
        for(int i=1;i<index;i++)
        {
            if(l[i]<=x&&l[i]+w>=x)
                max=Math.max(max,h[i]);

        }
        return max;
    }
}
