class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] pse=new int[n];
        int[] nse=new int[n];
        int maxArea=0;

        prevSmallerElement(heights,n,pse);
        nextSmallerElement(heights,n,nse);

        for (int i=0;i<n;i++) {
            int height=heights[i];
            int width=(i-pse[i])+(nse[i]-i-1);

            int currArea=width*height;
            maxArea=Math.max(maxArea,currArea);
        }

        return maxArea;
    }

    public void prevSmallerElement(int[] arr,int n,int[] res) {
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();

            if (stack.isEmpty())
                res[i]=-1;
            else
                res[i]=stack.peek();

            stack.push(i);
        }
    }

    public void nextSmallerElement(int[] arr,int n,int[] res) {
        Stack<Integer> stack=new Stack<>();

        for (int i=n-1;i>=0;i--) {
            while (!stack.isEmpty() && arr[stack.peek()]>arr[i])
                stack.pop();

            if (stack.isEmpty())
                res[i]=n;
            else
                res[i]=stack.peek();

            stack.push(i);
        }
    }

}