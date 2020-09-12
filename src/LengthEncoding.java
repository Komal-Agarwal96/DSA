public class LengthEncoding {
    String encode(String str)
    {
        //Your code here

        StringBuilder sb=new StringBuilder();
        char prev=str.charAt(0);
        int count =1;
        for(int i=1;i<str.length();i++)
        {
            char curr=str.charAt(i);
            if(curr==prev)
                count++;
            else
            {
                sb.append(prev);
                sb.append(count);
                count =1;
                prev=curr;
            }
        }
        sb.append(prev);
        sb.append(count);
        return sb.toString();
    }



    void encode2(String str)
    {
        int[] a=lps(str);
        for(int i=0;i<a.length;i++)
        {
            if(i!=0&&a[i]<a[i-1])
                System.out.print("*");
            if(a[i]==0)
                System.out.print(str.charAt(i));

        }
        System.out.println();
    }

    int[] lps(String str)
    {
        int n=str.length();
        int [] a=new int[n];
        int j=0,i=1;
        while(j<n&&i<n)
        {

            if(str.charAt(i)==str.charAt(j))
            {
                a[i++]=++j;
            }
            else if(j==0)
            {
                a[i]=0;
                i++;
            }
            else
                j=a[j-1];
        }
        return a;
    }

}