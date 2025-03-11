class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int res=0;
        int[] rightMax=new int[n];
        int leftMax=0;

        rightMax[n-1]=0;
        for (int i=n-2;i>=0;i--)
            rightMax[i]=Math.max(height[i+1],rightMax[i+1]);

        for (int i=0;i<n;i++) {
            if (height[i]<leftMax && height[i]<rightMax[i])
                res+=(Math.min(leftMax,rightMax[i])-height[i]);

            leftMax=Math.max(leftMax,height[i]);
        }

        return res;
    }
}