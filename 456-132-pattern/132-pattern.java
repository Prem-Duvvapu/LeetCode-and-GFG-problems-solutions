class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length<3)
            return false;

        int n=nums.length;
        Stack<Integer> stack=new Stack<>();
        int[] leftMin=new int[n];
        leftMin[0]=nums[0];

        for (int i=1;i<n;i++)
            leftMin[i]=Math.min(nums[i],leftMin[i-1]);

        for (int i=n-1;i>0;i--)
        {
            if (nums[i]>leftMin[i-1]) // middle>left
            {
                //right is not greater than leftMin
                while (!stack.isEmpty() && stack.peek()<=leftMin[i-1])
                    stack.pop();

                //right>leftMin and middle>right
                if (!stack.isEmpty() && nums[i]>stack.peek())
                    return true;

                stack.push(nums[i]);
            }
        }
        return false;
    }
}

//TC: O(n)
//SC: O(n)