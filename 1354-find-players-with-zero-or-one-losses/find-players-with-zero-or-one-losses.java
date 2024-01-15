class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n=matches.length;
        Map<Integer,Integer> map=new HashMap<>();
        List<List<Integer>> res=new ArrayList<>();
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        for (int i=0;i<n;i++)
            map.put(matches[i][1],map.getOrDefault(matches[i][1],0)+1);

        for (int i=0;i<n;i++) {
            if (map.containsKey(matches[i][1])) {
                if (map.get(matches[i][1])==1)
                    set2.add(matches[i][1]);
            }
            
            if (!map.containsKey(matches[i][0]))
                set1.add(matches[i][0]);
        }

        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();

        for (int val: set1)
            l1.add(val);

        for (int val: set2)
            l2.add(val);

        Collections.sort(l1);
        Collections.sort(l2);

        res.add(l1);
        res.add(l2);

        return res;
    }
}