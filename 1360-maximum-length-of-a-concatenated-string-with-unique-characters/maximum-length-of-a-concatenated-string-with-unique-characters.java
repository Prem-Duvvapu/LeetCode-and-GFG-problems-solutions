class Solution {
    public int maxLength(List<String> arr) {
        int n=arr.size();
        boolean[] visited=new boolean[26];
        return solve(n-1,visited,arr);
    }

    private int solve(int pos, boolean[] visited, List<String> arr) {
        if (pos<0)
            return 0;

        int notPick=0+solve(pos-1,visited,arr);
        int pick=0;
        boolean flag=true;
        
        for (char ch: arr.get(pos).toCharArray())
            if (visited[ch-'a'])
                flag=false;

        boolean[] temp=new boolean[26];
        for (char ch: arr.get(pos).toCharArray()) {
            if (temp[ch-'a']) {
                flag=false;
                break;
            }
            temp[ch-'a']=true;
        }

        if (flag) {
            for (char ch: arr.get(pos).toCharArray())
                visited[ch-'a']=true;

            pick=arr.get(pos).length()+solve(pos-1,visited,arr);

            for (char ch: arr.get(pos).toCharArray())
                visited[ch-'a']=false;
        }

        return Math.max(pick,notPick);
    }
}