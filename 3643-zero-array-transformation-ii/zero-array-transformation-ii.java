class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;

        if (checkAllZeroes(nums,n))
            return 0;

        int res=-1;
        int low=0;
        int high=queries.length-1;

        while (low<=high) {
            int mid=low+(high-low)/2;
            if (solve(nums,queries,mid)) {
                res=mid+1;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return res;
    }

    public boolean solve(int[] nums,int[][] queries,int k) {
        int n=nums.length;
        int[] diff=new int[n];

        for (int q=0;q<=k;q++) {
            int start=queries[q][0];
            int end=queries[q][1];
            int val=queries[q][2];

            diff[start]+=val;
            if (end+1<n)
                diff[end+1]-=val;
        }

        for (int i=1;i<n;i++)
            diff[i]+=diff[i-1];

        return check(nums,diff,n);
    }

    public boolean check(int[] nums,int[] diff,int n) {
        for (int i=0;i<n;i++)
            if (diff[i]-nums[i]<0)
                return false;
        return true;
    }

    public boolean checkAllZeroes(int[] nums,int n) {
        for (int i=0;i<n;i++)
            if (nums[i]!=0)
                return false;

        return true;
    }
}

/*
ans possibilites 
not possible -> -1
min possible ans -> 0
max possible ans -> queries.length

1. -> queries.length

1. mid queries.length

nums = [2,0,2]

[1,0,1]
[0,0,0]

queries = [
    [0,2,1],
    [0,2,1],
    [1,1,3]]


n queries
1
2
3
4


n
[0,n-1,val]




for (q=0;q<q.length;q++) {

    update numsarray O(n)
}




[0, 0, 0, 0, 0, 0]
 0. 1. 2. 3. 4. 5

first step -> start to last add the number [0, 5, 5, 5, 5, 5]
seond step -> end+1 to last subtact the number [0, 5, 5, 5, 0, 0]

 0. 1  2. 3. 4. 5
[0, 0, 0, 0, 0, 0]
[0, 5, 0, 0, -5, 0] [1,3,5]
[6, 5, 0, -6, -5, 0] [0,2,6]
[6, 5, 9, -6, -5, 0] [2,5,9]
[6, 12, 9, -6, -5, -7] [1,4,7]

O(total queries)+O(n)

[6, 18, 27, 21, 16, 9]


[1,3,5]
[0,2,6]
[2,5,9]
[1,4,7]


[6,11,20,14,9,9]

//Difference Array technique
Time: O(n) Space:O(n)


[2,0,2]

[0,0,0]
[5, 1, 4]

diff[i]-nums[i]>=0
*/