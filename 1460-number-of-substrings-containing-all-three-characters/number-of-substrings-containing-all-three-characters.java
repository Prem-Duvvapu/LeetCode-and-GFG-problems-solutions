class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] lastSeen=new int[3];
        Arrays.fill(lastSeen,-1);
        int res=0;
        
        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            lastSeen[ch-'a']=i;

            if (lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1) {
                int startIndex=Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
                res+=(1+startIndex);
            }
        }

        return res;
    }
}

/*
n=6
s = "a b c a b c"
     0 1 2 3 4 5

cnt=1+2+3+4=10

a=3
b=4
c=5

startPoint=min(a,b,c)

endPoint=max(a,b,c)
*/