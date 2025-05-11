class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        Stack<Integer> stack=new Stack<>();
        int res=0;

        for (int val: nums) {
            while (!stack.isEmpty() && stack.peek()>val) {
                stack.pop();
                res++;
            }
            
            if (stack.isEmpty() || stack.peek()<val)
                stack.push(val);
        }

        while (!stack.isEmpty()) {
            if (stack.pop()==0)
                continue;
            res++;
        }

        return res;
    }
}