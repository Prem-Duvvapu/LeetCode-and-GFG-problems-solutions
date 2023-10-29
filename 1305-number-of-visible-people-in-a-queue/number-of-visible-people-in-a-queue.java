//Monotonic Decreasing stack
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack();

        for (int i=0;i<n;i++)
        {
            while (!stack.isEmpty() && heights[stack.peek()]<=heights[i])
                res[stack.pop()]++;
            
            if (!stack.isEmpty())
                res[stack.peek()]++;

            stack.push(i);
        }

        return res;
    }
}