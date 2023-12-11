class Solution {
    public int findSpecialInteger(int[] arr) {
        int n=arr.length;
        int cnt=1;
        
        for (int i=1;i<n;i++)
        {
            if (arr[i]==arr[i-1])
            {
                cnt++;
                if (cnt>n/4)
                    return arr[i];
            }
            else
                cnt=1;
        }

        return arr[0];
    }
}