class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n=groupSizes.length;
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i=0;i<n;i++)
        {
            int currSize=groupSizes[i];
            if (!map.containsKey(currSize))
                map.put(currSize,new ArrayList<>());

            map.get(currSize).add(i);
            if (map.get(currSize).size()==currSize)
            {
                res.add(map.get(currSize));
                map.put(currSize,new ArrayList<>());
            }
        }

        return res;
    }
}