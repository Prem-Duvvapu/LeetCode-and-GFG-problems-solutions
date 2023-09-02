class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n=s1.length();
        String a="";
        String b="";
        String c="";
        String d="";
        
        for (int i=0;i<n;i++)
        {
            char ch=s1.charAt(i);
            if (i%2==0)
                a+=ch;
            else
                c+=ch;
        }
        
        for (int i=0;i<n;i++)
        {
            char ch=s2.charAt(i);
            if (i%2==0)
                b+=ch;
            else
                d+=ch;
        }
        
        return (isAnagram(a,b) && isAnagram(c,d));
    }
    
    private boolean isAnagram(String a,String b)
    {
        int[] cnt=new int[26];
        for (char ch: a.toCharArray())
            cnt[ch-'a']++;
        
        for (char ch: b.toCharArray())
            cnt[ch-'a']--;
        
        for (int val: cnt)
            if (val!=0)
                    return false;
        
        return true;
    }
}