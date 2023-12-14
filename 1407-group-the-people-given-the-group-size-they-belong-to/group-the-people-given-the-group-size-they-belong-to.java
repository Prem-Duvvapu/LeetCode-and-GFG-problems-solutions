class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n=groupSizes.length;
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i=0;i<n;i++)
        {
            int currSize=groupSizes[i];
            List<Integer> currList=map.getOrDefault(currSize,new ArrayList<>());
            currList.add(i);
            map.put(currSize,currList);
            if (currList.size()==currSize)
            {
                res.add(currList);
                map.put(currSize,new ArrayList<>());
            }
        }

        return res;
    }
}