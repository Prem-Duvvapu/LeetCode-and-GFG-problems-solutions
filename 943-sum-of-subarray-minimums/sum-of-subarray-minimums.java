class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long cnt=0;
        long mod=(long)1e9+7;

        for (int i=0;i<n;i++) {
            int leftCnt=0;
            int rightCnt=1;

            for (int j=i;j>=0;j--) {
                if (arr[j]>=arr[i])
                    leftCnt++;
                else
                    break;
            }

            for (int k=i+1;k<n;k++) {
                if (arr[k]>arr[i])
                    rightCnt++;
                else
                    break;
            }

            long val=arr[i]*((long)leftCnt*rightCnt);
            val%=mod;
            cnt=(cnt+val)%mod;
        }

        return (int)cnt;
    }
}


/*
arr  = [2, 6, 4, 3, 5, 1]

arr = [3 ,1, 2, 4]
       0  1  2  3

ele=1

//left=2
[1]
[3,1]

//right=3
[1]
[1,2]
[1,2,4]

//total
[3,1]
[3,1,2]
[3,1,2,4]
[1]
[1,2]
[1,2,4]



left=1
right=2

cnt=ele*(left*right)


3 - 3
3,1 - 1
3,1,2 - 1
3,1,2,4 - 1

1 - 1
1,2 - 1
1,2,3 - 1

2 - 2
2,4 - 2

4 - 4


1 -> 6
2 -> 2
3 -> 1
4 -> 1

6*1 + 2*2 + 3*1 + 4*1
*/