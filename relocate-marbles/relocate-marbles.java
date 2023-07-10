class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set=new HashSet<>();
        for (int val: nums)
            set.add(val);
        
        for (int i=0;i<moveFrom.length;i++) //O(n)
        {
            set.remove(new Integer(moveFrom[i])); //O(1)
            set.add(moveTo[i]); //O(1)
        }

        List<Integer> res=new ArrayList<Integer>(set);
        Collections.sort(res); //O(nlogn);
        return res;
    }
}