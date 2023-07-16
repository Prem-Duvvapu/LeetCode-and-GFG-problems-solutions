class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr=word.toCharArray();
        int n=word.length();
        int left=0;
        int right=0;

        for (;right<n;right++)
            if (arr[right]==ch)
                break;

        if (right==n)
            return word;

        while (left<right)
        {
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }

        return new String(arr);
    }
}