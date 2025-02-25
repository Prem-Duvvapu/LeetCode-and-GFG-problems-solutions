class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int n=croakOfFrogs.length();
        Map<Character,Integer> map=new HashMap<>();
        int cnt=0;
        int res=0;

        map.put('c',0);
        map.put('r',0);
        map.put('o',0);
        map.put('a',0);
        map.put('k',0);

        for (int i=0;i<n;i++) {
            char ch=croakOfFrogs.charAt(i);
            map.put(ch,map.get(ch)+1);
            if (ch=='r'&& map.get('c')<map.get('r'))
                return -1;
            else if (ch=='o' && (map.get('c')<map.get('o') || map.get('r') < map.get('o')))
                return -1;
            else if (ch=='a' && (map.get('c')<map.get('a') || map.get('r') < map.get('a') || map.get('o')<map.get('a')))
                return -1;
            else if (ch=='k'&& (map.get('c')<map.get('k') || map.get('r')<map.get('k') || map.get('o')<map.get('k')|| map.get('a')<map.get('k')))
                return -1;
                
            if (ch=='c')
                cnt++;
            else if (ch=='k') {
                res=Math.max(res,cnt);
                cnt--;
                if (map.get('c')==0 || map.get('r')==0 || map.get('o')==0 || map.get('a')==0 || map.get('k')==0)
                    return -1;

                map.put('c',map.get('c')-1);
                map.put('r',map.get('r')-1);
                map.put('o',map.get('o')-1);
                map.put('a',map.get('a')-1);
                map.put('k',map.get('k')-1);
            }
        }

        if (map.get('c')!=0 || map.get('r')!=0 || map.get('o')!=0 || map.get('a')!=0 || map.get('k')!=0)
                    return -1;

        return res;
    }
}