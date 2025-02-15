class Solution {
    public int punishmentNumber(int n) {
        int sum=0;

        for (int i=1;i<=n;i++) {
            if (solve(i))
                sum+=(i*i);
        }

        return sum;
    }

    public boolean solve(int i) {
        int product=i*i;

        String s=Integer.toString(product);
        return solve2(s,0,s.length()-1,i);
    }

    public boolean solve2(String s,int left,int right,int num) {
        if (left>right)
            return false;

        if (Integer.parseInt(s.substring(left,right+1))==num)
            return true;

        for (int i=left;i<=right;i++) {
            int rem=Integer.parseInt(s.substring(left,i+1));
            if (solve2(s,i+1,right,num-rem))
                return true;
        }

        return false;
    }
}