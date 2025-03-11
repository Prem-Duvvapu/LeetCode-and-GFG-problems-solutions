class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();

        for (int i=n-2;i>=0;i--) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
            } else {
                while (!stack.isEmpty() && stack.peek()<=nums[i])
                    stack.pop();

                stack.push(nums[i]);
            }
        }

        for (int i=n-1;i>=0;i--) {
            while (!stack.isEmpty() && stack.peek()<=nums[i])
                stack.pop();

            if (stack.isEmpty())
                res[i]=-1;
            else
                res[i]=stack.peek();

            stack.push(nums[i]);
        }

        return res;
    }
}