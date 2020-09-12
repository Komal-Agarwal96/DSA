package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelRestrictions {

    static StringBuilder sb;

    static List<String> a=new ArrayList<>();
    private static void getTrip(int N,String incoming,String outgoing, int i,int j,Character[][] output)
    {

        if(i<0||i>N||j<0||j>N)
            return;

        if(Math.abs(i-j)==0) {

            output[i][j]='Y';
            return ;
        }
        if(Math.abs(i-j)==1)
        {
            if(incoming.charAt(j)=='Y'&&outgoing.charAt(i)=='Y') {
                output[i][j]='Y';
                return ;
            }
            output[i][j]='N';
            return ;
        }
        if(i<j)
        {
            if(output[i][j-1]!=null && output[i][j-1]=='Y'&&output[j-1][j]!=null&&output[j-1][j]=='Y') {
                output[i][j]='Y';
                return ;
            }
        }
        else
        {
            if(output[i][j+1]!=null && output[i][j+1]=='Y'&&output[j+1][j]!=null&&output[j+1][j]=='Y') {
                output[i][j]='Y';
                return ;
            }
        }
        output[i][j]='N';
    }

    public static void main(String args[])
    {
        sb=new StringBuilder();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int N=sc.nextInt();
            String incoming=sc.next();
            String outgoing=sc.next();
            Character[][] output=getTrips(N,incoming,outgoing);
            getString(output,N-1,i+1);
        }
        System.out.println(sb.toString());
    }

    public static Character[][] getTrips(int N, String incoming,String outgoing) {
        N--;
        Character[][] output=new Character[N+1][N+1];
        for (int k = 0; k <= N; k++) {
            for (int i = 0; i <= N; i++) {
                int j1=i+k;
                int j2=i-k;

                getTrip(N,incoming, outgoing, i, j1,output);
                if(j1!=j2)
                getTrip(N,incoming, outgoing, i, j2,output);

            }
        }
     return output;
    }

    private static void getString(Character[][] output,int N,int c)
    {

        sb.append(String.format("Case #%s: \n",c));
        for(int i=0;i<=N;i++)

        {
            for (int j = 0; j <= N; j++) {
                sb.append(output[i][j]);
            }
            sb.append('\n');
        }

    }
}
