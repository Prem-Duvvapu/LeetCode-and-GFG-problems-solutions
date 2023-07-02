class Solution {
    int ans=0;

    private void helper(int position,int[][] requests,int curr,int[] netChange)
    {
        if (position==requests.length)
        {
            for (int val: netChange)
                if (val!=0)
                    return;

            ans=Math.max(curr,ans);
            return;
        }

        //don't consider the request
        helper(position+1,requests,curr,netChange);

        //consider the request
        int from=requests[position][0];
        int to=requests[position][1];
        netChange[from]--;
        netChange[to]++;

        helper(position+1,requests,curr+1,netChange);

        netChange[from]++;
        netChange[to]--;
    }

    public int maximumRequests(int n, int[][] requests) {
        helper(0,requests,0,new int[n]);
        return ans;
    }
}