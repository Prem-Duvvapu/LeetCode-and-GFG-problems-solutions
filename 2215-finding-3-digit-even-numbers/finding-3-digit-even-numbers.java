class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> res=new ArrayList<>();
        int[] digitsFreq=new int[10];

        for (int digit: digits)
            digitsFreq[digit]++;

        int temp=0;
        int[] currDigitsFreq=new int[10];

        for (int num=100;num<999;num+=2) {
            temp=num;
            currDigitsFreq=new int[10];

            while (temp>0) {
                int lastDigit=temp%10;
                currDigitsFreq[lastDigit]++;

                if (digitsFreq[lastDigit]<currDigitsFreq[lastDigit])
                    break;

                temp=temp/10;
            }

            if (temp==0)
                res.add(num);
            Arrays.fill(currDigitsFreq,0);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}