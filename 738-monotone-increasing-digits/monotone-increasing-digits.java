class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s=Integer.toString(n);
        int len=s.length();
        int[] nums=new int[len];
        int toNineFrom=len;
        int res=0;

        for (int i=0;i<len;i++)
            nums[i]=s.charAt(i)-'0';

        for (int i=len-1;i>0;i--)
        {
            if (nums[i]<nums[i-1])
            {
                nums[i-1]-=1;
                toNineFrom=i;
            }
        }

        for (int j=toNineFrom;j<len;j++)
            nums[j]=9;

        for (int i=0;i<len;i++)
            res=res*10+nums[i];
        
        return res;
    }
}