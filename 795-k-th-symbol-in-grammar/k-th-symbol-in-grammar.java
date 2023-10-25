//Binary Search
class Solution {
    public int kthGrammar(int n, int k) {
        return solve(0,(int)Math.pow(2,n-1)-1,0,n,k-1);
    }

    private int solve(int low,int high,int prev,int n,int k)
    {
        if (low==high)
            return prev;

        int mid=low+(high-low)/2;

        if (k<=mid)
            return solve(low,mid,prev,n,k);
        
        return solve(mid+1,high,(prev ^ 1),n,k);
    }
}