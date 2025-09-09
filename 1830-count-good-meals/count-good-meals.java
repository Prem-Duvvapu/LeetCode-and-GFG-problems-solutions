class Solution {
    public static final int MOD = (int)1e9 + 7;
    public int countPairs(int[] deliciousness) {
        int n = deliciousness.length;
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int[] powerOf2 = new int[22];

        int val = 1;
        for (int i=0;i<powerOf2.length;i++) {
            powerOf2[i] = val;
            val*=2;
        }

        for (int i=0;i<n;i++) {
            for (int sum: powerOf2) {
                int req  = sum - deliciousness[i];
                if (map.containsKey(req))
                    cnt = (cnt + (map.get(req)))%MOD;
            }
            map.put(deliciousness[i],map.getOrDefault(deliciousness[i],0)+1);
        }

        return cnt;
    }
}

/*
0 <= val <= 2^20
all are positive elements

sum == power of 2
cnt = 0

//brute
for (int i=0;i<n;i++) {
    for (int j=i+1;j<n;j++) {
        int sum = arr[i] + arr[j];
        if (sum is power of 2)
            cnt++;
    }
}

return cnt;

time: O(n^2)
space: O(1)

possible values of sum = [2^0, 2^1,2^2,......,2^20](21 elements)

map = {}

(3,2)
  [1,3,5,7,9]

x + y = somepowerOf2 
x = somepowerof2 - y 

2^0 -1 
2^1 - 1


2^20-1

(e1, e2)
(   ,1)

for (i=0 to n-1) {
    // 20
}

O(n*20) = O(n)
*/
