class Solution
{
    public int maxArea(int[] height)
    {
        int n=height.length;
        int leftIndex=0;
        int rightIndex=n-1;
        int maxArea=0;

        while (leftIndex<rightIndex)      
        {
            int currArea=(rightIndex-leftIndex)*Math.min(height[leftIndex],height[rightIndex]);
            if (currArea>maxArea)
                maxArea=currArea;
            
            if (height[leftIndex]<height[rightIndex])
                leftIndex++;
            else if (height[rightIndex]<height[leftIndex])
                rightIndex--;
            else
            {
                leftIndex++;
                rightIndex--;
            }
        }

        return maxArea;
    }
}