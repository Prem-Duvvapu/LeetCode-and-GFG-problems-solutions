class Pair implements Comparable<Pair> {
    private int key;
    private int value;

    Pair(int key,int value) {
        this.key=key;
        this.value=value;
    }

    public int getKey() {
        return key;
    }

    public int compareTo(Pair that) {
        if (this.value<that.value)
            return 1;

        return -1;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[k];
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();

        for (int val: nums)
            map.put(val,map.getOrDefault(val,0)+1);

        for (Map.Entry<Integer,Integer> m: map.entrySet()) {
            Pair p=new Pair(m.getKey(),m.getValue());
            pq.add(p);
        }

        for (int i=0;i<k;i++)
            res[i]=pq.poll().getKey();

        return res;
    }
}