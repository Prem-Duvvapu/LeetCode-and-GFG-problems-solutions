//Decreasing monotonic Stack
//Iterate through the nums array two times because the -1 values got in first iteration for result array can be replaced with its highest previous values in the nums array if exist by iterating starting from the first second time.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> mStack=new Stack<>();

        for (int i=0;i<2*n;i++)
        {
            int val=nums[i%n];

            while (!mStack.isEmpty() && val>nums[mStack.peek()])
            {
                int index=mStack.pop();
                res[index]=val;
            }

            if(i<n)
                mStack.push(i);
        }

        return res;
    }
}