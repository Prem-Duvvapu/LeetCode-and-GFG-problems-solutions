class Solution {
    public long minimumPossibleSum(int n, int target) {
        Set<Integer> set=new HashSet<>();
        long sum=0;
        int val=1;

        while (set.size()!=n)
        {
            if (!set.contains(target-val))
            {
                sum+=val;
                set.add(val);
            }
            val++;
        }

        return sum;
    }
}