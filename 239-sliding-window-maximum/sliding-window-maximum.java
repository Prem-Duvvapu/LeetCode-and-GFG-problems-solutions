//Consider a double ended stack where you can perform push,pop,peek at front and back(deque in java)
//and it should be a decreasing monotonic stack

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer> q=new ArrayDeque<>();

        for (int i=0;i<n;i++) {
            while (!q.isEmpty() && i-q.peekFirst()>=k)
                q.removeFirst();

            while (!q.isEmpty() && nums[q.peekLast()]<=nums[i])
                q.removeLast();

            q.add(i);
            
            if (i>=(k-1))
                res[i-k+1]=nums[q.peekFirst()];
        }

        return res;
    }
}