class Solution {
    private boolean helper(int[] arr,int curr,boolean[] visited)
    {
        if (curr<0 || curr>=arr.length || visited[curr])
            return false;

        if (arr[curr]==0)
            return true;

        visited[curr]=true;

        boolean left=helper(arr,curr-arr[curr],visited);
        boolean right=helper(arr,curr+arr[curr],visited);

        return (left || right);
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] visited=new boolean[arr.length];
        return helper(arr,start,visited);
    }
}