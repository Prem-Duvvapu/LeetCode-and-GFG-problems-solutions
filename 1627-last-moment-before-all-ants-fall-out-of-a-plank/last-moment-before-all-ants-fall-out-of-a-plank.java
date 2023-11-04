class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        int ans=0;
        if (left.length>0)
            ans=Math.max(ans,left[left.length-1]);
        if (right.length>0)
            ans=Math.max(ans,n-right[0]);

        return ans;
    }
}