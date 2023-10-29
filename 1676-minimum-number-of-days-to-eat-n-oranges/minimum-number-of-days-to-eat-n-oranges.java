//Memoization
class Solution {
    Map<Integer,Integer> map;
    public int minDays(int n) {
        map=new HashMap<>();
        return (int)solve(n);
    }

    private int solve(int n)
    {
        int ans=Integer.MAX_VALUE;
        
        if (n<=2)
            return n;

        if (map.containsKey(n))
            return map.get(n);

        else if (n%6==0)
            ans=Math.min(ans,1+Math.min(solve(n/2),solve(n/3)));
        else if (n%3==0)
            ans=Math.min(ans,1+Math.min(solve(n-1),solve(n/3)));
        else if (n%2==0)
        {
            if ((n-1)%3==0)
                ans=Math.min(ans,1+Math.min(solve(n/2),solve(n-1)));
            else
                ans=Math.min(ans,1+Math.min(solve(n/2),1+solve(n-2)));
        }
        else
            ans=Math.min(ans,1+solve(n-1));

        map.put(n,ans);

        return ans;
    }
}