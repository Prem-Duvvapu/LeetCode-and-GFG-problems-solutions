class Solution {
    String res="";

    public String getPermutation(int n, int k) {
        List<Character> l=new ArrayList<>();
        for (int i=0;i<n;i++)
            l.add((char)((i+1)+'0'));
        int fact=factorial(n);
        solve(n,k-1,l,fact);
        return res;
    }

    private void solve(int n,int k,List<Character> l,int fact) {
        if (n==1) {
            res+=l.get(0);
            return;
        }
        
        int x=fact/n; //each subset size
        int y=k/x; //index pos
        int z=k%x; //next k

        res+=l.get(y);
        l.remove(y);
        solve(n-1,z,l,fact/n);
    }

    private int factorial(int n) {
        if (n==1)
            return 1;

        return n * factorial(n-1);
    }
}