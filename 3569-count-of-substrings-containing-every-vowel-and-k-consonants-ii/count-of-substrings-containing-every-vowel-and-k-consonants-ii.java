class Solution {
    public long countOfSubstrings(String word, int k) {
        return solve(word,k)-solve(word,k+1);
    }

    public long solve(String word,int k) {
        int n=word.length();
        int left=0;
        int right=0;
        Map<Character,Integer> map=new HashMap<>();
        long cnt=0;
        int consonantsCnt=0;

        while (right<n) {
            char ch=word.charAt(right);
            if (isVowel(ch)) {
                map.putIfAbsent(ch,0);
                map.put(ch,map.get(ch)+1);
            } else {
                consonantsCnt++;
            }

            while (map.size()==5 && consonantsCnt>=k) {
                cnt+=(long)(word.length()-right);

                char leftChar=word.charAt(left);
                if (isVowel(leftChar)) {
                    if (map.get(leftChar)==1)
                        map.remove(leftChar);
                    else
                        map.put(leftChar,map.get(leftChar)-1);
                } else {
                    consonantsCnt--;
                }

                left++;
            }

            right++;
        }

        return cnt;
    }

    public boolean isVowel(char ch) {
        return ((ch=='a') || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
}