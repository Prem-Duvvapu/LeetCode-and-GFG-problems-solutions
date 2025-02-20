class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        Set<String> set=new HashSet<>();
        String[] res=new String[1];

        for (String s: nums)
            set.add(s);

        solve(new StringBuilder(),n,res,set);

        return res[0];
    }

    private boolean solve(StringBuilder curr,int n,String[] res,Set<String> set) {
        if (curr.length()==n) {
            String s=new String(curr);
            
            if (!set.contains(s)) {
                res[0]=s;
                return true;
            }

            return false;
        }

        curr.append('0');
        if (solve(curr,n,res,set))
            return true;
        curr.deleteCharAt(curr.length()-1);

        curr.append('1');
        if (solve(curr,n,res,set))
            return true;
        curr.deleteCharAt(curr.length()-1);

        return false;
    }
}