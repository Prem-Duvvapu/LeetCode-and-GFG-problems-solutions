class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        SortedSet<Integer> set=new TreeSet<>();
        for (int val: nums)
            set.add(val);
        
        for (int i=0;i<moveFrom.length;i++)
        {
            set.remove(new Integer(moveFrom[i]));
            set.add(moveTo[i]);
        }

        return new ArrayList<Integer>(set);
    }
}