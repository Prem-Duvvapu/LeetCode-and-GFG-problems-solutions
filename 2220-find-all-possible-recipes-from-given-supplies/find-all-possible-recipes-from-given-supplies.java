class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n=recipes.length;
        List<String> res=new ArrayList<>();
        Set<String> suppliesSet=new HashSet<>();
        Map<String,List<Integer>> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[n];

        for (String supply: supplies)
            suppliesSet.add(supply);

        for (int i=0;i<n;i++) {
            boolean flag=true;
            for (String ingredient: ingredients.get(i)) {
                if (!suppliesSet.contains(ingredient)) {
                    flag=false;
                    List<Integer> list=map.getOrDefault(ingredient,new ArrayList<>());
                    list.add(i);
                    map.put(ingredient,list);
                    indegree[i]++;
                }
            }

            if (flag)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int curr=q.poll();
            if (map.containsKey(recipes[curr])) {
                for (int index: map.get(recipes[curr])) {
                    indegree[index]--;
                    if (indegree[index]==0)
                        q.add(index);
                }
            }
        }

        for (int i=0;i<n;i++)
            if (indegree[i]==0)
                res.add(recipes[i]);

        return res;
    }
}