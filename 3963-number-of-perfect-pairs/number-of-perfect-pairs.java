class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long res  = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for (int val: nums) {
            int absVal = Math.abs(val);
            map.put(absVal, map.getOrDefault(absVal,0) + 1);
        }

        int[][] arr = new int[map.size()][3];
        int pos = 0;
        Map<Integer,Integer> map2 = new HashMap<>();
        for (Map.Entry<Integer,Integer> m: map.entrySet()) {
            arr[pos][0] = m.getKey();
            arr[pos][1] = m.getValue();
            map2.put(m.getKey(),pos);
            pos++;
        }

        int m = arr.length;
        arr[m-1][2] = arr[m-1][1];
        for (int i=m-2;i>=0;i--)
            arr[i][2] += (arr[i+1][2] + arr[i][1]);

        for (int i=m-1;i>0;i--) {
            int x = arr[i][0];
            int y = (x-1)/2;
            int nextIndex = map2.get(map.higherKey(y));

            res += (arr[nextIndex][2] - arr[i][2]) * (long)arr[i][1];
        }

        for (int i=m-1;i>=0;i--)
            res += ((long)(arr[i][1] - 1) * (arr[i][1]))/(long)2;

        return res;
    }
}