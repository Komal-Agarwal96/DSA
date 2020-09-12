package arrays;

public class MedianSortedArrays {

   static double median(int a[],int b[])
    {
        int x=a.length;
        int y=b.length;
        if(x>y)
            return median(b,a);
        int lo=0,hi=x;
        int m=(x+y+1)/2;

        while (lo<=hi)
        {
            int i=(lo+hi)/2;
            int j=m-i;

            int aLeft=(i-1>0)?a[i-1]:Integer.MIN_VALUE;
            int bLeft=(j-1>0)?b[j-1]:Integer.MIN_VALUE;
            int aRight=(i<x)?a[i]:Integer.MAX_VALUE;
            int bRight=(j<y)?b[j]:Integer.MAX_VALUE;
            if(aLeft<=bRight&&bLeft<=aRight)
            {
                if((x+y)%2!=0)
                    return Math.max(aLeft,bLeft);
                else
                    return (Math.max(aLeft,bLeft)+Math.min(aRight,bRight))/2.0;
            }
            else if(aLeft>bRight)
            {
                hi=i-1;
            }
            else
            {
                lo=i+1;
            }

        }

        return 0;
    }
    static double findMedianSortedArrays(int input1[], int input2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }


    public static void main (String[] args) throws java.lang.Exception {
        // your arrays goes here
        int a[] = {1, 2, 9, 8, 10};
        int b[] = {3, 7, 12, 13, 33, 61, 73};
        System.out.println(median(a,b));
        System.out.println(findMedianSortedArrays(a,b));
    }
}
