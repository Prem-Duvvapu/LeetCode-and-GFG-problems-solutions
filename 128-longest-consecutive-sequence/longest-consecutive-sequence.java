//Optimal
class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if (n==0)
            return 0;

        int longest=1;
        Set<Integer> set=new HashSet<>();

        for (int i=0;i<n;i++)
            set.add(nums[i]);

        for (int e: set) {
            int currElement = e;
            int prevElement = currElement-1;
            int nextElement = currElement+1;
            int currCnt=1;

            if (!set.contains(prevElement)) {
                while (set.contains(nextElement)) {
                    nextElement+=1;
                    currCnt+=1;
                }
            }

            longest=Math.max(longest,currCnt);
        }

        return longest;
    }
}