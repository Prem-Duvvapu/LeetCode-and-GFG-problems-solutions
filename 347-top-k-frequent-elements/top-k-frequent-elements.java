class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[k];
        Map<Integer,Integer> freqMap=new HashMap<>();
        List<Integer>[] freqList=new ArrayList[n+1];
        
        for (int val: nums)
            freqMap.put(val,freqMap.getOrDefault(val,0)+1);

        for (Map.Entry<Integer,Integer> m: freqMap.entrySet()) {
            int element=m.getKey();
            int freq=m.getValue();

            if (freqList[freq]==null)
                freqList[freq]=new ArrayList<>();

            freqList[freq].add(element);
        }

        int pos=0;
        for (int freq=n;freq>=1;freq--) {
            if (pos==k)
                break;

            if (freqList[freq]==null)
                continue;

            for (int ele: freqList[freq]) {
                if (pos==k)
                    break;

                res[pos]=ele;
                pos++;
            }
        }

        return res;
    }
}