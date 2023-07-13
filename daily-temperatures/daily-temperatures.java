//Decreasing monotonic Stack - elements in the stack are in decreasing order from bottom to top
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        Deque<Integer> s=new ArrayDeque<>();

        for (int currIndex=0;currIndex<n;currIndex++)
        {
            while (!s.isEmpty() && temperatures[currIndex]>temperatures[s.peek()])
            {
                int index=s.pop();
                res[index]=(currIndex-index);
            }
            s.push(currIndex);
        }

        return res;
    }
}