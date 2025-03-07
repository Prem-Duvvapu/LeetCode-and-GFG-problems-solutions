//Time:O(n*sqrt(n))
//Space:O(1)

class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] res=new int[2];
        int minDiff=(int)1e7;
        Arrays.fill(res,-1);

        int last=-1;
        
        //O(n)
        for (int i=left;i<=right;i++) {
            if (isPrime(i)) {
                if (last!=-1 && i-last<minDiff) {
                    res[0]=last;
                    res[1]=i;
                    minDiff=i-last;
                }

                last=i;
            }
        }

        return res;
    }

    //O(sqrt(n))
    public boolean isPrime(int n) {
        if (n==1)
            return false;

        for (int i=2;i<=(int)Math.sqrt(n);i++) {
            if (n%i==0)
                return false;
        }

        return true;
    }
}