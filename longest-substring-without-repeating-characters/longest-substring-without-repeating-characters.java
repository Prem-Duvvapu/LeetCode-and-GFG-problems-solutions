class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        Map<Character,Integer> map=new HashMap<>();
        int left=0;

        for (int right=0;right<s.length();right++)
        {
            char ch=s.charAt(right);

            if (map.containsKey(ch))
                left=Math.max(left,map.get(ch)+1);//try for acca and abcab
                
            map.put(ch,right);
            res=Math.max(right-left+1,res);
        }
        
        return res;
    }
}