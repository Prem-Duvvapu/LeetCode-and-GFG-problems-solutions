class Solution {
    public int getWinner(int[] arr, int k) {
        int n=arr.length;
        int ans=arr[0];
        Map<Integer,Integer> map=new HashMap<>();

        int maxVal=arr[0];
        for (int val: arr)
            maxVal=Math.max(maxVal,val);

        int i=0;
        int j=1;

        while (true)
        {
            if (arr[i]==maxVal || arr[j]==maxVal)
                return maxVal;
            if (arr[i]>arr[j])
            {
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                if (map.get(arr[i])==k)
                    return arr[i];
                
                j=(Math.max(i,j)+1)%n;
            }
            else
            {
                map.put(arr[j],map.getOrDefault(arr[j],0)+1);
                if (map.get(arr[j])==k)
                    return arr[j];
                
                i=(Math.max(i,j)+1)%n;
            }
        }
    }
}