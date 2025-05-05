class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        Map<Integer,Integer> map=new HashMap<>();

        for (int val: nums)
            map.put(val,map.getOrDefault(val,0)+1);

        PriorityQueue<Integer> pq=new PriorityQueue<>((x,y) -> Integer.compare(map.get(y),map.get(x)));
        for (int val: map.keySet())
            pq.add(val);

        int pos=0;
        while (pos<k) {
            res[pos]=pq.poll();
            pos++;
        }

        return res;
    }
}