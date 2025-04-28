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

        List<Integer> resList=new ArrayList<>();
        for (int freq=n;freq>=1;freq--)
            if (freqList[freq]!=null)
                resList.addAll(freqList[freq]);
        
        for (int i=0;i<k;i++)
            res[i]=resList.get(i);

        return res;
    }
}