//toposort(dfs)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited=new boolean[numCourses];
        boolean[] path=new boolean[numCourses];
        List<List<Integer>> adjList=new ArrayList<>();

        for (int i=0;i<numCourses;i++)
            adjList.add(new ArrayList<>());

        for (int[] e: prerequisites)
            adjList.get(e[1]).add(e[0]);

        for (int i=0;i<numCourses;i++)
            if (!visited[i])
                if (!dfs(i,visited,path,numCourses,adjList))
                    return false;

        return true;
    }

    public boolean dfs(int curr,boolean[] visited,boolean[] path,int numCourses,List<List<Integer>> adjList) {
        visited[curr]=true;
        path[curr]=true;

        for (int neighbour: adjList.get(curr)) {
            if (!visited[neighbour]) {
                if (!dfs(neighbour,visited,path,numCourses,adjList))
                    return false;
            } else if (path[neighbour]){
                return false;
            }
        }

        path[curr]=false;
        return true;
    }
}