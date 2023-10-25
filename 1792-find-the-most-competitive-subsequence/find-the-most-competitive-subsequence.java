//Monotonic stack
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[k];
        int j=-1;

        for (int i=0;i<n;i++)
        {
            while (j!=-1 && res[j]>nums[i] && (j+n-i)>=k)
                j--;

            if (j<k-1)
                res[++j]=nums[i];
        }

        return res;
    }
}

