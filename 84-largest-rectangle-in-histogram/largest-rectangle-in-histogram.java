class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && heights[stack.peek()]>heights[i]) {
                int height=heights[stack.pop()];
                int prevSmallerValIndex=stack.isEmpty() ? -1 : stack.peek();
                int width=i-prevSmallerValIndex-1;
                int currArea=height*width;

                maxArea=Math.max(maxArea,currArea);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height=heights[stack.pop()];
            int prevSmallerValIndex=stack.isEmpty() ? -1 : stack.peek();
            int width=n-prevSmallerValIndex-1;
            int currArea=height*width;

            maxArea=Math.max(maxArea,currArea);
        }

        return maxArea;
    }
}