class Solution {
    public long minimumSteps(String s) {
        int n=s.length();
        int last=0;
        long ans=0;
        
        for (int i=0;i<n;i++)
        {
            if (s.charAt(i)=='0')
            {
                ans+=(i-last);
                last++;
            }
        }
        
        return ans;
    }
}