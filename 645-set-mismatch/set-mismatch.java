class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        boolean[] visited=new boolean[n+1];
        int[] res=new int[2];

        for (int val: nums) {
            if (visited[val])
                res[0]=val;
            visited[val]=true;
        }

        for (int i=1;i<=n;i++)
            if (!visited[i])
                res[1]=i;

        return res;
    }
}