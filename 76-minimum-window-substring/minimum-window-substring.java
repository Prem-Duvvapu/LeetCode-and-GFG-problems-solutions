class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();

        if (t.length()>n)
            return "";

        Map<Character,Integer> map=new HashMap<>();
        int minWindowSize=Integer.MAX_VALUE;
        int requiredCount=t.length();
        int left=0,right=0;
        int startIndex=0;

        for (char ch: t.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);

        while (right<n) {
            char curr=s.charAt(right);

            if (map.getOrDefault(curr,0)>0)
                requiredCount--;

            map.put(curr,map.getOrDefault(curr,0)-1);

            while (requiredCount==0) {
                int currWindowSize=right-left+1;
                if (currWindowSize<minWindowSize) {
                    minWindowSize=currWindowSize;
                    startIndex=left;
                }
                
                char leftChar=s.charAt(left);
                map.put(leftChar,map.getOrDefault(leftChar,0)+1);
                if (map.get(leftChar)>0)
                    requiredCount++;
                left++;
            }

            right++;
        }

        if (minWindowSize==Integer.MAX_VALUE)
            return "";

        return s.substring(startIndex,startIndex+minWindowSize);
    }
}