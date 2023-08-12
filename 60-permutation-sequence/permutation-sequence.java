class Solution {
    private void solve(StringBuilder sb,List<Character> list,int val,int n,int fact)
    {
        if (n==0)
        {
            sb.append(list.get(0));
            return;
        }

        int index=val/fact;
        sb.append(list.get(index));
        list.remove(index);
        val=val%fact;
        solve(sb,list,val,n-1,fact/n);
    }

    public String getPermutation(int n, int k) {
        List<Character> list=new ArrayList<>();
        for (int i=1;i<=n;i++)
            list.add((char)(i+'0'));
        int fact=1;
        for (int i=1;i<=n;i++)
            fact*=i;
        StringBuilder sb=new StringBuilder();
        solve(sb,list,k-1,n-1,fact/n);
        return sb.toString();
    }
}