class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n=arr.length;
        int cnt=0;

        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                for (int k=j+1;k<n;k++) {
                    boolean check1=(Math.abs(arr[i]-arr[j])<=a);
                    boolean check2=(Math.abs(arr[j]-arr[k])<=b);
                    boolean check3=(Math.abs(arr[k]-arr[i])<=c);

                    if (check1 && check2 && check3)
                        cnt++;
                }
            }
        }

        return cnt;
    }
}