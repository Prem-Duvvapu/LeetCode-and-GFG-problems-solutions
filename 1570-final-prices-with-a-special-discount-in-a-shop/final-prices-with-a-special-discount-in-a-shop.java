//Montonic Increasing stack
class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++)
            res[i]=prices[i];

        for (int i=0;i<n;i++)
        {
            while (!stack.isEmpty() && prices[stack.peek()]>=prices[i])
                res[stack.pop()]-=prices[i];

            stack.push(i);
        }

        return res;
    }
}