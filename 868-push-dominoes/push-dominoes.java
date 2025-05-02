class Solution {
    public String pushDominoes(String dominoes) {
        int n=dominoes.length();
        char[] res=dominoes.toCharArray();

        int[] Ldist=new int[n];
        int[] Rdist=new int[n];

        Arrays.fill(Ldist,Integer.MAX_VALUE);
        Arrays.fill(Rdist,Integer.MAX_VALUE);

        int Lpos=Integer.MAX_VALUE;
        int Rpos=Integer.MAX_VALUE;

        for (int i=n-1;i>=0;i--) {
            if (dominoes.charAt(i) == 'L')
                Lpos = i;
            else if (dominoes.charAt(i) == 'R')
                Rpos = i;
            else if (dominoes.charAt(i)=='.') {
                if (Lpos!=Integer.MAX_VALUE && Lpos<Rpos)
                    Ldist[i]=Lpos-i;
            }
        }

        Lpos=-1;
        Rpos=Integer.MAX_VALUE;
        for (int i=0;i<n;i++) {
            if (dominoes.charAt(i) == 'L')
                Lpos = i;
            else if (dominoes.charAt(i) == 'R')
                Rpos = i;
            else if (dominoes.charAt(i)=='.') {
                if (Rpos!=Integer.MAX_VALUE && Rpos>Lpos)
                    Rdist[i]=i-Rpos;
            }
        }

        for (int i=0;i<n;i++) {
            if (res[i]=='.') {
                if (Ldist[i]<Rdist[i])
                    res[i]='L';
                else if (Rdist[i]<Ldist[i])
                    res[i]='R';
            }
        }

        return new String(res);
    }
}