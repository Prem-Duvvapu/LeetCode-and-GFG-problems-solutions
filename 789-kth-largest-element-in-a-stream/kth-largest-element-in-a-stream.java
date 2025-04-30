class KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>((a,b) -> Integer.compare(a,b)); //min heap

        for (int val: nums)
            pq.add(val);
    }
    
    public int add(int val) {
        pq.add(val);

        while (pq.size()>k)
            pq.poll();

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */