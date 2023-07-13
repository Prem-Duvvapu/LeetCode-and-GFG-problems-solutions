//Decreasing monotonic Stack - all the elements in the stack are in decreasing order from bottom to top

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();

        for (int currIndex=0;currIndex<n;currIndex++)
        {
            while (!stack.isEmpty() && temperatures[currIndex]>temperatures[stack.peek()])
            {
                int pastIndex=stack.pop();
                res[pastIndex]=(currIndex-pastIndex);
            }
            stack.push(currIndex);
        }

        return res;
    }
}