class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n=s.length();
        int[] arr=new int[26];
        Arrays.fill(arr,-1);
        int maxLength=-1;

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if (arr[ch-'a']==-1)
                arr[ch-'a']=i;
            else 
                maxLength=Math.max(maxLength,i-arr[ch-'a']-1);
        }

        return maxLength;
    }
}