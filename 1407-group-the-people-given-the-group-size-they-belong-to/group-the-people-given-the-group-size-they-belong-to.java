class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n=groupSizes.length;
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i=0;i<n;i++)
        {
            int curr=groupSizes[i];
            if (!map.containsKey(curr))
                map.put(curr,new ArrayList<>());

            map.get(curr).add(i);
        }

        for (Map.Entry<Integer,List<Integer>> m: map.entrySet())
        {
            int currSize=m.getKey();
            List<Integer> currList=m.getValue();
            for (int i=0;i<currList.size();i+=currSize)
            {
                List<Integer> temp=new ArrayList<>();
                for (int j=i;j<i+currSize;j++)
                    temp.add(currList.get(j));
                res.add(temp);
            }
        }

        return res;
    }
}