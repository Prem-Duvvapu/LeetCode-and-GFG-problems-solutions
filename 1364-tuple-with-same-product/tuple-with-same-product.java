class Solution {
    public int tupleSameProduct(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> productFreq=new HashMap<>();
        int resCnt=0;

        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                int product=nums[i]*nums[j];

                if (!productFreq.containsKey(product))
                    productFreq.put(product,1);
                else
                    productFreq.put(product,productFreq.get(product)+1);
            }
        }

        for (Map.Entry<Integer,Integer> m: productFreq.entrySet()) {
            int val=m.getValue();
            int sum=0;
            for (int i=1;i<val;i++)
                sum+=i;
            resCnt+=(8*sum);
        }

        return resCnt;
    }
}