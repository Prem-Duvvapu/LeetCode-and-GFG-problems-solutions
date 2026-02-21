class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && heights[stack.peek()]>heights[i]) {
                maxArea = findMaxArea(heights, stack, i, maxArea);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            maxArea = findMaxArea(heights, stack, n, maxArea);
        }

        return maxArea;
    }

    private int findMaxArea(int[] heights, Stack<Integer> stack, int val, int maxArea) {
        int height=heights[stack.pop()];
        int pse=stack.isEmpty() ? -1 : stack.peek();
        int nse=val;
        int width=nse-pse-1;
        int currArea=height*width;

        return Math.max(maxArea, currArea);
    }
}