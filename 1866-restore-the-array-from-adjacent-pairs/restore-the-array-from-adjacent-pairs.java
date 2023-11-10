//refer single number iii
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n=adjacentPairs.length+1;
        int[] arr=new int[n];
        int start=0;
        int end=0;
        int diff=0;

        for (int[] a: adjacentPairs)
            diff^=(a[0]^a[1]);

        System.out.println(diff);

        //to find the right most different bit
        diff&=(-diff);

        System.out.println(diff);

        for (int[] a: adjacentPairs)
        {
            if ((diff&a[0])>0)
                start^=a[0];
            else
                end^=a[0];
            if ((diff&a[1])>0)
                start^=a[1];
            else
                end^=a[1];
        }

        Map<Integer,List<Integer>> graph=new HashMap<>();
        for (int[] a: adjacentPairs)
        {
            graph.put(a[0],new ArrayList<>());
            graph.put(a[1],new ArrayList<>());
        }

        for (int[] a: adjacentPairs)
        {
            graph.get(a[0]).add(a[1]);
            graph.get(a[1]).add(a[0]);
        }

        List<Integer> res=new ArrayList<>();
        dfs(start,graph,n,res,new HashSet<>());

        for (int i=0;i<n;i++)
            arr[i]=res.get(i);

        return arr;
    }

    private void dfs(int curr,Map<Integer,List<Integer>> graph,int v,List<Integer> res,Set<Integer> set)
    {
        res.add(curr);
        set.add(curr);

        for (int i=0;i<graph.get(curr).size();i++)
        {
            if (!set.contains(graph.get(curr).get(i)))
                dfs(graph.get(curr).get(i),graph,v,res,set);
        }
    }
}