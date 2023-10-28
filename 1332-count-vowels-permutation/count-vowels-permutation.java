//Recursion
class Solution {
    int mod=(int)(1e9)+7;
    Map<Character,List<Character>> map=new HashMap<>();

    public int countVowelPermutation(int n) {
        char[] a={'#','a','e','i','o','u'};

        for (char ch: a)
            map.put(ch,new ArrayList<>());

        List<Character> allList=Arrays.asList('a','e','i','o','u');
        List<Character> aList=Arrays.asList('e');
        List<Character> eList=Arrays.asList('a','i');
        List<Character> iList=Arrays.asList('a','e','o','u');
        List<Character> oList=Arrays.asList('i','u');
        List<Character> uList=Arrays.asList('a');

        map.get('#').addAll(allList);
        map.get('a').addAll(aList);
        map.get('e').addAll(eList);
        map.get('i').addAll(iList);
        map.get('o').addAll(oList);
        map.get('u').addAll(uList);

        int[][] dp=new int[100][n];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);

        return solve('#','#'-'#',0,n,dp);
    }

    private int solve(char last,int val,int pos,int n,int[][] dp)
    {
        if (pos==n)
            return 1;

        if (dp[val][pos]!=-1)
            return dp[val][pos];

        List<Character> list=map.get(last);
        int cnt=0;
        for (char ch: list)
            cnt=(cnt+solve(ch,ch-'#',pos+1,n,dp))%mod;

        return dp[val][pos]=cnt%mod;
    }
}