class Solution {
    public String countAndSay(int n) {
        if (n==1)
            return "1";

        String prev=countAndSay(n-1);
        StringBuilder curr=new StringBuilder();
        int i=0;

        while (i<prev.length()) {
            char ch=prev.charAt(i);
            int j=i+1;

            while (j<prev.length() && prev.charAt(j)==ch)
                j++;
            
            int cnt=j-i;
            curr.append(cnt).append(ch);
            i=j;
        }

        return curr.toString();
    }
}