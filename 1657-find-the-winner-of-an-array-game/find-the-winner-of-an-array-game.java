class Solution {
    public int getWinner(int[] arr, int k) {
        int n=arr.length;
        int ans=arr[0];
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();

        int maxVal=arr[0];
        for (int val: arr)
        {
            list.add(val);
            maxVal=Math.max(maxVal,val);
        }

        while (true)
        {
            if (list.get(0)==maxVal || list.get(1)==maxVal)
                return maxVal;
            if (list.get(0)>list.get(1))
            {
                map.put(list.get(0),map.getOrDefault(list.get(0),0)+1);
                if (map.get(list.get(0))==k)
                    return list.get(0);
                int temp=list.get(1);
                list.remove(1);
                list.add(temp);
            }
            else
            {
                map.put(list.get(1),map.getOrDefault(list.get(1),0)+1);
                if (map.get(list.get(1))==k)
                    return list.get(1);
                int temp=list.get(0);
                list.remove(0);
                list.add(temp);
            }
        }
    }
}