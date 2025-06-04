class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[] freq=new int[256];
        int left=0;
        int right=0;
        int cnt=0;
        int minLen=(int)1e6;
        int currLen=0;
        int startIndex=-1;

        for (char ch: t.toCharArray())
            freq[ch]--;

        while (right<n) {
            char ch=s.charAt(right);
            freq[ch]++;

            if (freq[ch]<=0)
                cnt++;

            while (cnt==m) {
                currLen=right-left+1;
                if (currLen<minLen) {
                    minLen=currLen;
                    startIndex=left;
                }

                char leftChar=s.charAt(left);
                freq[leftChar]--;

                if (freq[leftChar]<0)
                    cnt--;

                left++;
            }

            right++;
        }

        if (startIndex==-1)
            return "";

        return s.substring(startIndex,startIndex+minLen);
    }
}


/*
time: O(m) + O(n) + O(n)
space: o(1)

find substring which satifies the constraints

t = "A B C" t.length=m=4
     0 1 3

s = "A D O B E C O D E B A  N  C" s.length=n
     0 1 2 3 4 5 6 7 8 9 10 11 12
                               r
                         l

hash[256]
0.......A B c.. D  ..E...O..N..255
        0 1 0    0   0   0  -1
        
after reducing if the freq of char is grater than or equal to zero

reduce the frequency by hashmap
1. positive val (I need these many of that character)
2. zero (I don't require and I also didn't got)
3. negative val -> (I don't require but I got(extra))

cnt=2 //compare this with m
0 need m but I have 0
1 need m but I have 1
.
.
m need m I got m


left=0
right=0
minLen=4
currLen=r-l+1 = 4
startIndex=l=9



*/