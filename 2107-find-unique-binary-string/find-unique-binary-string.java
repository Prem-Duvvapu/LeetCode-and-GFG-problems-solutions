class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        Set<String> set=new HashSet<>();
        for (String s: nums)
            set.add(s);

        return solve(0,new StringBuilder(),n,set);
    }

    private String solve(int pos,StringBuilder sb,int n,Set<String> set)
    {
        if (pos==n)
        {
            if (!set.contains(sb.toString()))
                return sb.toString();

            return "";
        }

        sb.append('0');
        String a=solve(pos+1,sb,n,set);
        sb.deleteCharAt(pos);
        if (a.length()>0)
            return a;
        
        sb.append('1');
        String b=solve(pos+1,sb,n,set);
        sb.deleteCharAt(pos);
        if (b.length()>0)
            return b;

        return "";
    }
}