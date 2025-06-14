class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int minCandies=1;
        int pos=1;

        while (pos<n) {
            //plain slope
            while (pos<n && ratings[pos]==ratings[pos-1]) {
                minCandies+=1;
                pos++;
            }

            //upwards slope
            int peak=1;
            while (pos<n && ratings[pos]>ratings[pos-1]) {
                peak++;
                minCandies+=peak;
                pos++;
            }

            //downwards slope
            int down=1;
            while (pos<n && ratings[pos]<ratings[pos-1]) {
                minCandies+=down;
                down++;
                pos++;
            }

            if (down>peak)
                minCandies+=(down-peak);
        }

        return minCandies;
    }
}