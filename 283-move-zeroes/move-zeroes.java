//brute forece
//T.C. : O(2*n)
//S.C. : O(n)
class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        List<Integer> temp=new ArrayList<>();

        for (int i=0;i<n;i++)
            if (nums[i]!=0)
                temp.add(nums[i]);

        for (int i=0;i<temp.size();i++)
            nums[i]=temp.get(i);

        int j=temp.size();
        while (j<n)
            nums[j++]=0;
    }
}