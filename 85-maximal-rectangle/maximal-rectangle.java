class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] arr=new int[m];
        

        for (int j=0;j<m;j++)
            arr[j]=matrix[0][j]-'0';

        int maxArea=largestRectangleArea(arr);

        for (int i=1;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (matrix[i][j]=='0')
                    arr[j]=0;
                else
                    arr[j]++;
            }
            // System.out.println(Arrays.toString(arr));
            int currArea=largestRectangleArea(arr);
            maxArea=Math.max(maxArea,currArea);
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int maxArea=0;

        for (int i=1;i<=n;i++)
        {
            int curr=-1;
            if (i<n)
                curr=heights[i];

            while (!stack.isEmpty() && curr<=heights[stack.peek()])
            {
                int height=heights[stack.pop()];
                int width=i;
                if (!stack.isEmpty())
                    width=(i-stack.peek()-1);

                int currArea=width*height;
                maxArea=Math.max(maxArea,currArea);
            }

            stack.push(i);
        }

        return maxArea;
    }
}