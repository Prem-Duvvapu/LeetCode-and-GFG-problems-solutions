class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int totalMaxArea=0;
        int[] arr=new int[n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (i==0) {
                    arr[j]=matrix[i][j]-'0';
                } else {
                    if (matrix[i][j]=='0')
                        arr[j]=0;
                    else
                        arr[j]=1+arr[j];
                }
            }

            int currMaxArea=largestRectangleArea(arr);
            totalMaxArea=Math.max(currMaxArea,totalMaxArea);
        }

        return totalMaxArea;
    }

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