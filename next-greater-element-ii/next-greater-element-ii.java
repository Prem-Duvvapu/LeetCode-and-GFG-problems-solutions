class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,1000000001);
        Stack<Integer> mStack=new Stack<>();

        for (int i=0;i<n;i++)
        {
            while (!mStack.isEmpty() && nums[i]>nums[mStack.peek()])
            {
                int index=mStack.pop();
                res[index]=nums[i];
            }
            mStack.push(i);
        }

        for (int i=0;i<n;i++)
        {
            if (res[i]==1000000001)
            {
                int j=0;
                for (;j<i;j++)
                {
                    if (nums[j]>nums[i])
                    {
                        res[i]=nums[j];
                        break;
                    }
                }
                if (j==i)
                    res[i]=-1;
            }
        }

        return res;
    }
}