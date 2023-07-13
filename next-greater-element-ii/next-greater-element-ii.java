class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length; // get the length of the array nums
        int[] res = new int[n]; // create an array of size n to store the result
        Arrays.fill(res, -1); // fill the result array with -1 initially
        Deque<Integer> stack = new ArrayDeque<>(); // create a stack using ArrayDeque since its efficient
        
        // loop through the array twice, because we need to compare each element with every other element
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n]; // get the current element by taking modulus with n
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                // while stack is not empty and top element of stack is less than current element
                res[stack.pop()] = num; // update result array with current element for top element of stack
            }
            if (i < n) {
                stack.push(i); // push the current index onto the stack if i < n
            }
        }
        return res; // return the result array
    }
}