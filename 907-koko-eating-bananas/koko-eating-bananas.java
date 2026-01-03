class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = Integer.MIN_VALUE;;
        for(int i=0;i<piles.length;i++){
            if(piles[i]>maxValue) maxValue = piles[i];
        }

        int low = 1;
        int high = maxValue;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            long sum = findSum(mid, piles);
            if (sum <= h) {
                ans = mid; // possible answer
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
       
        
        // for(int k=1;k<=maxValue;k++){ //10^9
        //    long sum = findSum(k, piles);
        //    if(sum<=h){
             
        //      return k;
        //    }
        // }
    }

    public long  findSum(int k, int piles[]){
        long sum =0;
        for(int j=0;j<piles.length;j++){ // 10^4
             // find value for each pile
             int pile = piles[j];
             int findHours = pile/k; // 10^9
             int remainder = pile % k; // 0
             if(remainder!=0) findHours++;
             sum = sum + findHours; // sum = 0+10^9
           }

           return sum;
    }

}
// 1) what this method shluld return(sum ), type(long) ? 
// 2) findHour we need
// 10^4.  10^4 * 10^9 = 10^13
// [10^9,10^9,......]
// h=10^9
// k=1

// Steps:
// 1) we will start with k=1 to max value in array
// 2) find max
// 3) 


// 1) element/k + 1
// k=10, elemtn = 9
// 9/10 = 0+ 9

// add 1 only when you do not get 0.

// piles of banannas -> [3,6,7,11]
// h= 8

// k=100 , a= 4 
// k=50  a=4
// k=20 a=4
// k=13 a=4
// k=12 a=4

// k=11 a=4
// k= 10, a=5

// k= 9 a=5
// k=8. a= 5
// k=7. a= 5
// k=6  a= 6
// k=5 a= 8  1,2,2,3.  -> 11/5 + 11%5 = 2+1 = 3
// k=4  a=. 8   1, 2, 2, 3
// k= 3 , a= 1+2+3+4 = 10
// k= 2. a=2+3+4+6 = 15
// k=1 a=27

// a<=h

// 4,5,6,7,8,9,10,11,12,20,...100