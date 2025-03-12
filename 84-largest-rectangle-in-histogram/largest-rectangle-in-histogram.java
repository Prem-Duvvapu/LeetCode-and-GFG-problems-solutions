class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && heights[stack.peek()]>heights[i]) {
                int height=heights[stack.pop()];
                int pse=stack.isEmpty() ? -1 : stack.peek();
                int nse=i;
                int width=nse-pse-1;
                int currArea=height*width;

                maxArea=Math.max(maxArea,currArea);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height=heights[stack.pop()];
            int pse=stack.isEmpty() ? -1 : stack.peek();
            int nse=n;
            int width=nse-pse-1;
            int currArea=height*width;

            maxArea=Math.max(maxArea,currArea);
        }

        return maxArea;
    }
}