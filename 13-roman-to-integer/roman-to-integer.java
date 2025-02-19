class Solution {
    public int romanToInt(String s) {
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int res=0;
        char high='I';

        for (int i=n-1;i>=0;i--) {
            char curr=s.charAt(i);

            if (map.get(curr)>=map.get(high)) {
                high=curr;
                res+=map.get(curr);
            } else {
                res-=map.get(curr);
            }
        }

        return res;
    }
}