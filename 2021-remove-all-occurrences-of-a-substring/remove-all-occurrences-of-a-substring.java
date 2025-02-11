class Solution {
    public String removeOccurrences(String s, String part) {
        int n=s.length();
        int m=part.length();
        StringBuilder res=new StringBuilder();

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            res.append(ch);
            if (res.length()>=m && ch==part.charAt(m-1)) {
                int p1=res.length()-1;
                int p2=m-1;

                while (p1>=0 && p2>=0) {
                    if (res.charAt(p1)==part.charAt(p2)) {
                        p1--;
                        p2--;
                    } else {
                        break;
                    }
                }

                if (p2<0)
                    res=res.delete(p1+1,p1+1+m);
            }
        }

        return res.toString();
    }
}