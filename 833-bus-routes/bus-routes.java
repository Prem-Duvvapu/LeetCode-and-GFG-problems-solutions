//BFS
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source==target)
            return 0;

        Map<Integer,List<Integer>> map=new HashMap<>();

        for (int i=0;i<routes.length;i++)
        {
            for (int j=0;j<routes[i].length;j++)
            {
                if (!map.containsKey(routes[i][j]))
                    map.put(routes[i][j],new ArrayList<>());
                map.get(routes[i][j]).add(i);
            }
        }

        int busCount=1;
        Queue<Integer> q=new ArrayDeque<>();
        boolean[] visited=new boolean[routes.length];
        for (int val: map.get(source))
        {
            q.add(val);
            visited[val]=true;
        }

        while (!q.isEmpty())
        {
            int qlen=q.size();

            while (qlen-- > 0)
            {
                int curr=q.poll();
                for (int route: routes[curr])
                {
                    if (route==target)
                        return busCount;

                    for (int val: map.get(route))
                    {
                        if (!visited[val])
                        {
                            q.add(val);
                            visited[val]=true;
                        }
                    }
                }
            }

            busCount++;
        }

        return -1;
    }
}