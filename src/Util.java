class Util
{
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Function to find all possible combinations of words formed
    // by replacing given positive numbers with corresponding
    // character of English alphabet
    public static void recur(int[] a, int i, StringBuilder sb)
    {
        if(i==a.length)
        {
            System.out.println(sb.toString());
            return;
        }


        if(isValid(a[i])) {
            sb.append(alphabet.charAt(a[i] - 1));
            recur(a, i + 1, sb);
            sb.setLength(sb.length() - 1);
        }
        if(i<a.length-1&&isValid(a[i]*10+a[i+1])) {
            sb.append(alphabet.charAt(a[i] * 10 + a[i + 1] - 1));
            recur(a, i + 2, sb);
            sb.setLength(sb.length() - 1);
        }

    }
    public static boolean isValid(int n)
    {
        return (n>=0&&n<26);

    }

    // main function
    public static void main(String[] args)
    {
        int[] digits = { 1, 2, 2 };

        StringBuilder str= new StringBuilder();
        recur(digits, 0, str);
    }
}