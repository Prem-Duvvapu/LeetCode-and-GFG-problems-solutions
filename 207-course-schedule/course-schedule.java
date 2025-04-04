class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> adjList=new ArrayList<>();

        for (int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for (int[] e: prerequisites) {
            int u=e[0];
            int v=e[1];
            //v->u
            adjList.get(v).add(u);
        }

        if (isCycle(adjList,n))
            return false;

        return true;
    }

    public boolean isCycle(List<List<Integer>> adjList,int n) {
        boolean[] visited=new boolean[n];
        boolean[] path=new boolean[n];

        for (int i=0;i<n;i++)
            if (!visited[i])
                if (dfs(i,visited,path,adjList,n))
                    return true;

        return false;
    }

    public boolean dfs(int node,boolean[] visited,boolean[] path,List<List<Integer>> adjList,int n) {
        visited[node]=true;
        path[node]=true;

        for (int ngbr: adjList.get(node)) {
            if (!visited[ngbr]) {
                if (dfs(ngbr,visited,path,adjList,n))
                    return true;
            } else if (path[ngbr]) {
                return true;
            }
        }

        path[node]=false;
        return false;
    }
}

/*
numCourses

0 to numCourses-1

[a,b]
b->a

2
0,1

[1,0]
0->1 true

2
0,1
[1,0],[0,1]
0->1
1->0

false

0->1
^   |
|   >2
3<----

visited[] = [1, 1, 1, 1]
             0  1  2  3

path[] = [1, 1, 1, 1]
          0  1  2  3
return true


*/