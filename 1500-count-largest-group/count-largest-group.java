class Solution {
    public int countLargestGroup(int n) {
        Map<Integer,Integer> map=new HashMap<>();
        int maxGroupSize=0;
        int groupsCnt=0;

        for (int num=1;num<=n;num++) {
            int temp=num;
            int sumOfDigits=0;

            while (temp>0) {
                int lastDigit=temp%10;
                sumOfDigits+=lastDigit;
                temp/=10;
            }

            map.put(sumOfDigits,map.getOrDefault(sumOfDigits,0)+1);
        }

        for (int freq: map.values()) {
            if (freq>maxGroupSize) {
                maxGroupSize=freq;
                groupsCnt=1;
            } else if (freq==maxGroupSize) {
                groupsCnt++;
            }
        }

        return groupsCnt;
    }
}