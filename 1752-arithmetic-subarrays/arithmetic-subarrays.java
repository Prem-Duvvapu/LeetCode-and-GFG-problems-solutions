class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n=nums.length;
        int m=l.length;
        List<Boolean> res=new ArrayList<>();

        for (int i=0;i<m;i++) {
            int minVal=Integer.MAX_VALUE;
            int maxVal=Integer.MIN_VALUE;
            Set<Integer> set=new HashSet<>();

            for (int j=l[i];j<=r[i];j++) {
                minVal=Math.min(minVal,nums[j]);
                maxVal=Math.max(maxVal,nums[j]);
                set.add(nums[j]);
            }

            if ((maxVal-minVal)%(r[i]-l[i])!=0) {
                res.add(false);
                continue;
            }

            int d=(maxVal-minVal)/(r[i]-l[i]);
            int curr=minVal+d;
            boolean flag=true;
            while (curr<maxVal) {
                if (!set.contains(curr)) {
                    res.add(false);
                    flag=false;
                    break;
                }
                curr+=d;
            }

            if (flag)
                res.add(true);
        }

        return res;
    }
}