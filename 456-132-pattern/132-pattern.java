class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        Stack<Integer> stack=new Stack<>();
        int[] leftMin=new int[n];
        leftMin[0]=nums[0];

        for (int i=1;i<n;i++)
            leftMin[i]=Math.min(nums[i],leftMin[i-1]);

        for (int i=n-1;i>0;i--)
        {
            //middle should be greater than left
            if (nums[i]>leftMin[i-1])
            {
                //right should be less than left
                while (!stack.isEmpty() && stack.peek()<=leftMin[i-1])
                    stack.pop();

                //right should be lesser than middle
                while (!stack.isEmpty() && stack.peek()<nums[i])
                    return true;

                stack.push(nums[i]);
            }
        }

        return false;
    }
}