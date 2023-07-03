class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length()<2 || (s.length()!=goal.length()))
            return false;

        int cnt=0;
        int i1=-1;
        int i2=-1;

        if (s.equals(goal))
        {
            int[] arr=new int[26];
            for (char ch: s.toCharArray())
            {
                arr[ch-'a']++;
                if (arr[ch-'a']>=2)
                    return true;
            }
        }

        for (int i=0;i<s.length();i++)
        {
            if (s.charAt(i)!=goal.charAt(i))
            {
                if (i1==-1)
                    i1=i;
                else
                    i2=i;
                cnt++;
                if (cnt>2)
                    return false;
            }
        }

        if (cnt==2 && s.charAt(i1)==goal.charAt(i2) && s.charAt(i2)==goal.charAt(i1))
            return true;
        
        return false;
        
    }
}