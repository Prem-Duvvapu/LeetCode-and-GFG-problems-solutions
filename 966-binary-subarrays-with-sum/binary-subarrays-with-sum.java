class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int res=0;
        int currSum=0;

        for (int i=0;i<n;i++) {
            currSum+=nums[i];
            int diff=currSum-goal;
            if (map.containsKey(diff))
                res+=map.get(diff);
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }

        return res;
    }
}

/*
brute - time: O(n^2), space: O(1)
better - prefix sum time: O(n), space: O(n)

map={0,2},{1,2},{2,2}
ans=2+2+2
nums = [0, 1, 0, 1, 0, 1], goal = 2
sum=    0. 1. 1. 2  2. 3

map={0,1},{1,2},{2,2}
res=0+1+1+2
 nums = [1,0,1,0,1], goal = 2
sum =    1 1.2 2 3

{0,1}
[0,1,1,1,1,1]
*/