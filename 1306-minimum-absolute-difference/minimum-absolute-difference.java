class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n=arr.length;
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;

        for (int i=0;i<n-1;i++)
            minDiff=Math.min(arr[i+1]-arr[i],minDiff);
        
        for (int i=0;i<n-1;i++)
        {
            if ((arr[i+1]-arr[i])==minDiff)
            {
                List<Integer> curr=new ArrayList<>();
                curr.add(arr[i]);
                curr.add(arr[i+1]);
                res.add(curr);
            }
        }

        return res;
    }
}