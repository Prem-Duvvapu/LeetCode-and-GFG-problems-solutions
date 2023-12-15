class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set=new HashSet<>();
        String res="";
        for (List<String> l: paths)
        {
            for (String s: l)
            {
                if (set.contains(s))
                    set.remove(s);
                else
                    set.add(s);
            }
        }

        for (List<String> l: paths)
            if (set.contains(l.get(1)))
                res=l.get(1);

        return res;
    }
}