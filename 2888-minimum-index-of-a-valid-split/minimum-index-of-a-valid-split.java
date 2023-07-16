class Solution {
    public int minimumIndex(List<Integer> nums) {
        int res=0;
        int n=nums.size();
        int dominant=nums.get(0);
        int cnt=1;
        for (int i=1;i<n;i++)
        {
            if (nums.get(i)==dominant)
                    cnt++;
            else if (cnt==0)
                dominant=nums.get(i);
            else
                    cnt--;
        }
        
        int dCnt=0;
        for (int val: nums)
                if (val==dominant)
                        dCnt++;
        
        int preCnt=0;
        for (int i=0;i<n;i++)
        {
            if (nums.get(i)==dominant)
                preCnt++;
            if (preCnt*2>(i+1) && (dCnt-preCnt)*2>(n-1-i))
                    return i;
        }
        return -1;
    }
}