class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int[] arr=new int[nums.length];
        for (int i=0;i<arr.length;i++)
            arr[i]=nums[i];

        for (int i=0;i<arr.length;i++)
        {
            int val=Math.abs(arr[i]);
            if (arr[val-1]>0)
                arr[val-1]*=-1;
        }

        for (int i=0;i<arr.length;i++)
        {
            if (arr[i]>0)
                res.add(i+1);
        }

        return res;
    }
}