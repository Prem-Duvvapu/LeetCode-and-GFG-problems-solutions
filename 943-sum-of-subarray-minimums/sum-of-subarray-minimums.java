class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long res=0;
        long mod=(long)1e9+7;
        int[] pse=new int[n]; //O(n)
        int[] nse=new int[n]; //O(n)

        Arrays.fill(pse,-1);
        Arrays.fill(nse,n);

        calcPreviousSmaller(arr,pse);
        calcNextSmaller(arr,nse);

        for (int i=0;i<n;i++) { //O(n)
            long numOfStarts=i-pse[i];
            long numOfEnds=nse[i]-i;
            long numOfSubArrays=numOfStarts*numOfEnds;
            long currTotalMin=arr[i]*numOfSubArrays;
            // System.out.println(i+" "+arr[i]+" "+numOfSubArrays+" "+currTotalMin);

            res=(res+currTotalMin)%mod;
        }

        return (int)res;
    }

    public void calcPreviousSmaller(int[] arr,int[] pse) { //O(2*n)
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();

        for (int i=n-1;i>=0;i--) {
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
                int index=stack.pop();
                pse[index]=i;
            }

            stack.push(i);
        }
    }

    public void calcNextSmaller(int[] arr,int[] nse) { //O(2*n)
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
                int index=stack.pop();
                nse[index]=i;
            }

            stack.push(i);
        }
    }
}


/*
Time: O(n)+O(2*n)+O(2*n)
Space: O(2*n)+O(n)(stack)
arr = [3,1,2,4]
       0 1 2 3

pse[] = [-1,-1,1,2]
nse[] = [1,4,4,4]

no. of starting points = currIndex - pse[currIndex]  = 1 - pse[1] = 1 - (-1) = 2
no. of ending points = nse[currIndex] - currIndex = nse[1]-1 = 4-1 = 3 

2*3 = 6

stop if you encounter a value which is less than currVal(near smaller element to left)
stop if you encounter a value which is les than currVal(near smallest element to right)

currVal has some index
I went to left till my currVal is minimum -> I got my starting point of subarray to index
I went to right till my currVal is minimum -> index to I got my ending point of subarray

//3
3

//1
possible starting points of subarrays = 2
[3]
[1]

possible ending points of subarrays = 3
[1]
[2]
[4]

total subarray = no. of starting points * no. of ending points = 2*3 = 6
[3][1] -> [3,1]
[3][2] -> [3,1,2]
[3][4] -> [3,1,2,4]

[1][1] -> [1]
[1][2] -> [1,2]
[1][4] -> [1,2,4]

//2
2
2,4

//4
4

3        -  3
3,1      -  1
3,1,2    -  1
3,1,2,4  -  1

1       -   1
1,2    -    1
1,2,4    -  1

2      -    2
2,4     -   2

4      -    4

3 -> 1
1 -> 6
2 -> 2
4 -> 1

3*1 + 1*6 + 2*2 + 4*1 = 17

straight forward -> subarray to minimum
optimal approach -> minimum val. for how many subarrays


*/