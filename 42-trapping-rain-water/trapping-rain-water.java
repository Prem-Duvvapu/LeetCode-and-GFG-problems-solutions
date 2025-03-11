class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int res=0;
        int[] rightMax=new int[n];
        int leftMax=0;

        rightMax[n-1]=height[n-1];
        for (int i=n-2;i>=0;i--)
            rightMax[i]=Math.max(height[i],rightMax[i+1]);

        for (int i=0;i<n-1;i++) {
            if (height[i]<leftMax && height[i]<rightMax[i+1])
                res+=(Math.min(leftMax,rightMax[i+1])-height[i]);

            leftMax=Math.max(leftMax,height[i]);
        }

        return res;
    }
}