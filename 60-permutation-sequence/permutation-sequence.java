class Solution {
    public String getPermutation(int n, int k) {
        List<Character> list=new ArrayList<>();
        for (int i=1;i<=n;i++)
            list.add((char)(i+'0'));
        int fact=1;
        for (int i=1;i<n;i++)
            fact*=i;
        StringBuilder sb=new StringBuilder();
        k=k-1;
        for (int i=n-1;i>0;i--)
        {
            int index=k/fact;
            sb.append(list.get(index));
            list.remove(index);
            k=k%fact;
            fact=fact/i;
        }
        sb.append(list.get(0));
        return sb.toString();
    }
}