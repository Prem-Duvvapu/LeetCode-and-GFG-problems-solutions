//Optimal
//Time: O(n)
//Space: O(1)

class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int res=1;
        int peak=0;
        int down=0;
        int i=1;

        while (i<n) {
            while (i<n && ratings[i]==ratings[i-1]) {
                res+=1;
                i++;
                continue;
            }

            peak=1;
            while (i<n && ratings[i]>ratings[i-1]) {
                peak+=1;
                res+=peak;
                i++;
            }

            down=1;
            while (i<n && ratings[i]<ratings[i-1]) {
                res+=down;
                i++;
                down++;
            }

            if (down>peak)
                res=res+(down-peak);
        }

        return res;
    }
}