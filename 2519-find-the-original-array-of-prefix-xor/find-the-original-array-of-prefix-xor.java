class Solution {
    public int[] findArray(int[] pref) {
        int n=pref.length;
        int[] arr=new int[n];
        arr[0]=pref[0];

        for (int i=n-1;i>0;i--)
            arr[i]=pref[i-1]^pref[i];

        return arr;
    }
}

//a^b=c => a^c=b