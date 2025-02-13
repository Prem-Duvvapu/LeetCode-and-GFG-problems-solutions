class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        PriorityQueue<Long> pq=new PriorityQueue<>((a, b) -> Long.compare(a, b));
        int res=0;

        for (int i=0;i<n;i++)
            pq.add((long)nums[i]);

        while (pq.size()!=1) {
            if (pq.peek()>=(long)k)
                break;

            long x=pq.poll();
            long y=pq.poll();
            long newElement=Math.min(x,y)*2+Math.max(x,y);
            res++;

            pq.add(newElement);
        }

        return res;
    }
}