class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set=new HashSet<>();

        for (int num: nums) {
            int temp=num;

            for (int i=2;i*i<=temp;i++) {
                if (temp%i==0) {
                    set.add(i);

                    while (temp%i==0)
                        temp/=i;
                }
            }

            if (temp>1)
                set.add(temp);
        }

        return set.size();
    }
}