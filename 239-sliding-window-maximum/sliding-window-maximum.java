//Consider a double ended stack where you can perform push,pop,peek at front and back(deque in java)
//and it should be a decreasing monotonic stack

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer> q=new ArrayDeque<>();
        int right=0;

        while (right<k) {
            while (!q.isEmpty() && nums[q.peekLast()]<=nums[right])
                q.removeLast();
            q.addLast(right);
            right++;
        }

        while (right<n) {
            // System.out.println(right-k+" "+q);
            res[right-k]=nums[q.peekFirst()];
            while (!q.isEmpty() && right-q.peekFirst()>=k)
                q.removeFirst();

            while (!q.isEmpty() && nums[q.peekLast()]<=nums[right])
                q.removeLast();

            q.add(right);
            right++;
        }

        res[right-k]=nums[q.peekFirst()];

        return res;
    }
}