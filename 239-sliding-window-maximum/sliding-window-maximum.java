class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer> q=new ArrayDeque<>();

        for (int i=0;i<n;i++) {
            //1. remove out of bound indexes from front
            while (!q.isEmpty() && q.peekFirst()<(i-k+1))
                q.removeFirst();

            //2. add current index at the last accordingly
            while (!q.isEmpty() && nums[q.peekLast()]<=nums[i])
                q.removeLast();
            q.add(i);

            //3. front element is our ans
            if (i>=(k-1))
                res[i-k+1]=nums[q.peekFirst()];
        }

        return res;
    }
}

