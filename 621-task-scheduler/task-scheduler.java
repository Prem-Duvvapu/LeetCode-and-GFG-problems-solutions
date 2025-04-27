class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        int total=tasks.length;
        
        for (char ch: tasks)
            freq[ch-'A']++;

        Arrays.sort(freq);
        reverse(freq);
        int maxFreq=freq[0];
        int maxFreqCnt=1;
        int i=1;

        while (i<26 && freq[i]==freq[i-1]) {
            maxFreqCnt++;
            i++;
        }

        int res=(n+1)*(maxFreq-1)+maxFreqCnt;
        res=Math.max(res,total);
        return res;
    }

    public void reverse(int[] arr) {
        int low=0;
        int high=arr.length-1;

        while (low<high) {
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;

            low++;
            high--;
        }
    }
}