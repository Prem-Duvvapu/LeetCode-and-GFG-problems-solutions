class Solution {
    public int findKthLargest(int[] nums, int k) {
        int kle=0;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for (int val: nums)
        {
            if (minHeap.size()<=k)
                minHeap.add(val);
            
            if (minHeap.size()>k)
                minHeap.poll();
        }

        return minHeap.peek();
    }
}