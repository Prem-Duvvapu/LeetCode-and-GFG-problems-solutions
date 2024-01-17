class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();

        for (int val: arr)
            map.put(val,map.getOrDefault(val,0)+1);
        
        for (Map.Entry<Integer,Integer> m: map.entrySet()) {
            if (set.contains(m.getValue()))
                return false;
            set.add(m.getValue());
        }

        return true;
    }
}