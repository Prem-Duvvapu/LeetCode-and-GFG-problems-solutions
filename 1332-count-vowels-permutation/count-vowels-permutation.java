//Recursion
class Solution {
    int mod=(int)(1e9)+7;
    Map<Character,List<Character>> map=new HashMap<>();

    public int countVowelPermutation(int n) {
        char[] a={'b','a','e','i','o','u'};

        for (char ch: a)
            map.put(ch,new ArrayList<>());

        List<Character> allList=Arrays.asList('a','e','i','o','u');
        List<Character> aList=Arrays.asList('e');
        List<Character> eList=Arrays.asList('a','i');
        List<Character> iList=Arrays.asList('a','e','o','u');
        List<Character> oList=Arrays.asList('i','u');
        List<Character> uList=Arrays.asList('a');

        map.get('b').addAll(allList);
        map.get('a').addAll(aList);
        map.get('e').addAll(eList);
        map.get('i').addAll(iList);
        map.get('o').addAll(oList);
        map.get('u').addAll(uList);

        int[][] dp=new int[22][n+1];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);

        return solve('b','b'-'a',n,dp);
    }

    private int solve(char last,int val,int pos,int[][] dp)
    {
        if (pos==0)
            return 1;

        if (dp[val][pos]!=-1)
            return dp[val][pos];

        List<Character> list=map.get(last);
        int cnt=0;
        for (char ch: list)
            cnt=(cnt+solve(ch,ch-'a',pos-1,dp))%mod;

        return dp[val][pos]=cnt%mod;
    }
}