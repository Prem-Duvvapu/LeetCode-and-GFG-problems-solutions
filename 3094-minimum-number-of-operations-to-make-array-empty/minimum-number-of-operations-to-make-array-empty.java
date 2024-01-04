class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int val: nums) {
            if (!map.containsKey(val))
                map.put(val,0);
            map.put(val,map.get(val)+1);
        }

        System.out.println(map);

        int ops=0;
        for (Map.Entry<Integer,Integer> m: map.entrySet()) {
            if (m.getValue()==1)
                return -1;

            int curr=m.getValue();
            int rem=curr%3;
            if (rem==0) {
                ops+=(curr/3);
                continue;
            }
            else if (rem==1) {
                int temp=curr/3-1;
                ops+=temp;
                curr=curr-3*temp;
            }
            else {
                int temp=curr/3;
                ops+=temp;
                curr=curr-3*temp;
            }
            
            ops+=(curr/2);
        }

        return ops;
    }
}