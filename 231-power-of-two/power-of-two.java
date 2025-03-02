class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0)
            return false;

        int cnt=0;
        for (int i=0;i<32;i++)
            cnt+=((n>>i)&1);

        return (cnt==1);
    }
}