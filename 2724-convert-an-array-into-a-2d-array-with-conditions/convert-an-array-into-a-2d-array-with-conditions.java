class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();

        for (int val: nums) {
            if (!map.containsKey(val))
                map.put(val,0);

            map.put(val,map.get(val)+1);
        }

        while (map.size()>0) {
            List<Integer> curr=new ArrayList<>();
            Map<Integer,Integer> temp=new HashMap<>();
            temp.putAll(map);
            for (Map.Entry<Integer,Integer> m: temp.entrySet()) {
                curr.add(m.getKey());
                if (m.getValue()==1)
                    map.remove(m.getKey());
                else
                    map.put(m.getKey(),m.getValue()-1);
            }
            res.add(curr);
        }

        return res;
    }
}