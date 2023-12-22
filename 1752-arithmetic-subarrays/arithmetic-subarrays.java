class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res=new ArrayList<>();
        for (int i=0;i<l.length;i++) {
            List<Integer> temp=new ArrayList<>();
            for (int j=l[i];j<=r[i];j++) {
                temp.add(nums[j]);
            }
            Collections.sort(temp);
            boolean flag=true;
            int diff=temp.get(1)-temp.get(0);
            for (int k=2;k<temp.size();k++) {
                if (temp.get(k)-temp.get(k-1)!=diff) {
                    res.add(false);
                    flag=false;
                    break;
                }
            }
            if (flag)
                res.add(true);
        }

        return res;
    }
}